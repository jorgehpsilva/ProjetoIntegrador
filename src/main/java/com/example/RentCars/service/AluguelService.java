package com.example.RentCars.service;

import com.example.RentCars.model.Aluguel;

public class AluguelService {

    public Aluguel criarAluguel(int idCliente, int idCarro, int hr_Saida, int dt_Saida, int hr_Entrega, int dt_Entrega) {
        Aluguel aluguel = new Aluguel(idCliente, idCarro, hr_Saida, dt_Saida, hr_Entrega, dt_Entrega);

        return aluguel;

    }
}
