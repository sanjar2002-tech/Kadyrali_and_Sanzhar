package com.company.model.repositories;

import com.company.model.database.IDB;
import com.company.model.entities.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchRepository implements ISearchRepository{

    private final IDB db;

    public SearchRepository(IDB db) {
        this.db = db;
    }

    public ArrayList<Film> getAllFilms(){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        ArrayList<Film> res = new ArrayList<>();

        try {

            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from films");


            // we go through all rows in result set and add to array list
            while(rs.next()){
                res.add(new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getFloat(5)));
            }


            // then give back this array list
            return res;

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return null;
    }
    public ArrayList<Film> getFilmsByGenre(String genre){
        Connection con = null;
        ResultSet rs = null;

        ArrayList<Film> res = new ArrayList<>();

        try {

            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("select * from films where genre=?");
            st.setString(1, genre);
            rs = st.executeQuery();

            // we store in array list all rows where column genre equals to our genre

            while(rs.next()){
                // add every row
                res.add(new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getFloat(5)));
            }

            // return array list
            return res;

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return null;
    }

}
