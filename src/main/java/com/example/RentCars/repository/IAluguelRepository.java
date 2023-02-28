package com.example.RentCars.repository;

import com.example.RentCars.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAluguelRepository extends JpaRepository<Aluguel, Integer> {
}
