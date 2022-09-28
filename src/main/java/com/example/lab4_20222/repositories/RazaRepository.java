package com.example.lab4_20222.repositories;

import com.example.lab4_20222.entity.Raza_especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository  extends JpaRepository<Raza_especie,Integer> {
}
