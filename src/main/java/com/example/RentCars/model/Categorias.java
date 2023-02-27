package com.example.RentCars.model;

import com.example.RentCars.model.dto.CategoriasDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name ="tb_categorias")
public class Categorias {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include

    private int id;
    private String qualificacao;
    private String descricao;
    private String url;

    public Categorias() {
    }

    public Categorias(int id, String qualificacao, String descricao, String url) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }

    public Categorias(CategoriasDTO categoriasDTO) {

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
