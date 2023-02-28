package com.example.RentCars.model.dto;

import com.example.RentCars.model.Categoria;
import lombok.Data;

@Data
public class CategoriasDTO {

    private int id;
    private String qualificacao;
    private String descricao;
    private String url;

    public CategoriasDTO() {
    }

    public CategoriasDTO(Categoria categoria) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }

    public CategoriasDTO(int id, String qualificacao, String descricao, String url) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }
}
