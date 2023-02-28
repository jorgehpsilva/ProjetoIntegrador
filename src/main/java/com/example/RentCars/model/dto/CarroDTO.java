package com.example.RentCars.model.dto;

import com.example.RentCars.model.Carro;
import lombok.Data;

@Data
public class CarroDTO {

    private int id;
    private String modelo;
    private String marca;
    private String cor;
    private String idCategoria;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }

    public CarroDTO(int id, String modelo, String marca, String cor, String idCategoria) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }
}
