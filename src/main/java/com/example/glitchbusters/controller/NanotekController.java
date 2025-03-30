package com.example.glitchbusters.controller;

import com.example.glitchbusters.Repo.NanotekRepo;
import com.example.glitchbusters.dto.NanotekDTO;
import com.example.glitchbusters.entity.Nanotek;
import com.example.glitchbusters.service.NanotekService;
import com.example.glitchbusters.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/nanotek")
public class NanotekController {

    @Autowired
    private NanotekRepo nanotekRepo;

    @Autowired
    private NanotekService nanotekService;

    @GetMapping("/api/test")
    public  String getString(){
        return "hello";
    }

    @GetMapping("/getAllNanotek")
    public List<NanotekDTO> getAllNanotek(){
        return nanotekService.getAllNanotek();
    }

    @GetMapping("getNanotekById/{id}")
    public ResponseEntity<Nanotek> getNanotekById(@PathVariable int id){
        Optional<Nanotek> nanotekDta = nanotekRepo.findById(id);

        if (nanotekDta.isPresent()){
            return new ResponseEntity<>(nanotekDta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("addNanotek")
    public NanotekDTO addNanotek(@RequestBody NanotekDTO nanotekDTO){
        return nanotekService.saveNanotek(nanotekDTO);
    }
    @PutMapping("updateNanotekById/{id}")
    public ResponseUtil updateNanotekById(@RequestBody NanotekDTO nanotekDTO){
       nanotekService.updateNanotek(nanotekDTO);
       return new ResponseUtil(201,"Nanotek Item Updated Successfully", null);
    }
    @DeleteMapping("deleteNanotek/{id}")
    public ResponseUtil deleteNanotekById(@PathVariable String id){
        nanotekService.deleteNannotek(Integer.parseInt(id));
        return new ResponseUtil(201, "Nanotek Item Deleted Successfully", null);
    }
}
