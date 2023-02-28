package com.example.RentCars.service.impl;

import com.example.RentCars.model.dto.CategoriasDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CategoriaServiceImplTest implements Serializable {

    @Autowired
    CategoriaServiceImpl categoriaService;

    static CategoriasDTO categoriasDTOtest;

    @BeforeEach
    void doBefore(){
        categoriasDTOtest = new CategoriasDTO(3,"categoria 1","descriCat1","www.cat1.com");
    }

    @Test
    void create() {
        categoriasDTOtest = categoriaService.create(categoriasDTOtest);
        assertTrue(categoriasDTOtest.getId() >0);
    }

    @Test
    void getById() {
        categoriasDTOtest = categoriaService.getById(categoriasDTOtest.getId());
        Optional<CategoriasDTO> result = Optional.ofNullable(categoriaService.getById(categoriasDTOtest.getId()));
        assertEquals(categoriasDTOtest,result.orElse(null));
    }

    @Test
    void delete() {
        categoriasDTOtest = categoriaService.create(categoriasDTOtest);
        categoriaService.delete(categoriasDTOtest.getId());

        assertFalse(categoriaService.getById(categoriasDTOtest.getId()).isPresent());

    }

    @Test
    void update() {
        categoriasDTOtest = categoriaService.create(categoriasDTOtest);

        String novoQualific = "novaQualificacao";
        String novoDesc= "novaDescricao";

        categoriasDTOtest.setQualificacao(novoQualific);
        categoriasDTOtest.setDescricao(novoDesc);
        categoriaService.update(categoriasDTOtest);

        Optional<CategoriasDTO> result= Optional.ofNullable(categoriaService.getById(categoriasDTOtest.getId()));
        CategoriasDTO categoriasDTOalterado = result.get();
        assertSame(categoriasDTOalterado.getQualificacao(),novoQualific);
        assertSame(categoriasDTOalterado.getDescricao(),novoDesc);
    }

    @Test
    void getAll() {

        CategoriasDTO categoriasDTO2 = new CategoriasDTO(2,"qualific6","descricao34","www.cat2.com");
        categoriaService.create(categoriasDTO2);
        categoriasDTOtest = categoriaService.create(categoriasDTOtest);

        List<CategoriasDTO> result = categoriaService.getAll();
        assertTrue(result.size()>1);
    }
}