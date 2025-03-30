package com.example.glitchbusters.controller;

import com.example.glitchbusters.dto.ChamaDTO;
import com.example.glitchbusters.service.ChamaService;
import com.example.glitchbusters.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/chama")
public class ChamaController {

    @Autowired
    private ChamaService chamaService;

    @GetMapping("/api/testC")
    public String getString(){
        return "Chama";
    }

    @GetMapping("/getAllChama")
    public List<ChamaDTO> getAllCham(){
        return chamaService.getAllChama();
    }

    @PostMapping( "/addChama")
    public ChamaDTO addChama(@RequestBody ChamaDTO chamaDTO){
        return chamaService.saveChama(chamaDTO);
    }

    @PostMapping("/updateChamaById/{id}")
    public ResponseUtil updateChamaById(@RequestBody ChamaDTO chamaDTO){
        chamaService.updateChama(chamaDTO);
        return new ResponseUtil(201,"Chama Item Update Successfully",null);
    }

    @DeleteMapping("/deleteChamaById/{id}")
    public ResponseUtil deleteChamaById(@PathVariable String id){
        chamaService.deleteChama(Integer.parseInt(id));
        return new ResponseUtil(201,"Chama Item Delete Successfully",null);
    }
}
