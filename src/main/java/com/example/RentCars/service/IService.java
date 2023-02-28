package com.example.RentCars.service;

import java.util.List;

public interface IService<T> {

    T create(T t) throws Exception;
    T getById(int id) throws Exception;

    String deleteById(int id);

    T updateById(int id, T t) throws Exception;

    List<T> getAll();
}
