package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "contract_role_act", schema = "public", catalog = "theatre_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractRoleAct {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_act_id", nullable = false)
    private Short role_act_id;

    @Basic
    @Column(name = "act_id", nullable = false)
    private Short act_id;


    @Basic
    @Column(name = "role_id", nullable = false)
    private Short role_id;

}
