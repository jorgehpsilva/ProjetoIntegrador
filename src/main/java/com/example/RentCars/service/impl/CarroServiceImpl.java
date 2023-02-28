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

    @Autowired
    private CategoriaServiceImpl categoriaService;


    @Override
    public CarroDTO create(CarroDTO carroDTO) throws Exception {
        validateParams(carroDTO);
        Carro carroMapped = modelMapper.map(carroDTO, Carro.class);
        Carro carroSaved = carroRepository.save(carroMapped);
        return modelMapper.map(carroSaved, CarroDTO.class);
    }

    @Override
    public List<CarroDTO> getAll() {
        List<Carro> carroList = carroRepository.findAll();
        List<CarroDTO> carroDTOS = new ArrayList<>();

        for (Carro carro : carroList) {
            CarroDTO carroDTO = new CarroDTO(carro);
            carroDTOS.add(carroDTO);
        }
        return carroDTOS;
    }

    @Override
    public CarroDTO getById(int id) throws Exception {
        Optional<Carro> carroOptional = carroRepository.findById(id);
        if (!carroOptional.isPresent()) {
            throw new Exception("Carro não encontrado");
        }
        return modelMapper.map(carroOptional.get(), CarroDTO.class);
    }

    @Override
    public CarroDTO updateById(int id, CarroDTO carroDTO) throws Exception {
        CarroDTO carroFound = getById(id);
        validateParams(carroFound);
        Carro carroSaved = carroRepository.saveAndFlush(modelMapper.map(carroFound, Carro.class));
        return modelMapper.map(carroSaved, CarroDTO.class);
    }

    @Override
    public String deleteById(int id) {
        carroRepository.deleteById(id);
        return "Carro deletado" + id;
    }

    public boolean ifCarroExists(int id) {
        return carroRepository.existsById(id);
    }


    public CarroDTO getByModelo(String modelo) {
        Carro carro = carroRepository.findByModelo(modelo);
        CarroDTO carroDTO = new CarroDTO(carro);
        return carroDTO;

    }

    private void validateParams(CarroDTO carroDTO) throws Exception {
        categoriaService.getById(carroDTO.getIdCategoria());
    }
}
