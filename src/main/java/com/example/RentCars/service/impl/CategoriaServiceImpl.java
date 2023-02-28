package com.example.RentCars.service.impl;


import com.example.RentCars.model.Categoria;
import com.example.RentCars.model.dto.CategoriaDTO;
import com.example.RentCars.repository.ICategoriaRepository;
import com.example.RentCars.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements IService<CategoriaDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        categoriaDTO = new CategoriaDTO(categoria);
        return categoriaDTO;
    }

    @Override
    public List<CategoriaDTO> getAll() {
        List<Categoria> categoriaList = categoriaRepository.findAll();
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        for (Categoria categoria : categoriaList) {
            CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);
            categoriaDTOS.add(categoriaDTO);
        }
        return categoriaDTOS;
    }

    @Override
    public CategoriaDTO getById(int id) throws Exception {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (!categoriaOptional.isPresent()) {
            throw new Exception("Categoria não encontrado");
        }
        return modelMapper.map(categoriaOptional.get(), CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO updateById(int id, CategoriaDTO categoriaDTO) throws Exception {
        CategoriaDTO categoriaFound = getById(id);
        Categoria categoria = categoriaRepository.saveAndFlush(modelMapper.map(categoriaFound, Categoria.class));
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    @Override
    public String deleteById(int id) {
        categoriaRepository.deleteById(id);
        return "Categoria deletada" + id;
    }

    public boolean ifCategoriasExists(int id) {
        return categoriaRepository.existsById(id);
    }
}
