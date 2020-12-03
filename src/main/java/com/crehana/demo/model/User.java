package com.crehana.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String email;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String dni;

    private String phone;

    @Column(nullable = true)
    private LocalDate birthday;

    private String address;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "membership_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Membership membership;
}
