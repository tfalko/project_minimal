package pl.coderslab.controller;

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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

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
    public String saveForm(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item/form";
        }
        itemRepository.save(item);
        return "redirect:all";
    }


    @RequestMapping("/all")
    @ResponseBody
    public List<Item> showAllItems(){
        return itemRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}
