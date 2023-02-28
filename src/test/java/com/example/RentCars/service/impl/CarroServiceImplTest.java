//package com.example.RentCars.service.impl;
//
//import com.example.RentCars.common.CarroMock;
//import com.example.RentCars.common.CategoriaMock;
//import com.example.RentCars.model.Aluguel;
//import com.example.RentCars.model.Carro;
//import com.example.RentCars.model.Categoria;
//import com.example.RentCars.model.dto.AluguelDTO;
//import com.example.RentCars.model.dto.CarroDTO;
//import com.example.RentCars.model.dto.CategoriaDTO;
//import com.example.RentCars.repository.IAluguelRepository;
//import com.example.RentCars.repository.ICategoriaRepository;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class CarroServiceImplTest implements Serializable {
//
//    private final CarroMock carroMock = new CarroMock();
//    private final CategoriaMock categoriaMock = new CategoriaMock();
//
//    @InjectMocks
//    CarroServiceImpl carroService;
//
//    @Mock
//    CategoriaServiceImpl categoriaService;
//
//    @Mock
//    IAluguelRepository aluguelRepository;
//
//    @Mock
//    ICategoriaRepository categoriaRepository;
//
//
//    @BeforeEach
//    void init(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    @Order(1)
//    void createSuccessTest() throws Exception {
//        CarroDTO request = carroMock.getCarroRequestDTO();
//        Carro response = carroMock.getCarroWithId();
//        when(aluguelRepository.save(any(Aluguel.class))).thenReturn(response);
//
//        CategoriaDTO categoriaServiceMock = categoriaService.create(request);
//
//        assertNotEquals(0, response.getId());
//        assertEquals(categoriaServiceMock.getIdCarro(), response.getCarro().getId());
//        assertEquals(categoriaServiceMock.getIdCliente(), response.getCliente().getId());
//    }
//
//    @Test
//    @Order(2)
//    void getByIdSuccessTest() throws Exception {
//        Optional<Carro> aluguel = carroMock.getOptionalCarro();
//        when(aluguelRepository.findById(999)).thenReturn(aluguel);
//        CarroDTO aluguelFound = carroService.getById(999);
//        assertEquals(aluguel.get().getCarro().getId(), aluguelFound.getIdCarro());
//        assertEquals(aluguel.get().getCliente().getId(), aluguelFound.getIdCliente());
//    }
//
//    @Test
//    @Order(3)
//    void deleteSuccessTest() {
//        CarroDTO aluguelDTO = carroMock.getCategoriaRequestDTO();
//        when(carroService.deleteById(1)).thenReturn(String.valueOf(aluguelDTO));
//
//        String aluguelDeleted = carroService.deleteById(1);
//
//        assertEquals(String.valueOf(aluguelDTO), aluguelDeleted);
//        assertEquals("Aluguel deletado 1", aluguelDeleted);
//    }
//
//    @Test
//    @Order(4)
//    void updateSuccessTest() throws Exception {
//        AluguelDTO requestDTO = carroMock.getCategoriaRequestDTO();
//        when(carroService.getById(anyInt())).thenReturn(requestDTO);
////        when(aluguelRepository.saveAndFlush(any(Aluguel.class))).thenReturn(responseMock);
//        AluguelDTO aluguelDTO = carroService.updateById(1, requestDTO);
//
//        assertEquals(requestDTO.getIdCliente(), aluguelDTO.getIdCliente());
//        assertEquals(requestDTO.getIdCarro(), aluguelDTO.getIdCarro());
//    }
//
//    @Test
//    @Order(5)
//    void getAllSuccessTest() {
//        List<Aluguel> aluguelList = carroMock.getAluguelListTest();
//        when(aluguelRepository.findAll()).thenReturn(aluguelList);
//        List<AluguelDTO> aluguelListService = carroService.getAll();
//        for (int i = 0; i < aluguelListService.size(); i++) {
//            assertEquals(aluguelList.get(i).getCarro().getId(), aluguelListService.get(i).getIdCarro());
//            assertEquals(aluguelList.get(i).getCliente().getId(), aluguelListService.get(i).getIdCliente());
//        }
//    }
//}