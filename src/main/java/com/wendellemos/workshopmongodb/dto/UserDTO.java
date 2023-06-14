package com.wendellemos.workshopmongodb.dto;

import com.wendellemos.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email= obj.getEmail();
    }
}
