package com.example.glitchbusters.Repo;

import com.example.glitchbusters.entity.GameStreet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStreetRepo extends JpaRepository<GameStreet, Integer> {
}