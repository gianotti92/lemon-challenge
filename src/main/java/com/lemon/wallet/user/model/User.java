package com.lemon.wallet.user.model;

public class User {
    private String id;
    private String name;
    private String lastName;
    private String alias;
    private String email;

    public User(String id, String name, String lastName, String alias, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
    }

    public User(String name, String lastName, String alias, String email) {
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
    }

    public String getId() {
        return id;
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
