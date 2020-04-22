package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Category;
import pl.coderslab.model.User;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.CurrentUser;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private CurrentUser currentUser;

    public CategoryController(UserRepository userRepository, CategoryRepository categoryRepository) {
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
    public String saveForm(@Valid Category category, BindingResult result, @AuthenticationPrincipal CurrentUser customUser) {
        if (result.hasErrors()) {
            return "category/form";
        }
        User user = customUser.getUser();
        category.setUser(user);
        categoryRepository.save(category);
        return "redirect:all";
    }

    @RequestMapping("/all")
    public String showAllCategories() {
        return "category/all";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(@AuthenticationPrincipal CurrentUser currentUser) {
        Long id = currentUser.getUser().getId();
        return categoryRepository.findAllByUser_Id(id);
    }


}
