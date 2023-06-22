package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "theatre")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Theatre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "theatre_id", nullable = false)
    private Short theatre_id;

    @Basic
    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Basic
    @Column(name = "title", nullable = false, length = 128)
    private String title;

}
