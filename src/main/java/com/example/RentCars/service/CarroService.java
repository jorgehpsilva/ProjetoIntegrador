package com.example.RentCars.service;

import com.example.RentCars.model.Carro;

public class CarroService {

    public Carro selecionarCarro(int id, String modelo, String marca, String cor, String idcategoia) {

        Carro carro = new Carro(id, modelo, marca, cor, idcategoia);

        return carro;
    }
}
