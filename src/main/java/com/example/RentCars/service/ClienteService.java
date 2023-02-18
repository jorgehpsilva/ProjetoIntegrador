package com.example.RentCars.service;

import com.example.RentCars.model.Cliente;

public class ClienteService {

    public Cliente criarCliente(int id, String nome, String sobrenome, String email, String senha, String admin) {
        Cliente cliente = new Cliente(id, nome, sobrenome, email, senha, admin);

        return cliente;
    }

}
