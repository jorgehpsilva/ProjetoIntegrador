package com.example.RentCars.service;

import java.util.List;

public interface IService<T> {

    T create(T t) throws Exception;
    T getById(int id) throws Exception;

    String delete(int id);

    T update(T t);

    List<T> getAll();
}
