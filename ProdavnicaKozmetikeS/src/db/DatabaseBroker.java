/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DatabaseBroker {
    
    private static DatabaseBroker objekat;
    Connection connection;
    
     public static DatabaseBroker vratiObjekat() throws FileNotFoundException, IOException {
        if (objekat == null) {
            objekat = new DatabaseBroker();
        }
        return objekat;
    }

        public void otvoriBazu() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/prodavnicakozmetike";
        connection = DriverManager.getConnection(url, "root", "root");
        connection.setAutoCommit(false);
        System.out.println("Uspesno smo se povezali na bazu!");
    }
    

    public void zatvoriBazu() throws SQLException {
        connection.close();
    }

    public void commitTransakcije() throws SQLException {
        connection.commit();
    }

    public void rollbackTransakcije() throws SQLException {
        connection.rollback();
    }


    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
       
        String sql = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES " + "(" + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(sql);
        Statement sqlNStatement = connection.createStatement();
        sqlNStatement.executeUpdate(sql);
        sqlNStatement.close();


    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException, Exception {
        if (odo.vratiUslovZaIzmeniSlog() == null) {
            throw new Exception("ne postoji");
        }
        String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiUslovZaIzmeniSlog();
        System.out.println(sql);
        Statement sqlNStatement = connection.createStatement();
        int brojIzmenjenihRedova = sqlNStatement.executeUpdate(sql);
        sqlNStatement.close();
        if (brojIzmenjenihRedova == 0) {
            throw new Exception("Greska prilikom izmene. Nijeda red nije izmenjen verovatno ste promenili sifru");
        }
    }
    
        public void storniraj(OpstiDomenskiObjekat odo) throws SQLException, Exception {
      
        String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiUslovZaStorniranje() + " WHERE " + odo.vratiUslovZaIzmeniSlog();
        System.out.println(sql);
        Statement sqlNStatement = connection.createStatement();
        sqlNStatement.executeUpdate(sql);
        sqlNStatement.close();
       
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT * FROM " + odo.vratiNazivTabele();
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);

        return odo.vratiListuIzResultSet(rs);

    }

    public List<OpstiDomenskiObjekat> pronadji(OpstiDomenskiObjekat odo) throws Exception {

        String sql = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPronadjiSlog();
        System.out.println(sql);
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);


        return odo.vratiListuIzResultSet(rs);

    }

    public List<OpstiDomenskiObjekat> vratiSpojeneTabele(OpstiDomenskiObjekat odo) throws Exception {

        String sql = "SELECT * FROM " + odo.vratiNazivTabeleSaJOINom();
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);


        return odo.vratiListuIzResultSet(rs);

    }

    public List<OpstiDomenskiObjekat> vratiSpojeneTabeleSaUslovom(OpstiDomenskiObjekat odo) throws Exception {

        String sql = "SELECT * FROM " + odo.vratiNazivTabeleSaJOINom() + " WHERE " + odo.vratiUslovZaPronadjiSlog();
        System.out.println(sql);
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);


        return odo.vratiListuIzResultSet(rs);

    }

    public List<OpstiDomenskiObjekat> proveriUslovZaLogovanje(OpstiDomenskiObjekat odo) throws Exception {

        String sql = "SELECT * FROM " + odo.vratiNazivTabeleSaJOINom() + " WHERE " + odo.vratiUslovZaLogovanje();
        System.out.println(sql);
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);


        return odo.vratiListuIzResultSet(rs);

    }

    public List vratiDecuRoditelja(OpstiDomenskiObjekat tipDeteta) throws Exception {
        String sql = "SELECT * FROM " + tipDeteta.vratiNazivTabeleSaJOINom() + " WHERE " + tipDeteta.vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() + " ORDER BY " + tipDeteta.vratiUslovZaSortiranje() + " ASC ";
        System.out.println(sql);
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);

        return tipDeteta.vratiListuIzResultSet(rs);

    }

    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {

        String sql = "DELETE  FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPronadjiSlog();
        System.out.println(sql);
        Statement sqlNStatement = connection.createStatement();
        sqlNStatement.executeUpdate(sql);
        sqlNStatement.close();
       
    }

    public void obrisiSveSlogovePoRoditelju(OpstiDomenskiObjekat odo) throws Exception {

        String sql = "DELETE  FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPronadjiSlogoveVezaneZaRoditelja();
        System.out.println(sql);
        Statement sqlNStatement = connection.createStatement();
        sqlNStatement.executeUpdate(sql);
        sqlNStatement.close();
       
    }
}
