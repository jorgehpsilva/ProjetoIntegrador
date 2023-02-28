package com.example.RentCars.service.impl;

import com.example.RentCars.model.dto.CarroDTO;
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
class CarroServiceImplTest implements Serializable {

    @Autowired
    CarroServiceImpl carroService;

    static CarroDTO carroDTOtest;

    @BeforeEach
    void doBefore(){
        carroDTOtest = new CarroDTO(4,"Ford","Fiesta","verde","5");
    }

    @Test
    void create() {
        carroDTOtest = carroService.create(carroDTOtest);
        assertTrue(carroDTOtest.getId() >0);
    }

    @Test
    void getById() throws Exception {
        carroDTOtest = carroService.getById(carroDTOtest.getId());
        Optional<CarroDTO> result = Optional.ofNullable(carroService.getById(carroDTOtest.getId()));
        assertEquals(carroDTOtest,result.orElse(null));
    }

    @Test
    void delete() throws Exception {
        carroDTOtest = carroService.create(carroDTOtest);
        carroService.delete(carroDTOtest.getId());

        assertFalse(carroService.getById(carroDTOtest.getId()).isPresent);
    }

    @Test
    void update() throws Exception {
        carroDTOtest = carroService.create(carroDTOtest);

        String novoMarca = "FIAT";
        String novoModelo= "PALIO";

        carroDTOtest.setMarca(novoMarca);
        carroDTOtest.setModelo(novoModelo);
        carroService.update(carroDTOtest);

        Optional<CarroDTO> result= Optional.ofNullable(carroService.getById(carroDTOtest.getId()));
        CarroDTO carroDTOalterado = result.get();
        assertSame(carroDTOalterado.getMarca(),novoMarca);
        assertSame(carroDTOalterado.getModelo(),novoModelo);
    }

    @Test
    void getAll() {

        CarroDTO carroDTO2 = new CarroDTO(6,"Ferrari","Ferrari","branco","254");
        carroService.create(carroDTO2);
        carroDTOtest = carroService.create(carroDTOtest);

        List<CarroDTO> result = carroService.getAll();
        assertTrue(result.size()>1);
    }
}