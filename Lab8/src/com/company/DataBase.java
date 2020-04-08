package com.company;

import java.sql.*;

public class DataBase {

    public Connection con = null;
    private static DataBase single_instance = null;

    // controllere pentru baza de date
    ArtistController artistController;
    AlbumController albumController;

    //constructor privat
    private DataBase() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/musicalbums";
        con = DriverManager.getConnection(
                url, "dba", "sql");

        // controlere speciale pentru conexiunea curenta
        artistController = new ArtistController(con);
        albumController = new AlbumController(con);
    }

    // pentru a face clasa de tip singleton
    // apelam constructorul doar daca nu am creat nicio instanta pana acum
    public static DataBase getInstance() throws SQLException {
        if (single_instance == null)
            single_instance = new DataBase();
        return single_instance;
    }
}
