package com.example.RentCars.service.impl;


import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.Carro;
import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.AluguelDTO;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.repository.IAluguelRepository;
import com.example.RentCars.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelServiceImpl implements IService<AluguelDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IAluguelRepository aluguelRepository;

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Override
    public AluguelDTO create(AluguelDTO aluguelDTO) throws Exception {
        validateParams(aluguelDTO);
        Aluguel aluguelMapped = modelMapper.map(aluguelDTO, Aluguel.class);
        Aluguel aluguelSaved = aluguelRepository.save(aluguelMapped);
        return modelMapper.map(aluguelSaved, AluguelDTO.class);
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

    @Override
    public AluguelDTO getById(int id) throws Exception {
        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);
        if(!aluguelOptional.isPresent()) {
            throw new Exception("Aluguel não encontrado!");
        }
        return modelMapper.map(aluguelOptional.get(), AluguelDTO.class);
    }

    @Override
    public AluguelDTO updateById(int id, AluguelDTO aluguelDTO) throws Exception {
        AluguelDTO aluguelFound = getById(id);
        validateParams(aluguelFound);
        Aluguel aluguelSaved = aluguelRepository.saveAndFlush(modelMapper.map(aluguelFound, Aluguel.class));
        return modelMapper.map(aluguelSaved, AluguelDTO.class);
    }

    @Override
    public String deleteById(int id) {
        aluguelRepository.deleteById(id);
        return "Aluguel deletado " + id;
    }

    private void validateParams(AluguelDTO aluguelDTO) throws Exception {
        carroService.getById(aluguelDTO.getIdCarro());
        clienteService.getById(aluguelDTO.getIdCliente());
    }
}

