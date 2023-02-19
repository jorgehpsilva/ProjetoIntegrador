package com.example.RentCars.service.impl;


import com.example.RentCars.model.Carro;
import com.example.RentCars.model.dto.CarroDTO;
import com.example.RentCars.repository.ICarroRepository;
import com.example.RentCars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroServiceImpl implements IService<CarroDTO> {

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
    public CarroDTO getById(int id) {
        Carro carro = carroRepository.findById(id).get();
        return new CarroDTO(carro);
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

    public CarroDTO getByNome(String nome) {
        Carro carro = carroRepository.findByNome(nome);
        CarroDTO carroDTO = new CarroDTO(carro);
        return carroDTO;

    }
}
