package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "ticket")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_id", nullable = false)
    private Short ticket_id;

    @Basic
    @Column(name = "performance_id", nullable = false)
    private Short performance_id;

    @Basic
    @Column(name = "viewer_id", nullable = false)
    private Short viewer_id;

    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;

    @Basic
    @Column(name = "type", nullable = false, length = 64)
    private String type;

    @Basic
    @Column(name = "place_number", nullable = false)
    private Short place_number;

    @Basic
    @Column(name = "row_number", nullable = false)
    private Short row_number;
}
