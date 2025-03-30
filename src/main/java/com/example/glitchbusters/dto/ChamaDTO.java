package com.example.glitchbusters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ChamaDTO {
    private int  id;
    private String name;
    private String description;
    private String price;
    private String qty;
}
