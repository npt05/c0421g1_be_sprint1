package com.codegym.service.impl;

import com.codegym.entity.about_account.Account;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account getById(Integer id) {
        return null;
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Account> search(String search) {
        return null;
    }
}
