package com.example.RentCars.model;

public class Aluguel {

    private int idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public int getHr_Saida() {
        return hr_Saida;
    }

    public void setHr_Saida(int hr_Saida) {
        this.hr_Saida = hr_Saida;
    }

    public int getDt_Saida() {
        return dt_Saida;
    }

    public void setDt_Saida(int dt_Saida) {
        this.dt_Saida = dt_Saida;
    }

    public int getHr_Entrega() {
        return hr_Entrega;
    }

    public void setHr_Entrega(int hr_Entrega) {
        this.hr_Entrega = hr_Entrega;
    }

    public int getDt_Entrega() {
        return dt_Entrega;
    }

    public void setDt_Entrega(int dt_Entrega) {
        this.dt_Entrega = dt_Entrega;
    }
}
