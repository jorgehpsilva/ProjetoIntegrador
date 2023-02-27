package com.example.RentCars.service.impl;

import com.example.RentCars.model.dto.CarroDTO;
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

class CarroServiceImplTest {

    @Autowired
    CarroServiceImpl carroService;

    static CarroDTO carroDTOteste;

    @BeforeEach
    void doBefore(){
        carroDTOteste = new CarroDTO(4,"Ford","Fiesta","verde","5");
    }

    @Test
    void create() {
        carroDTOteste = carroService.create(carroDTOteste);
        assertTrue(carroDTOteste.getId() >0);
    }

    @Test
    void getById() throws Exception {
        carroDTOteste = carroService.getById(carroDTOteste.getId());
        Optional<CarroDTO> result = Optional.ofNullable(carroService.getById(carroDTOteste.getId()));
        assertEquals(carroDTOteste,result.orElse(null));
    }

    @Test
    void delete() throws Exception {
        carroDTOteste = carroService.create(carroDTOteste);
        carroService.delete(carroDTOteste.getId());

        assertFalse(carroService.getById(carroDTOteste.getId()).isPresent);

    }

    @Test
    void update() throws Exception {
        carroDTOteste = carroService.create(carroDTOteste);

        String novoMarca = "FIAT";
        String novoModelo= "PALIO";

        carroDTOteste.setMarca(novoMarca);
        carroDTOteste.setModelo(novoModelo);
        carroService.update(carroDTOteste);

        Optional<CarroDTO> result= Optional.ofNullable(carroService.getById(carroDTOteste.getId()));
        CarroDTO carroDTOalterado = result.get();
        assertSame(carroDTOalterado.getMarca(),novoMarca);
        assertSame(carroDTOalterado.getModelo(),novoModelo);
    }

    @Test
    void getAll() {

        CarroDTO carroDTO2 = new CarroDTO(6,"Ferrari","Ferrari","branco","254");
        carroService.create(carroDTO2);
        carroDTOteste = carroService.create(carroDTOteste);

        List<CarroDTO> result = carroService.getAll();
        assertTrue(result.size()>1);
    }
}