package com.codegym.service;

import com.codegym.entity.about_account.Account;

public interface IAccountService{
    Account findByUsername(String username);
}
