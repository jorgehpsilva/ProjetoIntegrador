package com.example.RentCars.model;

import com.example.RentCars.model.dto.ClienteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_cliente")

public class Cliente {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include

    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String admin;

    public Cliente() {
    }

    public Cliente(int id, String nome, String sobrenome, String email, String senha, String admin) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public Cliente(ClienteDTO clienteDTO) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Carro getCategorias() {
            return null;
    }

    public void setCategorias(Categorias categorias) {

    }
}
