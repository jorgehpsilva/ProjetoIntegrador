package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.service.impl.CarroServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarroServiceImpl carroService;

    @PostMapping
    public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO carroDTO) throws Exception {
        CarroDTO carro = carroService.create(carroDTO);
        CarroDTO carroDTOMapped = modelMapper.map(carro,CarroDTO.class);
        return ResponseEntity.ok(carroDTOMapped);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getById(@PathVariable int id) throws Exception {
        CarroDTO carroDTO = carroService.getById(id);
        return ResponseEntity.ok(carroDTO);
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> getAll() throws Exception {
        try {
            return ResponseEntity.ok(carroService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carros não encontrados");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception{
        try {
            return ResponseEntity.ok(carroService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @PutMapping
    public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO carroDTO) throws Exception {
        try {
            return ResponseEntity.ok(carroService.update(carroDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Não foi possível atualizar");
        }
    }

    @GetMapping
    public ResponseEntity<CarroDTO> getByNome(@RequestParam(value = "nome") String nome) throws Exception {
        try {
            return ResponseEntity.ok(carroService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado");
        }
    }
}
