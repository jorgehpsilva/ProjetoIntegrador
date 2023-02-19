package com.example.RentCars.service.impl;


import com.example.RentCars.model.Categorias;
import com.example.RentCars.model.dto.CategoriasDTO;
import com.example.RentCars.repository.ICarroRepository;
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
        Categorias categorias = new Categorias(categoriasDTO);
        categorias = categoriasRepository.save(categorias);
        categoriasDTO = new CategoriasDTO(categorias);
        return categoriasDTO;
    }

    @Override
    public CategoriasDTO getById(int id) {
        Categorias categorias = categoriasRepository.findById(id).get();
        return new CategoriasDTO(categorias);
    }

    @Override
    public CategoriasDTO update(CategoriasDTO categoriasDTO) {
        Categorias categorias = new Categorias(categoriasDTO);
        categoriasRepository.saveAndFlush(categorias);
        categoriasDTO = new CategoriasDTO(categorias);
        return categoriasDTO;
    }

    public boolean ifCategoriasExists(int id) {
        return categoriasRepository.existsById(id);
    }

    @Override
    public List<CategoriasDTO> getAll() {
        List<Categorias> categoriasList = categoriasRepository.findAll();
        List<CategoriasDTO> categoriasDTOS = new ArrayList<>();

        for (Categorias categorias: categoriasList) {
            CategoriasDTO categoriasDTO = new CategoriasDTO(categorias);
            categoriasDTOS.add(categoriasDTO);
        }
        return categoriasDTOS;
    }
}
