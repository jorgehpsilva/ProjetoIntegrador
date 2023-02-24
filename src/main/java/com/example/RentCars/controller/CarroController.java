package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.service.impl.CarroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroServiceImpl carroService;

    @PostMapping("/salvar")
    public ResponseEntity<CarroDTO> create(@RequestBody CarroDTO carroDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(carroService.create(carroDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um carro foi adicionado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(carroService.getById(id));
        } catch (Exception e){
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> getAll() throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(carroService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carros não encontrados");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(carroService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO carroDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(carroService.update(carroDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Não foi possível atualizar");
        }
    }

    @GetMapping("/getByNome")
    public ResponseEntity<CarroDTO> getByNome(@RequestParam(value = "nome") String nome) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(carroService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado");
        }
    }
}
