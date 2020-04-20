package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Category;
import pl.coderslab.model.Item;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.ItemRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")

public class CategoryController {

    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public CategoryController(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        Category category = id == null ? new Category() : categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "category/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/form";
        }
        categoryRepository.save(category);
        return "redirect:all";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
