package com.example.glitchbusters.service.impl;

import com.example.glitchbusters.Repo.ChamaRepo;
import com.example.glitchbusters.dto.ChamaDTO;
import com.example.glitchbusters.entity.Chama;
import com.example.glitchbusters.service.ChamaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChamaServiceImpl implements ChamaService {

    @Autowired
    private ChamaRepo chamaRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ChamaDTO saveChama(ChamaDTO chamaDTO){
        chamaRepo.save(modelMapper.map(chamaDTO, Chama.class));
        return chamaDTO;
    }

    @Override
    public List<ChamaDTO> getAllChama(){
        return modelMapper.map(chamaRepo.findAll(),new TypeToken<List<ChamaDTO>>(){}.getType());
    }

    @Override
    public void updateChama(ChamaDTO chamaDTO){
        if (chamaRepo.existsById(chamaDTO.getId())){
            Chama chama = modelMapper.map(chamaDTO,Chama.class);
            chamaRepo.save(chama);
        }
    }

    @Override
    public void deleteChama(int id){
        chamaRepo.deleteById(id);
    }
}
