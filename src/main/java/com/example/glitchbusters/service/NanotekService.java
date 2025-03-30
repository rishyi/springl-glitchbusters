package com.example.glitchbusters.service;

import com.example.glitchbusters.dto.NanotekDTO;

import java.util.List;

public interface NanotekService {

     NanotekDTO saveNanotek(NanotekDTO nanotekDTO);

    List<NanotekDTO> getAllNanotek();

    void updateNanotek(NanotekDTO nanotekDTO);

    void deleteNannotek(int id);
}
