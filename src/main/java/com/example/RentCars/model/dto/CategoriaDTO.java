package com.example.RentCars.model.dto;

import com.example.RentCars.model.Categoria;
import lombok.Data;

@Data
public class CategoriaDTO {

    private String qualificacao;
    private String descricao;
    private String url;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }

    public CategoriaDTO(String qualificacao, String descricao, String url) {
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }
}
