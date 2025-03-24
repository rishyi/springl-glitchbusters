package com.example.glitchbusters.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nanotek")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Nanotek {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;

    private String name;
    private String description;
    private String price;
    private String qty;

}

