package com.example.RentCars.model.dto;

import com.example.RentCars.model.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String admin;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public ClienteDTO(String nome, String sobrenome, String email, String senha, String admin) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }
}
