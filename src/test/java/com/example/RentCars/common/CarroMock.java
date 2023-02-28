package com.example.RentCars.common;

import com.example.RentCars.model.Carro;

public class CarroMock {

    private final CategoriaMock categoriaMock = new CategoriaMock();

    public Carro getCarroWithId() {
        Carro carro = getCarroDefault();
        carro.setId(999);
        return carro;
    }

    public Carro getCarroDefault() {
        Carro carro = new Carro();
        carro.setId(1);
        carro.setCategoria(categoriaMock.getCategoriaWithId());
        carro.setCor("test");
        carro.setMarca("test");
        carro.setModelo("test");
        return carro;
    }

}
