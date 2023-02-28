package com.example.RentCars.common;

import com.example.RentCars.model.Categoria;

public class CategoriaMock {

    public Categoria getCategoriaWithId() {
        Categoria categoria = getCategoriaDefault();
        categoria.setId(999);
        return categoria;
    }

    public Categoria getCategoriaDefault() {
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setUrl("https://www.test.com");
        categoria.setDescricao("descricao test");
        categoria.setQualificacao("qualificacao test");
        return categoria;
    }

}
