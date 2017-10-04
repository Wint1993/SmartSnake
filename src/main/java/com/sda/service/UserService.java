package com.sda.service;

import com.sda.dto.UserDTO;
import com.sda.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO create(UserDTO userDTO);
}
