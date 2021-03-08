package com.company.model.repositories;

import com.company.model.database.IDB;
import com.company.model.entities.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountRepository implements IAccountRepository{

    private final IDB db;

    public AccountRepository(IDB db) {
        this.db = db;
    }


    public void registerAccount(Account newAcc){
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "insert into accounts values (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, newAcc.getLogin());
            st.setString(2, newAcc.getPassword());
            st.setBoolean(3, newAcc.isSubscription());

            st.execute();

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public Account loginAccount(Account acc){
        Connection con = null;


        try {

            con = db.getConnection();
            String sql = "select * from accounts where login=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, acc.getLogin());

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                if(rs.getString(1).equals(acc.getLogin()) && rs.getString(2).equals(acc.getPassword())){
                    return (new Account(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
                }
            }


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
