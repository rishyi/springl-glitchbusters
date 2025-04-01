package com.example.glitchbusters.Repo;

import com.example.glitchbusters.entity.MskComputers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MskComputersRepo extends JpaRepository<MskComputers, Integer> {
}