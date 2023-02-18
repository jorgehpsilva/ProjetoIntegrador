package com.example.RentCars.repository;

import com.example.RentCars.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
}
