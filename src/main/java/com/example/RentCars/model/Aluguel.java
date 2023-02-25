package com.example.RentCars.model;

import com.example.RentCars.model.dto.AluguelDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_aluguel")

public class Aluguel {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include

    private int id;

    @JoinColumn(name="cliente_id")
    private int idCliente;
        @JoinColumn(name="carro_id")
    private int idCarro;
    private int hr_Saida;
    private int dt_Saida;
    private int hr_Entrega;
    private int dt_Entrega;

    public Aluguel() {
    }

    public Aluguel(int idCliente, int idCarro, int hr_Saida, int dt_Saida, int hr_Entrega, int dt_Entrega) {
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
