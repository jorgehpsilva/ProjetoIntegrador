package com.example.RentCars.model.dto;

import com.example.RentCars.model.Aluguel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

@Data
public class AluguelDTO {

    private int idCliente;
    private int idCarro;
    private int idCategoria;

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


    public AluguelDTO(int idCliente, int idCarro, int idCategoria, Time hr_Saida, Date dt_Saida, Time hr_Entrega, Date dt_Entrega) {
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.hr_Saida = hr_Saida;
        this.dt_Saida = dt_Saida;
        this.hr_Entrega = hr_Entrega;
        this.dt_Entrega = dt_Entrega;
        this.idCategoria = idCategoria;
    }

    public AluguelDTO() {
    }
    public AluguelDTO(Aluguel aluguel) {

    }
}
