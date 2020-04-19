package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        User user = id == null ? new User() : userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/form";
        }
        userRepository.save(user);
        return "redirect:all";
    }



    @RequestMapping("/all")
    @ResponseBody
    public List<User> showAllUsers(){
        return userRepository.findAll();
    }



//    @ModelAttribute("users")
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }



}
