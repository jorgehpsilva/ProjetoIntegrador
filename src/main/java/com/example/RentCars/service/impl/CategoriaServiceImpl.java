package com.example.RentCars.service.impl;


import com.example.RentCars.model.Categoria;
import com.example.RentCars.model.dto.CategoriasDTO;
import com.example.RentCars.repository.ICategoriasRepository;
import com.example.RentCars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements IService<CategoriasDTO> {

    @Autowired
    private ICategoriasRepository categoriasRepository;

    @Override
    public CategoriasDTO create(CategoriasDTO categoriasDTO) {
        Categoria categoria = new Categoria(categoriasDTO);
        categoria = categoriasRepository.save(categoria);
        categoriasDTO = new CategoriasDTO(categoria);
        return categoriasDTO;
    }

    @Override
    public CategoriasDTO getById(int id) {
        Categoria categoria = categoriasRepository.findById(id).get();
        return new CategoriasDTO(categoria);
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public CategoriasDTO update(CategoriasDTO categoriasDTO) {
        Categoria categoria = new Categoria(categoriasDTO);
        categoriasRepository.saveAndFlush(categoria);
        categoriasDTO = new CategoriasDTO(categoria);
        return categoriasDTO;
    }

    public boolean ifCategoriasExists(int id) {
        return categoriasRepository.existsById(id);
    }

    @Override
    public List<CategoriasDTO> getAll() {
        List<Categoria> categoriaList = categoriasRepository.findAll();
        List<CategoriasDTO> categoriasDTOS = new ArrayList<>();

        for (Categoria categoria : categoriaList) {
            CategoriasDTO categoriasDTO = new CategoriasDTO(categoria);
            categoriasDTOS.add(categoriasDTO);
        }
        return categoriasDTOS;
    }
}
