package com.example.RentCars.repository;

import com.example.RentCars.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
}
