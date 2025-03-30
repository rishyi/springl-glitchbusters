package com.example.glitchbusters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "gamestreet")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GameStreet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;
    private String price;
    private String qty;
}