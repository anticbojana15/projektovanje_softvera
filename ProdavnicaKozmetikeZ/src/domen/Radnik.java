/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Radnik implements Serializable, OpstiDomenskiObjekat{
  private int radnikID;
  private String JMBG;
   private String imePrezime;
   private String korisnickoIme;
   private String lozinka;

    public Radnik() {
    }

    public Radnik(int radnikID, String JMBG, String imePrezime, String korisnickoIme, String lozinka) {
        this.radnikID = radnikID;
        this.JMBG = JMBG;
        this.imePrezime = imePrezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.radnikID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Radnik other = (Radnik) obj;
        if (this.radnikID != other.radnikID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  imePrezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "Radnik";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return radnikID + ",'" + JMBG + "', '" + imePrezime + "', '" + korisnickoIme + "', '" + lozinka ;   
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
            List<OpstiDomenskiObjekat> radnici = new ArrayList<>();
        try {
            while (rs.next()) {               
                
                Radnik r = new Radnik();
                r.setRadnikID(rs.getInt("RadnikID"));
                r.setJMBG(rs.getString("JMBG"));
                r.setImePrezime(rs.getString("ImePrezime"));
                r.setKorisnickoIme(rs.getString("KorisnickoIme"));
                r.setLozinka(rs.getString("Lozinka"));                
                radnici.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return radnici;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public String vratiUslovZaLogovanje() {
      return " KorisnickoIme='" + korisnickoIme + "' AND Lozinka='" + lozinka + "'";
    }

    @Override
    public String vratiUslovZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaStorniranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
