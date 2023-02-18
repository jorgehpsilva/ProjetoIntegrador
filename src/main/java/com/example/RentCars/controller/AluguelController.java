package com.example.RentCars.controller;


import com.example.RentCars.model.Aluguel;
import com.example.RentCars.service.AluguelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AluguelController {

    private AluguelService aluguelService = new AluguelService();

    @GetMapping("/")
    public Aluguel criarAluguel() {
        return aluguelService.criarAluguel(1, 1, 900, 10/01, 900, 12/01);
    }

    @GetMapping("criar2")
    public Aluguel criarAluguel2() {
        return aluguelService.criarAluguel(2, 2, 900, 10/01, 900, 12/01);
    }
}
