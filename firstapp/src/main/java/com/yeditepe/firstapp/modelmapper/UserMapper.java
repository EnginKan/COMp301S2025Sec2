package com.yeditepe.firstapp.modelmapper;

import com.yeditepe.firstapp.controller.dto.userDTO;
import com.yeditepe.firstapp.entity.User;

public class UserMapper {

    public static userDTO toUserDTO(User user) {
     return new userDTO(user.getName(), user.getEmail());
    }

    public static User toUser(userDTO user) {
        return new User(user.getUsername(), user.getEmail());
    }
}
