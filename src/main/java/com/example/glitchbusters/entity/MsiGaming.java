package com.example.glitchbusters.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "msigaming")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MsiGaming {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private double price;
}