package com.example.glitchbusters.service;

import com.example.glitchbusters.dto.MsiGamingDTO;
import java.util.List;
import java.util.Optional;

public interface MsiGamingService {
    MsiGamingDTO saveMsiGaming(MsiGamingDTO msiGamingDTO);
    List<MsiGamingDTO> getAllMsiGaming();
    Optional<MsiGamingDTO> getMsiGamingById(int id);
    void updateMsiGaming(MsiGamingDTO msiGamingDTO);
    void deleteMsiGaming(int id);
}