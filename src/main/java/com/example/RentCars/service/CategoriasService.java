package com.example.RentCars.service;

import com.example.RentCars.model.Categorias;

public class CategoriasService {

    public Categorias selecionarCategorias(int id, String qualificacao, String descricao, String url) {
        Categorias categorias = new Categorias(id, qualificacao, descricao, url);

        return categorias;
    }
}
