package com.example.glitchbusters.controller;

import com.example.glitchbusters.dto.MsiGamingDTO;
import com.example.glitchbusters.service.MsiGamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/msiGaming")
public class MsiGamingController {

    @Autowired
    private MsiGamingService msiGamingService;

    @GetMapping("getAllMsiGaming")
    public List<MsiGamingDTO> getAllMsiGaming() {
        return msiGamingService.getAllMsiGaming();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MsiGamingDTO> getMsiGamingById(@PathVariable int id) {
        return msiGamingService.getMsiGamingById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addMsiGaming")
    public MsiGamingDTO createMsiGaming(@RequestBody MsiGamingDTO msiGamingDTO) {
        return msiGamingService.saveMsiGaming(msiGamingDTO);
    }

    @PutMapping("/updateMsiGaming/{id}")
    public ResponseEntity<MsiGamingDTO> updateMsiGaming(@PathVariable int id, @RequestBody MsiGamingDTO msiGamingDTO) {
        if (msiGamingService.getMsiGamingById(id).isPresent()) {
            msiGamingDTO.setId(id);
            msiGamingService.updateMsiGaming(msiGamingDTO);
            return ResponseEntity.ok(msiGamingDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteMsiGaming/{id}")
    public ResponseEntity<Void> deleteMsiGaming(@PathVariable int id) {
        if (msiGamingService.getMsiGamingById(id).isPresent()) {
            msiGamingService.deleteMsiGaming(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}