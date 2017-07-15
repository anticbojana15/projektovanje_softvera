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
import java.util.Date;
import java.util.List;

public class Racun implements Serializable, OpstiDomenskiObjekat {

    private int racunID;
    private Date datum;
    private double iznos;
    private Radnik radnik;
    private List<StavkaRacuna> listaStavki;
    private boolean storniran;

    public Racun() {
        listaStavki = new ArrayList<StavkaRacuna>();
    }

    public Racun(int racunID, Date datum, double iznos, Radnik radnik, List<StavkaRacuna> listaStavki, boolean storniran) {
        this.racunID = racunID;
        this.datum = datum;
        this.iznos = iznos;
        this.radnik = radnik;
        this.listaStavki = listaStavki;
        this.storniran=storniran;
    }

    public boolean isStorinira() {
        return storniran;
    }

    public void setStorinira(boolean storinira) {
        this.storniran = storinira;
    }
    
    

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public void dodajStavku() throws Exception {

        int i;

        if (listaStavki.isEmpty()) {
            int rb = listaStavki.size() + 1;
            StavkaRacuna stavka = new StavkaRacuna(this, rb, 0, new Proizvod());
            listaStavki.add(stavka);
        } else {
            for (i = 0; i < listaStavki.size() - 1;) {
                i++;
            }

            StavkaRacuna st = listaStavki.get(i);
            int stavkaID = st.getRb();
            StavkaRacuna stavka = new StavkaRacuna(this, stavkaID + 1, 0, new Proizvod());
            listaStavki.add(stavka);
        }

    }

    public void obrisiStavku(int red) {
        listaStavki.remove(red);
        izracunajUkupno();
    }

    @Override
    public String vratiNazivTabele() {
       return "Racun";
    }

    @Override
    public String vratiVrednostiZaInsert() {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return racunID+ ", '"  + sdf.format(datum) + "', " + iznos + ", "+ radnik.getRadnikID()+", " + storniran;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return " Datum='" + sdf.format(datum) + "', Iznos=" + iznos + ", RadnikID=" + radnik.getRadnikID();
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
        return "RacunID="+ racunID ; 
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
         return "RacunID="+ racunID ; 
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
         List<OpstiDomenskiObjekat> racuni=new ArrayList<>();
           
       try{
           while(rs.next()){
               Radnik rd = new Radnik();
               rd.setRadnikID(rs.getInt("RadnikID"));
               
               Racun r = new Racun();
               r.setRacunID(rs.getInt("RacunID"));
               r.setDatum(rs.getDate("Datum"));
               r.setIznos(rs.getDouble("Iznos"));   
               r.setStorinira(rs.getBoolean("storniran"));
               r.setRadnik(rd);
               racuni.add(r);
           }
       } catch (SQLException ex) {
  ex.printStackTrace();
        }
       return racuni;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public String vratiUslovZaLogovanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void izracunajUkupno() {
        iznos = 0.0;
        for (int i = 0; i < listaStavki.size(); i++) {
            StavkaRacuna s = listaStavki.get(i);
            iznos += s.getKolicina()*s.getProizvod().getCena();
        }
    }

    @Override
    public String vratiUslovZaStorniranje() {
        return "storniran="+ storniran ; 
    }
    }
