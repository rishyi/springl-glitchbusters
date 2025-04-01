package com.example.glitchbusters.service.impl;

import com.example.glitchbusters.Repo.MskComputersRepo;
import com.example.glitchbusters.dto.MskComputersDTO;
import com.example.glitchbusters.entity.MskComputers;
import com.example.glitchbusters.service.MskComputersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MskComputersServiceImpl implements MskComputersService {

    @Autowired
    private MskComputersRepo mskComputersRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MskComputersDTO saveMskComputers(MskComputersDTO mskComputersDTO) {
        mskComputersRepo.save(modelMapper.map(mskComputersDTO, MskComputers.class));
        return mskComputersDTO;
    }

    @Override
    public List<MskComputersDTO> getAllMskComputers() {
        return modelMapper.map(mskComputersRepo.findAll(),
                new TypeToken<List<MskComputersDTO>>(){}.getType());
    }

    @Override
    public void updateMskComputers(MskComputersDTO mskComputersDTO) {
        if (mskComputersRepo.existsById(mskComputersDTO.getId())) {
            MskComputers mskComputers = modelMapper.map(mskComputersDTO, MskComputers.class);
            mskComputersRepo.save(mskComputers);
        }
    }

    @Override
    public void deleteMskComputers(int id) {
        mskComputersRepo.deleteById(id);
    }
}