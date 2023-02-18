package com.example.RentCars.repository;

import com.example.RentCars.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAluguelRepository extends JpaRepository<Aluguel, Integer> {
}
