package com.example.RentCars.model;

import com.example.RentCars.model.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String admin;

    public Cliente() {
    }

    public Cliente(int id, String nome, String sobrenome, String email, String senha, String admin) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public Cliente(ClienteDTO clienteDTO) {

    }
}
