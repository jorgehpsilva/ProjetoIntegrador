package com.example.RentCars.service.impl;


import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.Carro;
import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.repository.IAluguelRepository;
import com.example.RentCars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AluguelServiceImpl implements IService<AluguelDTO> {

    @Autowired
    private IAluguelRepository aluguelRepository;

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Override
    public AluguelDTO create(AluguelDTO aluguelDTO) {
        Aluguel aluguel = new Aluguel(aluguelDTO);
        CarroDTO carroDTO;
        int idCarro = aluguel.getCarro().getId();
        ClienteDTO clienteDTO;
        int idCliente = aluguel.getCliente().getId();

        if (carroService.ifCarroExists(idCarro) && clienteService.ifClienteExists(idCliente)) {
            carroDTO = carroService.getById(idCarro);
            Carro carro = new Carro(carroDTO);
            aluguel.setCarro(carro);
            clienteDTO = clienteService.getById(idCliente);
            Cliente cliente = new Cliente(clienteDTO);
            aluguel.setCliente(cliente);
            aluguel = aluguelRepository.save(aluguel);
        }

        aluguelDTO = new AluguelDTO(aluguel);
        return aluguelDTO;
    }

    @Override
    public AluguelDTO getById(int id) {
        Aluguel aluguel = aluguelRepository.findById(id).get();
        AluguelDTO aluguelDTO = new AluguelDTO(aluguel);

        return aluguelDTO;

    }

    @Override
    public String delete(int id) {
        aluguelRepository.deleteById(id);
        return "Aluguel deletado" + id;
    }

    @Override
    public AluguelDTO update(AluguelDTO aluguelDTO) {
        Aluguel aluguel = new Aluguel(aluguelDTO);
        aluguel = aluguelRepository.saveAndFlush(aluguel);
        aluguelDTO = new AluguelDTO(aluguel);
        return aluguelDTO;
    }

    @Override
    public List<AluguelDTO> getAll() {
        List<Aluguel> aluguelList = aluguelRepository.findAll();
        List<AluguelDTO> aluguelDTOS = new ArrayList<>();

        for (Aluguel aluguel : aluguelList) {
            AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
            aluguelDTOS.add(aluguelDTO);
        }
        return aluguelDTOS;
    }
}

