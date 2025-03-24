package com.example.glitchbusters.controller;

import com.example.glitchbusters.Repo.NanotekRepo;
import com.example.glitchbusters.model.Nanotek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class nanotekController {

    @Autowired
    private NanotekRepo nanotekRepo;

    @GetMapping("/api/test")
    public  String getString(){
        return "hello";
    }

    @GetMapping("/getAllNanotek")
    public ResponseEntity<?> getAllNanotek(){
        try {
            List<Nanotek> nanotekList = new ArrayList<>();
            nanotekRepo.findAll().forEach(nanotekList::add);

            if (nanotekList.isEmpty()){
                System.out.println("no data");
                return ResponseEntity.ok("No Data Available");
            }

            return new ResponseEntity<>(nanotekList, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getNanotekById/{id}")
    public ResponseEntity<Nanotek> getNanotekById(@PathVariable int id){
        Optional<Nanotek> nanotekDta = nanotekRepo.findById(id);

        if (nanotekDta.isPresent()){
            return new ResponseEntity<>(nanotekDta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addNanotek")
    public ResponseEntity<Nanotek> addNanotek(@RequestBody Nanotek nanotek){
        System.out.println("test add");

        Nanotek nanotekObj = nanotekRepo.save(nanotek);
        System.out.println("test add");

        return new ResponseEntity<>(nanotekObj, HttpStatus.OK);
    }
    @PostMapping("/updateNanotekById/{id}")
    public ResponseEntity<Nanotek> updateNanotekById(@PathVariable int id, @RequestBody Nanotek newNanotekData){
       Optional<Nanotek> oldNanotekData =  nanotekRepo.findById(id);

       if (oldNanotekData.isPresent()){
           Nanotek updatedNanotekData = oldNanotekData.get();
           updatedNanotekData.setName(newNanotekData.getName());
           updatedNanotekData.setDescription(newNanotekData.getDescription());
           updatedNanotekData.setPrice(newNanotekData.getPrice());
           updatedNanotekData.setQty(newNanotekData.getQty());

           Nanotek nanotekObj = nanotekRepo.save(updatedNanotekData);
           return new ResponseEntity<>(nanotekObj, HttpStatus.OK);
       }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/deleteNanotekById/{id}")
    public ResponseEntity<HttpStatus> deleteNanotekById(@PathVariable int id){
        nanotekRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
