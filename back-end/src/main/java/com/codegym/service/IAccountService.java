package com.codegym.service;


import com.codegym.entity.about_account.Account;

import java.util.List;

public interface IAccountService{
    List<Account> findAll();

    Account getById(Integer id);

    Account save(Account e);

    void delete(Integer id);

    List<Account> search(String search);
}
