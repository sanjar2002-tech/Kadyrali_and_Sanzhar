package com.company.controller;

import com.company.model.entities.Film;
import com.company.model.repositories.ISearchRepository;

import java.util.ArrayList;

public class SearchController {
    private final ISearchRepository repo;

    public SearchController(ISearchRepository repo) {
        this.repo = repo;
    }

    // method to get array list of all films
   public ArrayList<Film> getAllFilms(){
        return repo.getAllFilms();
   }

   // method to get array list of all films by given genre
   public ArrayList<Film> getFilmsByGenre(String genre){
        return repo.getFilmsByGenre(genre);
   }

}
