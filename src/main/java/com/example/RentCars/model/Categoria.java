package com.example.RentCars.model;

import com.example.RentCars.model.dto.CategoriaDTO;
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

    private String url;
    private String descricao;
    private String qualificacao;

    public Categoria() {
    }

    public Categoria(int id, String qualificacao, String descricao, String url) {
        this.id = id;
        this.url = url;
        this.descricao = descricao;
        this.qualificacao = qualificacao;
    }

    public Categoria(CategoriaDTO categoriaDTO) {

    }
}
