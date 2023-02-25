package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.service.impl.AluguelServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AluguelServiceImpl aluguelService;

    @PostMapping
    public ResponseEntity<AluguelDTO> create(@Valid @RequestBody AluguelDTO aluguelDTO) throws Exception {
        AluguelDTO aluguel = aluguelService.create(aluguelDTO);
        AluguelDTO aluguelDTOMapped = modelMapper.map(aluguel, AluguelDTO.class);
        return ResponseEntity.ok(aluguelDTOMapped);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDTO> getById(@PathVariable int id) throws Exception {
        AluguelDTO aluguelDTO = aluguelService.getById(id);
        return ResponseEntity.ok(aluguelDTO);
    }

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> getAll() throws Exception {
        try {
            return ResponseEntity.ok(aluguelService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carros não encontrados");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(aluguelService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @PutMapping
    public ResponseEntity<AluguelDTO> update(@RequestBody AluguelDTO aluguelDTO) throws Exception {
        try {
            return ResponseEntity.ok(aluguelService.update(aluguelDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Não foi possível atualizar");
        }
    }
}
