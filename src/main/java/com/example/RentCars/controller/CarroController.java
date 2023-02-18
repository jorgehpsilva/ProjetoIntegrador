package com.example.RentCars.controller;


import com.example.RentCars.model.Carro;
import com.example.RentCars.service.CarroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

    private CarroService carroService = new CarroService();

    @GetMapping("/")
    public Carro selecionarCarro() {
        return carroService.selecionarCarro(1, "Ka", "Ford", "Branco", "Econômico");

    }


    @GetMapping("selecionar2")
    public Carro selecionarCarro2() {
        return carroService.selecionarCarro(2, "Fiesta", "Ford", "Prata", "Sedan");

    }

    @GetMapping("selecionar3")
    public Carro selecionarCarro3() {
        return carroService.selecionarCarro(3, "Fusion", "Ford", "Preto", "Luxo");

    }
}
