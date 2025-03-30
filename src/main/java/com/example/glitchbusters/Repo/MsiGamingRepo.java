package com.example.glitchbusters.Repo;

import com.example.glitchbusters.entity.MsiGaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsiGamingRepo extends JpaRepository<MsiGaming, Integer> {
}