package com.example.RentCars.controller;


import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.CategoriaDTO;
import com.example.RentCars.service.impl.CategoriaServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO) throws Exception {
        CategoriaDTO categoria = categoriaService.create(categoriaDTO);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAll() throws Exception {
        List<CategoriaDTO> categorias = categoriaService.getAll();
        List<CategoriaDTO> categoriasResponseDTO = categorias.stream().map(categoria -> modelMapper.map(categoria, CategoriaDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(categoriasResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable int id) throws Exception {
        CategoriaDTO categoriaDTO = categoriaService.getById(id);
        return ResponseEntity.ok(categoriaDTO);
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> update(@PathVariable int id, @RequestBody CategoriaDTO categoriaDTO) throws Exception {
        CategoriaDTO updatedCategoria = categoriaService.updateById(id, categoriaDTO);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(categoriaService.deleteById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Categoria não encontrada" + id);
        }
    }
}
