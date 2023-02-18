package com.example.RentCars.model.dto;

import com.example.RentCars.model.Categorias;

public class CategoriasDTO {

    private int id;
    private String qualificacao;
    private String descricao;
    private String url;

    public CategoriasDTO() {
    }

    public CategoriasDTO(Categorias categorias) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
