package com.codegym.service;

import com.codegym.entity.about_account.Account;

import java.util.List;

public interface IAccountService extends GeneralService<Account, Integer>{
    Account save(Account account);
    List<Account> findAll();
    Account getById(Integer id);
    void saveAccount(String accountUsername, String accountPassword);

}
