package com.example.lab4_20222.repositories;

import com.example.lab4_20222.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}
