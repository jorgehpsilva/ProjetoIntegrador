package com.example.RentCars.common;

import com.example.RentCars.model.Aluguel;
import com.example.RentCars.model.dto.AluguelDTO;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AluguelMock {

    private final CarroMock carroMock = new CarroMock();
    private final ClienteMock clienteMock = new ClienteMock();

    public AluguelDTO getAluguelRequestDTO(){
        AluguelDTO aluguelDTO = new AluguelDTO();
        aluguelDTO.setDt_Entrega(new Date(2023,2,28));
        aluguelDTO.setDt_Saida(new Date(2023,2,1));
        aluguelDTO.setHr_Entrega(new Time(1,0,0));
        aluguelDTO.setHr_Saida(new Time(9,9,9));
        aluguelDTO.setIdCarro(1);
        aluguelDTO.setIdCliente(1);
        aluguelDTO.setIdCategoria(1);
        return aluguelDTO;
    }

    public Aluguel getAluguelWithId(){
        Aluguel aluguel = getAluguelDefault();
        aluguel.setId(999);
        return aluguel;
    }

    public Optional<Aluguel> getOptionalAluguel(){
        Aluguel aluguel = getAluguelWithId();
        return Optional.of(aluguel);
    }

    public Aluguel getAluguelDefault() {
        Aluguel aluguel = new Aluguel();
        aluguel.setId(1);
        aluguel.setCarro(carroMock.getCarroWithId());
        aluguel.setCliente(clienteMock.getClienteWithId());
        aluguel.setDt_Entrega(new Date(2023,2,28));
        aluguel.setDt_Saida(new Date(2023,2,1));
        aluguel.setHr_Entrega(new Time(1,0,0));
        aluguel.setHr_Saida(new Time(9,9,9));
        return aluguel;
    }

    public List<Aluguel> getAluguelListTest() {
        List<Aluguel> alugueis = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(i);
            aluguel.setCarro(carroMock.getCarroWithId());
            aluguel.setCliente(clienteMock.getClienteWithId());
            aluguel.setDt_Entrega(new Date(2023,2,28));
            aluguel.setDt_Saida(new Date(2023,2,1));
            aluguel.setHr_Entrega(new Time(1,0,0));
            aluguel.setHr_Saida(new Time(9,9,9));
            alugueis.add(aluguel);
        }
        return alugueis;
    }
}
