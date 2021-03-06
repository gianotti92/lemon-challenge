package com.lemon.wallet.dto;







import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    private String lastName;
    private String alias;
    private String email;
    private List<TotalBalanceDto> totalBalance;

    public UserDto() {
    }

    public UserDto(Long id, String name, String lastName, String alias, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
    }

    public UserDto(Long id, String name, String lastName, String alias, String email, List<TotalBalanceDto> totalBalance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                ", totalBalance=" + totalBalance +
                '}';
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

    public Long getId() {
        return id;
    }

    public List<TotalBalanceDto> getTotalBalance() {
        return totalBalance;
    }
}
