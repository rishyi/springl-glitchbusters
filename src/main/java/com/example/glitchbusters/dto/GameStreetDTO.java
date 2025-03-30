package com.example.glitchbusters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameStreetDTO {
    private int id;
    private String name;
    private String description;
    private String price;
    private String qty;
}