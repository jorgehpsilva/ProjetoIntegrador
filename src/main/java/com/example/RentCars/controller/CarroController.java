package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.service.impl.CarroServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CarroServiceImpl carroService;

    @PostMapping
    public ResponseEntity<CarroDTO> create(@RequestBody CarroDTO carroDTO) throws Exception {
        CarroDTO carro = carroService.create(carroDTO);
        return ResponseEntity.ok(carro);
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> getAll() throws Exception {
        List<CarroDTO> carros = carroService.getAll();
        List<CarroDTO> carrosResponseDTO = carros.stream().map(carro -> modelMapper.map(carro, CarroDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(carrosResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getById(@PathVariable int id) throws Exception {
        CarroDTO carroDTO = carroService.getById(id);
        return ResponseEntity.ok(carroDTO);
    }

    @PutMapping
    public ResponseEntity<CarroDTO> update(@PathVariable int id, @RequestBody CarroDTO carroDTO) throws Exception {
        CarroDTO updatedCarro = carroService.updateById(id, carroDTO);
        return ResponseEntity.ok(updatedCarro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(carroService.deleteById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado" + id);
        }
    }

    @GetMapping("/modelo")
    public ResponseEntity<CarroDTO> getByModelo(@RequestParam String modelo) throws Exception {
        try {
            return ResponseEntity.ok(carroService.getByModelo(modelo));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Carro não encontrado");
        }
    }
}
