package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.CategoriasDTO;
import com.example.RentCars.service.impl.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @PostMapping("/salvar")
    public ResponseEntity<CategoriasDTO> create(@RequestBody CategoriasDTO categoriasDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(categoriaService.create(categoriasDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Categoria atualizada");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasDTO> getById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(categoriaService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Categoria não atualizada" + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoriasDTO>> getAll() throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(categoriaService.getAll());
        } catch(Exception e) {
            throw new ResourceNotFoundException("Categorias não encontradas");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(categoriaService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Categoria não encontrada" + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<CategoriasDTO> update(@RequestBody CategoriasDTO categoriasDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(categoriaService.update(categoriasDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um categoria foi atualizada");
        }
    }
}
