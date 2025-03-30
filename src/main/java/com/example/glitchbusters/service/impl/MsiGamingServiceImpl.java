package com.example.glitchbusters.service.impl;

import com.example.glitchbusters.Repo.MsiGamingRepo;
import com.example.glitchbusters.dto.MsiGamingDTO;
import com.example.glitchbusters.entity.MsiGaming;
import com.example.glitchbusters.service.MsiGamingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MsiGamingServiceImpl implements MsiGamingService {

    @Autowired
    private MsiGamingRepo msiGamingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MsiGamingDTO saveMsiGaming(MsiGamingDTO msiGamingDTO) {
        MsiGaming msiGaming = modelMapper.map(msiGamingDTO, MsiGaming.class);
        msiGaming = msiGamingRepo.save(msiGaming);
        return modelMapper.map(msiGaming, MsiGamingDTO.class);
    }

    @Override
    public List<MsiGamingDTO> getAllMsiGaming() {
        List<MsiGaming> msiGamings = msiGamingRepo.findAll();
        return modelMapper.map(msiGamings, new TypeToken<List<MsiGamingDTO>>() {}.getType());
    }

    @Override
    public Optional<MsiGamingDTO> getMsiGamingById(int id) {
        Optional<MsiGaming> msiGaming = msiGamingRepo.findById(id);
        return msiGaming.map(mg -> modelMapper.map(mg, MsiGamingDTO.class));
    }

    @Override
    public void updateMsiGaming(MsiGamingDTO msiGamingDTO) {
        if (msiGamingRepo.existsById(msiGamingDTO.getId())) {
            MsiGaming msiGaming = modelMapper.map(msiGamingDTO, MsiGaming.class);
            msiGamingRepo.save(msiGaming);
        }
    }

    @Override
    public void deleteMsiGaming(int id) {
        msiGamingRepo.deleteById(id);
    }
}