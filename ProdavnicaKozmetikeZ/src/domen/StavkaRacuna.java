/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class StavkaRacuna implements Serializable, OpstiDomenskiObjekat {
    private Racun racun;
    private int rb;
    private int kolicina;
    private Proizvod proizvod;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int rb, int kolicina, Proizvod proizvod) {
        this.racun = racun;
        this.rb = rb;
        this.kolicina = kolicina;
        this.proizvod = proizvod;
    }
    
     public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
    

    @Override
    public String vratiNazivTabele() {
       return "StavkaRacuna";
    }

    @Override
    public String vratiVrednostiZaInsert() {        
        return racun.getRacunID() + ", " + rb + "," + kolicina + ", " + proizvod.getProizvodID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "  Kolicina=" + kolicina + ",ProizvodID="+proizvod.getProizvodID();
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
       return "RacunID="+ racun.getRacunID() + " AND Rb="+ rb ;
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        return "RacunID="+ racun.getRacunID();
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
       return "StavkaRacuna.RacunID="+racun.getRacunID();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
        List<OpstiDomenskiObjekat> stavke=new ArrayList<>();
        
       try{
           while(rs.next()){
               
               Racun r = new Racun();
               r.setRacunID(rs.getInt("RacunID"));
        
              Proizvod p = new Proizvod();
               p.setProizvodID(rs.getInt("ProizvodID"));
               p.setNaziv(rs.getString("Naziv"));
               p.setCena(rs.getDouble("Cena"));
               StavkaRacuna st = new StavkaRacuna();
               st.setRacun(r);
               st.setRb(rs.getInt("Rb"));
               st.setKolicina(rs.getInt("Kolicina"));               
               st.setProizvod(p);
               
                        stavke.add(st);
           }
       } catch (SQLException ex) {
  ex.printStackTrace();
        }
       return stavke;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
      return "Proizvod JOIN (Racun  JOIN  StavkaRacuna ON  Racun.RacunID = StavkaRacuna.RacunID) ON Proizvod.ProizvodID = StavkaRacuna.ProizvodID";
    }

    

    @Override
    public String vratiUslovZaLogovanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        return "StavkaRacuna.Rb";
    }

    @Override
    public String vratiUslovZaStorniranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
