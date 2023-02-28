package com.example.RentCars.model;

import com.example.RentCars.model.dto.CategoriasDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name ="categorias")
public class Categoria {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String qualificacao;
    private String descricao;
    private String url;

    public Categoria() {
    }

    public Categoria(int id, String qualificacao, String descricao, String url) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }

    public Categoria(CategoriasDTO categoriasDTO) {

    }
}
