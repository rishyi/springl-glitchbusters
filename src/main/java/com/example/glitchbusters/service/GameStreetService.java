package com.example.glitchbusters.service;

import com.example.glitchbusters.dto.GameStreetDTO;

import java.util.List;
import java.util.Optional;

public interface GameStreetService {
    GameStreetDTO saveGameStreet(GameStreetDTO gameStreetDTO);

    List<GameStreetDTO> getAllGameStreets();

    Optional<GameStreetDTO> getGameStreetById(int id);

    void updateGameStreet(GameStreetDTO gameStreetDTO);

    void deleteGameStreet(int id);
}
