package com.example.RentCars.model.dto;

import com.example.RentCars.model.Carro;
import lombok.Data;

@Data
public class CarroDTO {

    private String modelo;
    private String marca;
    private String cor;
    private int idCategoria;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }

    public CarroDTO(String modelo, String marca, String cor, int idCategoria) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }
}
