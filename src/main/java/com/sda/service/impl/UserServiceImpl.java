package com.sda.service.impl;

import com.sda.dto.UserDTO;
import com.sda.mapper.UserMapper;
import com.sda.model.User;
import com.sda.repository.UserRepository;
import com.sda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO create(UserDTO userDTO){

        User newUser = userMapper.toUser(userDTO);
        newUser.setUuid(UUID.randomUUID().toString());
        return userMapper.toUserDTO(userRepository.save(newUser));
    }

}
