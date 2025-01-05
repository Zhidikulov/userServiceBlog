package com.example.userServiceBlog.services;

import com.example.userServiceBlog.config.JwtTokenProvider;
import com.example.userServiceBlog.config.UserException;
import com.example.userServiceBlog.modelDB.User;
import com.example.userServiceBlog.modelDTO.UserDTO;
import com.example.userServiceBlog.modelDTO.UserMapper;
import com.example.userServiceBlog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        log.info("registerUser input: user = {}", user);
        if(user == null){
            throw new UserException("Input parameter empty!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return jwtTokenProvider.createToken(username, user.getRole());
    }

    @Override
    public UserDTO getCurrentUser(String token) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        return UserMapper.INSTANCE.toDto(user);
    }

}
