package com.lemon.wallet.dto;

import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    private String lastName;
    private String alias;
    private String email;

    public UserDto(Long id, String name, String lastName, String alias, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

}
