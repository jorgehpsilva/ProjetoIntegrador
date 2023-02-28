package com.example.RentCars.model;

import com.example.RentCars.model.dto.AluguelDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "aluguel")

public class Aluguel {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @OneToOne
    @JoinColumn(name="cliente_id")
    private Cliente idCliente;
    @OneToOne
    @JoinColumn(name="carro_id")
    private Carro idCarro;

    @DateTimeFormat(pattern="hh:mm:ss")
    private Time hr_Saida;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dt_Saida;

    @DateTimeFormat(pattern="hh:mm:ss")
    private Time hr_Entrega;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dt_Entrega;

    public Aluguel() {
    }

    public Aluguel(Cliente idCliente, Carro idCarro, Time hr_Saida, Date dt_Saida, Time hr_Entrega, Date dt_Entrega) {
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.hr_Saida = hr_Saida;
        this.dt_Saida = dt_Saida;
        this.hr_Entrega = hr_Entrega;
        this.dt_Entrega = dt_Entrega;
    }
    public Aluguel(AluguelDTO aluguelDTO) {
}
    public void setCliente(Cliente cliente) {

    }
}
