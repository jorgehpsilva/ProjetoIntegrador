package com.example.RentCars.service.impl;

import com.example.RentCars.common.AluguelMock;
import com.example.RentCars.common.CarroMock;
import com.example.RentCars.common.ClienteMock;
import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.repository.ICarroRepository;
import com.example.RentCars.repository.IClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AluguelServiceImplTest implements Serializable {

    private final AluguelMock aluguelMock = new AluguelMock();
    private final CarroMock carroMock = new CarroMock();
    private final ClienteMock clienteMock = new ClienteMock();

    @InjectMocks
    AluguelServiceImpl aluguelService;

    @Mock
    ClienteServiceImpl clienteService;

    @Mock
    CarroServiceImpl carroService;

    @Mock
    IClienteRepository clienteRepository;

    @Mock
    ICarroRepository carroRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSuccessTest() {
        AluguelDTO aluguelDTO = aluguelMock.getAluguelRequestDTO();
        validateParams(aluguelDTO);
        Aluguel aluguelMapped = modelMapper.map(aluguelDTO, Aluguel.class);
        Aluguel aluguelSaved = aluguelRepository.save(aluguelMapped);
        return modelMapper.map(aluguelSaved, AluguelDTO.class);
    }

    @Test
    void getById() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }
}