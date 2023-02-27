package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.CategoriasDTO;
import com.example.RentCars.service.impl.CategoriaServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @PostMapping
    public ResponseEntity<CategoriasDTO> create(@Valid @RequestBody CategoriasDTO categoriasDTO) throws Exception {
        CategoriasDTO categorias = categoriaService.create(categoriasDTO);
        CategoriasDTO categoriasDTOMapped = modelMapper.map(categorias, CategoriasDTO.class);
        return ResponseEntity.ok(categoriasDTOMapped);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasDTO> getById(@PathVariable int id) throws Exception {
        CategoriasDTO categoriasDTO = categoriaService.getById(id);
        return ResponseEntity.ok(categoriasDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoriasDTO>> getAll() throws Exception {
        try {
            return ResponseEntity.ok(categoriaService.getAll());
        } catch(Exception e) {
            throw new ResourceNotFoundException("Categorias não encontradas");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(categoriaService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Categoria não encontrada" + id);
        }
    }

    @PutMapping
    public ResponseEntity<CategoriasDTO> update(@RequestBody CategoriasDTO categoriasDTO) throws Exception {
        try {
            return ResponseEntity.ok(categoriaService.update(categoriasDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um categoria foi atualizada");
        }
    }
}
