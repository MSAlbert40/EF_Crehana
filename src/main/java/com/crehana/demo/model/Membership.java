package com.crehana.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "memberships")
@Getter
@Setter
public class Membership extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String period;

    private String description;

    private BigDecimal price;

    private Boolean available;
}
