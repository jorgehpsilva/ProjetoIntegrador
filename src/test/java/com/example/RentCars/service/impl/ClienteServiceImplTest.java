package com.example.RentCars.service.impl;

import com.example.RentCars.model.dto.ClienteDTO;
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
class ClienteServiceImplTest implements Serializable {

    @Autowired
    ClienteServiceImpl clienteService;

    static ClienteDTO clienteDTOteste;

    @BeforeEach
    void doBefore(){
        clienteDTOteste = new ClienteDTO(5,"carlos","vieira","carlosV@gmail.com","123","carlosV123");
    }

    @Test
    void create() {
        clienteDTOteste = clienteService.create(clienteDTOteste);
        assertTrue(clienteDTOteste.getId() >0);
    }

    @Test
    void getById() {
        clienteDTOteste = clienteService.getById(clienteDTOteste.getId());
        Optional<ClienteDTO> result = Optional.ofNullable(clienteService.getById(clienteDTOteste.getId()));
        assertEquals(clienteDTOteste,result.orElse(null));
    }

    @Test
    void delete() {
        clienteDTOteste = clienteService.create(clienteDTOteste);
        clienteService.delete(clienteDTOteste.getId());

        assertFalse(clienteService.getById(clienteDTOteste.getId()).isPresent);

    }

    @Test
    void update() {
        clienteDTOteste = clienteService.create(clienteDTOteste);

        String novoNome = "Paulo";
        String novoMail= "emailteste@teste.com";

        clienteDTOteste.setNome(novoNome);
        clienteDTOteste.setEmail(novoMail);
        clienteService.update(clienteDTOteste);

        Optional<ClienteDTO> result= Optional.ofNullable(clienteService.getById(clienteDTOteste.getId()));
        ClienteDTO clienteDTOalterado = result.get();
        assertSame(clienteDTOalterado.getNome(),novoNome);
        assertSame(clienteDTOalterado.getEmail(),novoMail);
    }

    @Test
    void getAll() {

        ClienteDTO clienteDTO2 = new ClienteDTO(2,"Tiago","Roma","tiagoR@gmail.com","123","tiagoR123");
        clienteService.create(clienteDTO2);
        clienteDTOteste = clienteService.create(clienteDTOteste);

        List<ClienteDTO> result = clienteService.getAll();
        assertTrue(result.size()>1);
    }
}