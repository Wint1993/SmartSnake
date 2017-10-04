package com.sda.mapper;

import com.sda.dto.UserDTO;
import com.sda.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);

    List<UserDTO> toUserDTOList(List<User> user);
    List<User> toUserList(List<UserDTO> userDTOS);

}
