package com.sda.controller;


import com.sda.dto.UserDTO;
import com.sda.model.User;
import com.sda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Object principal = auth.getPrincipal();
        if (principal != null && principal instanceof User) {
            User user = (User) principal;
            return "Hello " + user.toString() + " " +
                    user.getUsername();
        }
        return "Hello " + auth.getName();
    }

}
