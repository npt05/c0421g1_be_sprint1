package com.codegym.service.impl;
import com.codegym.entity.about_account.Account;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    //    Kiet login 23/10 UserDetailService use this function
    @Override
    public Account findByUsername(String username) {
        return this.accountRepository.findAccountByUsername(username);
    }
}
