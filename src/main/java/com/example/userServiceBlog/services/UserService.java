package com.example.userServiceBlog.services;

import com.example.userServiceBlog.config.UserException;
import com.example.userServiceBlog.modelDB.User;
import com.example.userServiceBlog.modelDTO.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO user);

    String loginUser(String username, String password);

    UserDTO getCurrentUser(String token);
}
