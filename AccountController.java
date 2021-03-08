package com.company.controller;

import com.company.model.entities.Account;
import com.company.model.repositories.IAccountRepository;

public class AccountController {
    private final IAccountRepository repo;

    public AccountController(IAccountRepository repo) {
        this.repo = repo;
    }


    // method to register a new user
    public void registerAccount(Account newAcc){
        repo.registerAccount(newAcc);
    }
    // method to login
    public Account loginAccount(Account acc){
        return repo.loginAccount(acc);
    }
}
