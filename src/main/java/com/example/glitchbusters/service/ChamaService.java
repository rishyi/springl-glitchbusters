package com.example.glitchbusters.service;

import com.example.glitchbusters.dto.ChamaDTO;

import java.util.List;

public interface ChamaService {
    ChamaDTO saveChama(ChamaDTO chamaDTO);

    List<ChamaDTO> getAllChama();

    void updateChama(ChamaDTO chamaDTO);

    void deleteChama(int id);
}
