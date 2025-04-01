package com.example.glitchbusters.controller;

import com.example.glitchbusters.dto.MskComputersDTO;
import com.example.glitchbusters.service.MskComputersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mskComputers")
public class MskComputersController {

    @Autowired
    private MskComputersService mskComputersService;

    @PostMapping("/addMskComputers")
    public ResponseEntity<MskComputersDTO> createMskComputers(@RequestBody MskComputersDTO mskComputersDTO) {
        MskComputersDTO savedMskComputers = mskComputersService.saveMskComputers(mskComputersDTO);
        return ResponseEntity.ok(savedMskComputers);
    }

    @GetMapping("/getAllMskComputers")
    public ResponseEntity<List<MskComputersDTO>> getAllMskComputers() {
        List<MskComputersDTO> mskComputersList = mskComputersService.getAllMskComputers();
        return ResponseEntity.ok(mskComputersList);
    }

    @PutMapping("/updateMskComputers/{id}")
    public ResponseEntity<String> updateMskComputers(@PathVariable int id, @RequestBody MskComputersDTO mskComputersDTO) {
        mskComputersDTO.setId(id);
        mskComputersService.updateMskComputers(mskComputersDTO);
        return ResponseEntity.ok("MskComputers updated successfully");
    }

    @DeleteMapping("/deleteMskComputers/{id}")
    public ResponseEntity<String> deleteMskComputers(@PathVariable int id) {
        mskComputersService.deleteMskComputers(id);
        return ResponseEntity.ok("MskComputers deleted successfully");
    }
}