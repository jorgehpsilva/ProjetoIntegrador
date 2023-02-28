package com.example.RentCars.service.impl;


import com.example.RentCars.model.Carro;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.repository.ICarroRepository;
import com.example.RentCars.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements IService<CarroDTO> {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICarroRepository carroRepository;

    @Override
    public CarroDTO create(CarroDTO carroDTO) {
        Carro carro = new Carro(carroDTO);
        carro = carroRepository.save(carro);
        carroDTO = new CarroDTO(carro);
        return carroDTO;
    }

    @Override
    public CarroDTO getById(int id) throws Exception {
        Optional<Carro> carroOptional = carroRepository.findById(id);
        if(!carroOptional.isPresent()) {
            throw new Exception("Carro não encontrado");
        }
        return modelMapper.map(carroOptional.get(), CarroDTO.class);
    }

    @Override
    public String delete(int id) {
        carroRepository.deleteById(id);
        return "Carro deletado" + id;
    }

    @Override
    public CarroDTO update(CarroDTO carroDTO) {
        Carro carro = new Carro(carroDTO);
        carroRepository.saveAndFlush(carro);
        carroDTO = new CarroDTO(carro);
        return carroDTO;
    }

    public boolean ifCarroExists(int id) {
        return carroRepository.existsById(id);
    }

    @Override
    public List<CarroDTO> getAll() {
        List<Carro> carroList = carroRepository.findAll();
        List<CarroDTO> carroDTOS = new ArrayList<>();

        for (Carro carro: carroList) {
            CarroDTO carroDTO = new CarroDTO(carro);
            carroDTOS.add(carroDTO);
        }
        return carroDTOS;
    }

    public CarroDTO getByModelo(String modelo) {
        Carro carro = carroRepository.findByModelo(modelo);
        CarroDTO carroDTO = new CarroDTO(carro);
        return carroDTO;

    }
}
