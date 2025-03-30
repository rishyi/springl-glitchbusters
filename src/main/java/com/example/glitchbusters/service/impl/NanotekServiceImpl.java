package com.example.glitchbusters.service.impl;

import com.example.glitchbusters.Repo.NanotekRepo;
import com.example.glitchbusters.dto.NanotekDTO;
import com.example.glitchbusters.entity.Nanotek;
import com.example.glitchbusters.service.NanotekService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NanotekServiceImpl implements NanotekService {

    @Autowired
    private NanotekRepo nanotekRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NanotekDTO saveNanotek(NanotekDTO nanotekDTO){
        nanotekRepo.save(modelMapper.map(nanotekDTO, Nanotek.class));
        return nanotekDTO;
    }

    @Override
    public List<NanotekDTO> getAllNanotek(){
        List<Nanotek> nanotekList = nanotekRepo.findAll();
        return modelMapper.map(nanotekList,new TypeToken<List<NanotekDTO>>(){}.getType());
    }

    @Override
    public void updateNanotek(NanotekDTO nanotekDTO){
        if (nanotekRepo.existsById(nanotekDTO.getId())){
            Nanotek nanotek = modelMapper.map(nanotekDTO,Nanotek.class);
            nanotekRepo.save(nanotek);
        }
    }

    @Override
    public void deleteNannotek(int id){
        nanotekRepo.deleteById(id);
    }
}
