package com.example.RentCars.repository;

import com.example.RentCars.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriasRepository extends JpaRepository<Categoria,Integer> {
}
