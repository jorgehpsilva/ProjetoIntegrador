package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.service.impl.AluguelServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        return ResponseEntity.ok(aluguel);
    }

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> getAll() throws Exception {
        List<AluguelDTO> alugueis = aluguelService.getAll();
        List<AluguelDTO> alugueisResponseDTO = alugueis.stream().map(aluguel -> modelMapper.map(aluguel, AluguelDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(alugueisResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDTO> getById(@PathVariable int id) throws Exception {
        AluguelDTO aluguelDTO = aluguelService.getById(id);
        return ResponseEntity.ok(aluguelDTO);
    }

    @PutMapping
    public ResponseEntity<AluguelDTO> update(@PathVariable int id, @RequestBody AluguelDTO aluguelDTO) throws Exception {
        AluguelDTO updatedAluguel = aluguelService.updateById(id, aluguelDTO);
        return ResponseEntity.ok(updatedAluguel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(aluguelService.deleteById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Aluguel não encontrado" + id);
        }
    }
}
