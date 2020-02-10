package com.login.service.loginservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Setter
    @Getter
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
