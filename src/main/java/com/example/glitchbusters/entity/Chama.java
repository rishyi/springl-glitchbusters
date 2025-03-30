package com.example.glitchbusters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "chama")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Chama {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;

    private String name;
    private String description;
    private String price;
    private String qty;
}
