/*
package com.watchstore.vvbackend.controller;

import com.watchstore.vvbackend.model.User;
import com.watchstore.vvbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("numberPhone") String numberPhone) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setNumberPhone(numberPhone);
        user.setRole(Arrays.asList("ADMIN", "USER", "VIP"));
        userRepository.save(user);
        return "redirect:/login?regisSuccess=true";
    }
}
*/
