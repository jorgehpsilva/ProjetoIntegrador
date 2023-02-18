package com.example.RentCars.controller;


import com.example.RentCars.model.Categorias;
import com.example.RentCars.service.CategoriasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriasController {

    private CategoriasService categoriasService = new CategoriasService();

    @GetMapping("/")
    public Categorias selecionarCategorias() {
        return categoriasService.selecionarCategorias(1, "Econômico", "Baixo consumo de combústivel", "www.imagem.com");
    }

    @GetMapping("selecionar2")
    public Categorias selecionarCategorias2() {
        return categoriasService.selecionarCategorias(2, "Sedan", "Maior espaço, economia e desempenho", "www.imagem.com");
    }

    @GetMapping("selecionar3")
    public Categorias selecionarCategorias3() {
        return categoriasService.selecionarCategorias(3, "Luxo", "Conforto, desempenho e estilo", "www.imagem.com");
    }
}
