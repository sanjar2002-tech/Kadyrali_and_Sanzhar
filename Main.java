package com.company;

import com.company.model.database.IDB;
import com.company.model.database.Postgres;
import com.company.model.repositories.AccountRepository;
import com.company.model.repositories.IAccountRepository;
import com.company.model.repositories.ISearchRepository;
import com.company.model.repositories.SearchRepository;
import com.company.view.Application;

public class Main {

    public static void main(String[] args) {

        // to store database
        IDB database = new Postgres();

        // create repositoriies
        ISearchRepository searchRepository = new SearchRepository(database);
        IAccountRepository accountRepository = new AccountRepository(database);


        // create applocation variable
        Application app = new Application(searchRepository, accountRepository);

        // start our starting function from application
        app.start();
    }

}
