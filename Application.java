package com.company.view;

import com.company.controller.AccountController;
import com.company.controller.SearchController;
import com.company.model.entities.Account;
import com.company.model.entities.Film;
import com.company.model.repositories.IAccountRepository;
import com.company.model.repositories.ISearchRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private final AccountController accountController;
    private final SearchController searchController;

    public Application(ISearchRepository searchRepository, IAccountRepository accountRepository){
        accountController = new AccountController(accountRepository);
        searchController = new SearchController(searchRepository);
    }

    public void start(){ // starting function

        Scanner in = new Scanner(System.in);

        System.out.println("Hello, welcome to the best cinema app");


        while(true){ // endles loop
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.println("0: Exit");

            int choice = in.nextInt();

            if(choice == 1){
                String login;
                String password;
                System.out.println("Enter login:");
                login = in.next();
                System.out.println("Enter password:");
                password = in.next();
                Account user;
                if(accountController.loginAccount(new Account(login, password, false)) == null){
                    System.out.println("Wrong login or password");
                } else {
                    user = accountController.loginAccount(new Account(login, password, false));
                    System.out.println("Welcome " + user.getLogin());
                    while (true) {
                        System.out.println("1: Show all films");
                        System.out.println("2: Show films by genre");
                        System.out.println("0: Exit");

                        choice = in.nextInt();

                        if (choice == 1) {
                            ArrayList<Film> films = searchController.getAllFilms();
                            for(Film to : films){
                                System.out.println(to.toString());
                            }
                            System.out.println("Would you buy one? 1 = YES, 0 = NO");
                            int c = in.nextInt();

                            if(c == 1){
                                System.out.println("Input id of film");
                                int film_id = in.nextInt();

                                for(Film to : films){
                                    if(to.getId() == film_id){
                                        if(user.isSubscription() == true && to.isSubscription() == true){
                                            System.out.println("Congratulations, we added this film");
                                        } else if(user.isSubscription() == false && to.isSubscription() == true){
                                            System.out.println("Sorry, this films requires subscription");
                                        } else {
                                            System.out.println("Congratulations, we added this film");
                                        }
                                    }
                                }

                            } else {
                                continue;
                            }

                        } else if (choice == 2) {
                            System.out.println("Enter genre");
                            String genre = in.next();
                            ArrayList<Film> films = searchController.getFilmsByGenre(genre);

                            for(Film to : films){
                                System.out.println(to.toString());
                            }
                            System.out.println("Would you buy one? 1 = YES, 0 = NO");
                            int c = in.nextInt();

                            if(c == 1){
                                System.out.println("Input id of film");
                                int film_id = in.nextInt();

                                for(Film to : films){
                                    if(to.getId() == film_id){
                                        if(user.isSubscription() == true && to.isSubscription() == true){
                                            System.out.println("Congratulations, we added this film");
                                        } else if(user.isSubscription() == false && to.isSubscription() == true){
                                            System.out.println("Sorry, this films requires subscription");
                                        } else {
                                            System.out.println("Congratulations, we added this film");
                                        }
                                    }
                                }
                            } else {
                                continue;
                            }
                        } else {
                            System.exit(0);
                        }

                    }
                }

            } else if(choice == 2){
                String login, password;
                System.out.println("Input login:");
                login = in.next();
                System.out.println("Input password");
                password = in.next();

                int sub;

                System.out.println("Would you buy subscription? It costs 9.99$  1 = YES, 0 = NO");
                sub = in.nextInt();

                boolean subscription;
                if(sub == 1){
                    subscription = true;
                } else {
                    subscription = false;
                }

                accountController.registerAccount(new Account(login, password, subscription));


            } else {
                System.exit(0);
            }
        }

    }


    void showFilmsByGenre(String genre){
        ArrayList<Film> films = searchController.getFilmsByGenre(genre);

        for(Film to : films){
            System.out.println(to.toString());
        }
    }




}
