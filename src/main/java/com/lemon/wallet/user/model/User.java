package com.lemon.wallet.user.model;

public class User {
    private String name;
    private String surname;
    private String alias;
    private String email;

    public User(String name, String surname, String alias, String email) {
        this.name = name;
        this.surname = surname;
        this.alias = alias;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }
}
