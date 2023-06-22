package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "contract_role_actor", schema = "public", catalog = "theatre_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractRoleActor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_actor_id", nullable = false)
    private Short role_actor_id;

    @Basic
    @Column(name = "personnel_number", nullable = false)
    private Short personnel_number;

    @Basic
    @Column(name = "role_id", nullable = false)
    private Short role_id;
}
