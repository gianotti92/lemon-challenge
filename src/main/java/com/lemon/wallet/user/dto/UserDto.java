package com.lemon.wallet.user.dto;

import java.util.List;

public class UserDto {

    private String name;
    private String lastName;
    private String alias;
    private String email;
    private List<WalletDto> walletBalance;

    public UserDto(String name, String lastName, String alias, String email, List<WalletDto> walletBalance) {
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
        this.walletBalance = walletBalance;
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

    public List<WalletDto> getWalletBalance() {
        return walletBalance;
    }
}
