package com.example.userServiceBlog.modelDTO;

import lombok.*;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    public String username;
    public String password;
    public String email;
    public String role;

}
