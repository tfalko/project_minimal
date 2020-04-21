package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.User;

import java.util.List;


public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
    
}
