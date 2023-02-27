package com.example.RentCars.service.impl;

import com.example.RentCars.model.dto.CategoriasDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

class CategoriaServiceImplTest {

    @Autowired
    CategoriaServiceImpl categoriaService;

    static CategoriasDTO categoriasDTOteste;

    @BeforeEach
    void doBefore(){
        categoriasDTOteste = new CategoriasDTO(3,"categoria 1","descriCat1","www.cat1.com");
    }

    @Test
    void create() {
        categoriasDTOteste = categoriaService.create(categoriasDTOteste);
        assertTrue(categoriasDTOteste.getId() >0);
    }

    @Test
    void getById() {
        categoriasDTOteste = categoriaService.getById(categoriasDTOteste.getId());
        Optional<CategoriasDTO> result = Optional.ofNullable(categoriaService.getById(categoriasDTOteste.getId()));
        assertEquals(categoriasDTOteste,result.orElse(null));
    }

    @Test
    void delete() {
        categoriasDTOteste = categoriaService.create(categoriasDTOteste);
        categoriaService.delete(categoriasDTOteste.getId());

        assertFalse(categoriaService.getById(categoriasDTOteste.getId()).isPresent);

    }

    @Test
    void update() {
        categoriasDTOteste = categoriaService.create(categoriasDTOteste);

        String novoQualific = "novaQualificacao";
        String novoDesc= "novaDescricao";

        categoriasDTOteste.setQualificacao(novoQualific);
        categoriasDTOteste.setDescricao(novoDesc);
        categoriaService.update(categoriasDTOteste);

        Optional<CategoriasDTO> result= Optional.ofNullable(categoriaService.getById(categoriasDTOteste.getId()));
        CategoriasDTO categoriasDTOalterado = result.get();
        assertSame(categoriasDTOalterado.getQualificacao(),novoQualific);
        assertSame(categoriasDTOalterado.getDescricao(),novoDesc);
    }

    @Test
    void getAll() {

        CategoriasDTO categoriasDTO2 = new CategoriasDTO(2,"qualific6","descricao34","www.cat2.com");
        categoriaService.create(categoriasDTO2);
        categoriasDTOteste = categoriaService.create(categoriasDTOteste);

        List<CategoriasDTO> result = categoriaService.getAll();
        assertTrue(result.size()>1);
    }
}