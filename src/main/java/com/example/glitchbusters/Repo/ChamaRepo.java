package com.example.glitchbusters.Repo;

import com.example.glitchbusters.entity.Chama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamaRepo extends JpaRepository<Chama, Integer> {
}