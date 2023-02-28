package com.example.RentCars.model;

import com.example.RentCars.model.dto.CarroDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String modelo;
    private String marca;
    private String cor;

    @OneToOne
    @JoinColumn(name="categoria_id")
    private Categoria idCategoria;

    public Carro() {
    }

    public Carro(int id, String modelo, String marca, String cor, Categoria idCategoria) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }

    public Carro(CarroDTO carroDTO) {

    }
}
