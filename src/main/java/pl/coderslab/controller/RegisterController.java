package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.UserService;
import pl.coderslab.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {
    private UserRepository userRepository;

    //private final UserService userService;


    UserServiceImpl userService;

    public RegisterController(UserRepository userRepository,  UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model, HttpSession session) {
        User user = id == null ? new User() : userRepository.findById(id).get();
        model.addAttribute("user", user);

        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String saveForm(@Valid User user, BindingResult result, Long id, HttpSession session) {
        if (result.hasErrors()) {
            return "register";
        }
//        session.setAttribute("cu", currentUser);
//        session.setAttribute("user", currentUser.getUser());

        userService.saveUser(user);
        return "redirect:/";
    }

}
