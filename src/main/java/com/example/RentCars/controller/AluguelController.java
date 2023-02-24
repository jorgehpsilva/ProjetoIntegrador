package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.service.impl.AluguelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelServiceImpl aluguelService;

    @PostMapping("/salvar")
    public ResponseEntity<AluguelDTO> create(@RequestBody AluguelDTO aluguelDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(aluguelService.create(aluguelDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um carro foi adicionado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDTO> getById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(aluguelService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> getAll() throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(aluguelService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carros não encontrados");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(aluguelService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<AluguelDTO> update(@RequestBody AluguelDTO aluguelDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(aluguelService.update(aluguelDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Não foi possível atualizar");
        }
    }
}
