package com.lemon.wallet.model.persistence;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserPersistenceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="last_name")
    private String lastName;
    @Column(name ="alias", unique = true, nullable = false)
    private String alias;
    @Column(name ="email", unique = true, nullable = false)
    private String email;

    public UserPersistenceDto(Long id, String name, String lastName, String alias, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.alias = alias;
        this.email = email;
    }

    public UserPersistenceDto() {
        //for hibernate
    }

    public Long getId() {
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
