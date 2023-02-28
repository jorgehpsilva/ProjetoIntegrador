package com.example.RentCars.model.dto;

import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.Carro;
import com.example.RentCars.model.Categorias;
import com.example.RentCars.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

public class AluguelDTO {

    private int idCliente;
    private int idCarro;

    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time hr_Saida;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dt_Saida;

    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time hr_Entrega;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dt_Entrega;

    private Categorias categorias;

    private Carro carro;

    private Cliente cliente;

    public AluguelDTO(int idCliente, int idCarro, Time hr_Saida, Date dt_Saida, Time hr_Entrega, Date dt_Entrega, Categorias categorias, Carro carro, Cliente cliente) {
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.hr_Saida = hr_Saida;
        this.dt_Saida = dt_Saida;
        this.hr_Entrega = hr_Entrega;
        this.dt_Entrega = dt_Entrega;
        this.categorias = categorias;
        this.carro = carro;
        this.cliente = cliente;
    }

    public AluguelDTO() {
    }
    public AluguelDTO(Aluguel aluguel) {

    }
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCarro() {
        return idCarro;
    }
}
