package com.example.RentCars.service.impl;

import com.example.RentCars.common.AluguelMock;
import com.example.RentCars.common.CarroMock;
import com.example.RentCars.common.ClienteMock;
import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.repository.IAluguelRepository;
import com.example.RentCars.repository.ICarroRepository;
import com.example.RentCars.repository.IClienteRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

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
    IAluguelRepository aluguelRepository;

    @Mock
    ICarroRepository carroRepository;

    @Mock
    IClienteRepository clienteRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void createSuccessTest() throws Exception {
        AluguelDTO request = aluguelMock.getAluguelRequestDTO();
        Aluguel response = aluguelMock.getAluguelWithId();
        when(aluguelRepository.save(any(Aluguel.class))).thenReturn(response);

        AluguelDTO aluguelServiceMock = aluguelService.create(request);

        assertNotEquals(0, response.getId());
        assertEquals(aluguelServiceMock.getIdCarro(), response.getCarro().getId());
        assertEquals(aluguelServiceMock.getIdCliente(), response.getCliente().getId());
    }

    @Test
    @Order(2)
    void getByIdSuccessTest() throws Exception {
        Optional<Aluguel> aluguel = aluguelMock.getOptionalAluguel();
        when(aluguelRepository.findById(999)).thenReturn(aluguel);
        AluguelDTO aluguelFound = aluguelService.getById(999);
        assertEquals(aluguel.get().getCarro().getId(), aluguelFound.getIdCarro());
        assertEquals(aluguel.get().getCliente().getId(), aluguelFound.getIdCliente());
    }

    @Test
    @Order(3)
    void deleteSuccessTest() {
        AluguelDTO aluguelDTO = aluguelMock.getAluguelRequestDTO();
        when(aluguelService.deleteById(1)).thenReturn(String.valueOf(aluguelDTO));

        String aluguelDeleted = aluguelService.deleteById(1);

        assertEquals(String.valueOf(aluguelDTO), aluguelDeleted);
        assertEquals("Aluguel deletado 1", aluguelDeleted);
    }

    @Test
    @Order(4)
    void updateSuccessTest() throws Exception {
        AluguelDTO requestDTO = aluguelMock.getAluguelRequestDTO();
        when(aluguelService.getById(anyInt())).thenReturn(requestDTO);
//        when(aluguelRepository.saveAndFlush(any(Aluguel.class))).thenReturn(responseMock);
        AluguelDTO aluguelDTO = aluguelService.updateById(1, requestDTO);

        assertEquals(requestDTO.getIdCliente(), aluguelDTO.getIdCliente());
        assertEquals(requestDTO.getIdCarro(), aluguelDTO.getIdCarro());
    }

    @Test
    @Order(5)
    void getAllSuccessTest() {
        List<Aluguel> aluguelList = aluguelMock.getAluguelListTest();
        when(aluguelRepository.findAll()).thenReturn(aluguelList);
        List<AluguelDTO> aluguelListService = aluguelService.getAll();
        for (int i = 0; i < aluguelListService.size(); i++) {
            assertEquals(aluguelList.get(i).getCarro().getId(), aluguelListService.get(i).getIdCarro());
            assertEquals(aluguelList.get(i).getCliente().getId(), aluguelListService.get(i).getIdCliente());
        }
    }
}