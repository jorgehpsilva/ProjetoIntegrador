package com.example.RentCars.common;

import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.ClienteDTO;

public class ClienteMock {

    public ClienteDTO clienteDTO(){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("test");
        clienteDTO.setEmail("test@test.test");
        clienteDTO.setSenha("test");
        clienteDTO.setAdmin("test");
        clienteDTO.setSobrenome("TestTest");
        return clienteDTO;
    }

    public Cliente getClienteWithId() {
        Cliente cliente = getClienteDefault();
        cliente.setId(999);
        return cliente;
    }

    public Cliente getClienteDefault() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("test");
        cliente.setEmail("test@test.test");
        cliente.setSenha("test");
        cliente.setAdmin("test");
        cliente.setSobrenome("TestTest");
        return cliente;
    }

}
