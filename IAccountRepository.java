package com.company.model.repositories;

import com.company.model.entities.Account;

import java.util.ArrayList;

public interface IAccountRepository {

    void registerAccount(Account newAcc);
    Account loginAccount(Account acc);

}
