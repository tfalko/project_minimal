package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Category;
import pl.coderslab.model.Item;
import pl.coderslab.model.User;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.ItemRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    private CurrentUser currentUser;
    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private UserService userService;


    public ItemController(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        Item item = id == null ? new Item() : itemRepository.findById(id).get();
        model.addAttribute("item", item);
        return "item/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@Valid Item item, BindingResult result, @AuthenticationPrincipal CurrentUser customUser) {
        if (result.hasErrors()) {
            return "item/form";
        }

        User user = customUser.getUser();
        item.setUser(user);
        itemRepository.save(item);

        return "redirect:all";
    }


    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }


    @ModelAttribute("items")
    public List<Item> getAllItems(@AuthenticationPrincipal CurrentUser currentUser, HttpServletRequest request){
        Long id = currentUser.getUser().getId();
        return itemRepository.findAllByUser_Id(id);
    }

    @RequestMapping("/all")
    public String tableAll(){
        return "/item/all";
    }



}
