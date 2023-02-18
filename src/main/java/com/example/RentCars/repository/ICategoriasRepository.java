package com.example.RentCars.repository;

import com.example.RentCars.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriasRepository extends JpaRepository<Categorias,Integer> {
}
