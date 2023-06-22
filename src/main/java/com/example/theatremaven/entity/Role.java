package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private Short role_id;

    @Basic
    @Column(name = "performance_id", nullable = false)
    private Short performance_id;

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;
}
