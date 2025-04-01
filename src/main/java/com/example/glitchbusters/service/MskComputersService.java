package com.example.glitchbusters.service;

import com.example.glitchbusters.dto.MskComputersDTO;

import java.util.List;

public interface MskComputersService {
    MskComputersDTO saveMskComputers(MskComputersDTO mskComputersDTO);
    List<MskComputersDTO> getAllMskComputers();
    void updateMskComputers(MskComputersDTO mskComputersDTO);
    void deleteMskComputers(int id);
}