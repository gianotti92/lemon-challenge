package com.lemon.wallet.user.dto;

import java.util.List;

public class UserDto {

    private String name;
    private String surname;
    private String alias;
    private String email;
    private List<WalletDto> walletBalance;

    public UserDto(String name, String surname, String alias, String email, List<WalletDto> walletBalance) {
        this.name = name;
        this.surname = surname;
        this.alias = alias;
        this.email = email;
        this.walletBalance = walletBalance;
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

    public List<WalletDto> getWalletBalance() {
        return walletBalance;
    }
}
