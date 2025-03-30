package com.example.glitchbusters.service.impl;

import com.example.glitchbusters.Repo.GameStreetRepo;
import com.example.glitchbusters.dto.GameStreetDTO;
import com.example.glitchbusters.entity.GameStreet;
import com.example.glitchbusters.service.GameStreetService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameStreetServiceImpl implements GameStreetService {

    @Autowired
    private GameStreetRepo gameStreetRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GameStreetDTO saveGameStreet(GameStreetDTO gameStreetDTO) {
        GameStreet gameStreet = modelMapper.map(gameStreetDTO, GameStreet.class);
        gameStreet = gameStreetRepo.save(gameStreet);
        return modelMapper.map(gameStreet, GameStreetDTO.class);
    }

    @Override
    public List<GameStreetDTO> getAllGameStreets() {
        List<GameStreet> gameStreets = gameStreetRepo.findAll();
        return modelMapper.map(gameStreets, new TypeToken<List<GameStreetDTO>>() {}.getType());
    }

    @Override
    public Optional<GameStreetDTO> getGameStreetById(int id) {
        Optional<GameStreet> gameStreet = gameStreetRepo.findById(id);
        return gameStreet.map(gs -> modelMapper.map(gs, GameStreetDTO.class));
    }

    @Override
    public void updateGameStreet(GameStreetDTO gameStreetDTO) {
        if (gameStreetRepo.existsById(gameStreetDTO.getId())) {
            GameStreet gameStreet = modelMapper.map(gameStreetDTO, GameStreet.class);
            gameStreetRepo.save(gameStreet);
        }
    }

    @Override
    public void deleteGameStreet(int id) {
        gameStreetRepo.deleteById(id);
    }
}