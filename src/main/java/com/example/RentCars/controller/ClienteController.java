package com.example.RentCars.controller;

import com.example.RentCars.model.Cliente;
import com.example.RentCars.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    private ClienteService clienteService = new ClienteService();

    @GetMapping("/")
    public Cliente criarCliente(){
        return clienteService.criarCliente(1,"Adolfo", "Coelho", "acoelho@email.com", "123456", "não");

    }

    @GetMapping("criar2")
    public Cliente criarCliente2(){
        return clienteService.criarCliente(2,"Roger", "Castro", "rcastro@email.com", "654321", "sim");

    }

}
