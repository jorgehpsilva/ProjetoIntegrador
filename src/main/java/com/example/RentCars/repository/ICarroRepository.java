package com.example.RentCars.repository;

import com.example.RentCars.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends JpaRepository<Carro, Integer> {

    Carro findByModelo(String modelo);
}
