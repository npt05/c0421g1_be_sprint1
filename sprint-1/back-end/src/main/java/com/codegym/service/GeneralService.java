package com.codegym.service;


import java.util.List;

public interface GeneralService <E, T>{
    //E là tên class, T là Wrapper class của id class đó

    List<E> findAll();

    E getById(T id);

    E save(E e);

    void delete(T id);

    List<E> search(String search);
}
