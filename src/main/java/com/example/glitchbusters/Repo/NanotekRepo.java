package com.example.glitchbusters.Repo;

import com.example.glitchbusters.entity.Nanotek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NanotekRepo extends JpaRepository<Nanotek, Integer>{
}
