package com.example.RentCars.repository;

import com.example.RentCars.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarroRepository extends JpaRepository<Carro, Integer> {

    Carro findByNome(String nome);
}
