package com.codegym.rest_controller;

import com.codegym.entity.about_account.Account;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Account account = this.accountService.getById(Math.toIntExact(id));
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
