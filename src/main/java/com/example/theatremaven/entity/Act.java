package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "act")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Act {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "act_id", nullable = false)
    private Short act_id;

    @Basic
    @Column(name = "performance_id", nullable = false)
    private Short performance_id;

    @Basic
    @Column(name = "duration", nullable = false)
    private Short duration;

    @Basic
    @Column(name = "sequence_number", nullable = false)
    private Short sequence_number;
}