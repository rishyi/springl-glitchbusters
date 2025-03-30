package com.example.glitchbusters.controller;

import com.example.glitchbusters.dto.GameStreetDTO;
import com.example.glitchbusters.service.GameStreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/gamestreet")
public class GameStreetController {

    @Autowired
    private GameStreetService gameStreetService;

    @PostMapping("/addGameStreet")
    public ResponseEntity<GameStreetDTO> addGameStreet(@RequestBody GameStreetDTO gameStreetDTO) {
        GameStreetDTO savedGameStreet = gameStreetService.saveGameStreet(gameStreetDTO);
        return ResponseEntity.ok(savedGameStreet);
    }

    @GetMapping("/getAllGameStreets")
    public ResponseEntity<List<GameStreetDTO>> getAllGameStreets() {
        List<GameStreetDTO> gameStreetList = gameStreetService.getAllGameStreets();
        return ResponseEntity.ok(gameStreetList);
    }

    @PutMapping("/updateGameStreet")
    public ResponseEntity<Void> updateGameStreet(@RequestBody GameStreetDTO gameStreetDTO) {
        gameStreetService.updateGameStreet(gameStreetDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteGameStreet/{id}")
    public ResponseEntity<Void> deleteGameStreet(@PathVariable int id) {
        gameStreetService.deleteGameStreet(id);
        return ResponseEntity.ok().build();
    }
}