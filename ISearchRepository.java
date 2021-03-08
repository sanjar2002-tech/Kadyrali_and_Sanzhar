package com.company.model.repositories;

import com.company.model.entities.Film;

import java.util.ArrayList;

public interface ISearchRepository {

    ArrayList<Film> getAllFilms();
    ArrayList<Film> getFilmsByGenre(String genre);




}
