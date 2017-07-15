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


public class Proizvod implements Serializable, OpstiDomenskiObjekat{
  private int proizvodID;
  private String naziv;
  private double cena;
  private Date rokVazenja;
  private VrstaProizvoda vrstaProizvoda;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, String naziv, double cena, Date rokVazenja,VrstaProizvoda vrstaProizvoda) {
        this.proizvodID = proizvodID;
        this.naziv = naziv;
        this.cena = cena;
        this.rokVazenja = rokVazenja;
        this.vrstaProizvoda = vrstaProizvoda;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double Cena) {
        this.cena = Cena;
    }

    public Date getRokVazenja() {
        return rokVazenja;
    }

    public void setRokVazenja(Date rokVazenja) {
        this.rokVazenja = rokVazenja;
    }
 

    public VrstaProizvoda getVrstaProizvoda() {
        return vrstaProizvoda;
    }

    public void setVrstaProizvoda(VrstaProizvoda vrstaProizvoda) {
        this.vrstaProizvoda = vrstaProizvoda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.proizvodID;
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
        final Proizvod other = (Proizvod) obj;
        if (this.proizvodID != other.proizvodID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "Proizvod";
    }

    @Override
    public String vratiVrednostiZaInsert() {
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return proizvodID + ", '" + naziv + "', " + cena + ", '" + sdf.format(rokVazenja)  + "', " + vrstaProizvoda.getVrstaProizvodaID();        
    }

    @Override
    public String vratiVrednostiZaUpdate() {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return "Naziv='"+ naziv + "', Cena=" + cena + ",  RokVazenja='" + sdf.format(rokVazenja)  + "', VrstaProizvodaID=" + vrstaProizvoda.getVrstaProizvodaID();
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
        return "ProizvodID=" + proizvodID;
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
         return "ProizvodID=" + proizvodID;
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
               List<OpstiDomenskiObjekat> proizvodi = new ArrayList<>();
        try {
            while (rs.next()) {
                VrstaProizvoda vp = new VrstaProizvoda();
                vp.setVrstaProizvodaID(rs.getInt("VrstaProizvodaID"));
                vp.setNazivVrsteProizvoda(rs.getString("NazivVrsteProizvoda"));
                
                Proizvod p = new Proizvod();
                p.setProizvodID(rs.getInt("ProizvodID"));
                p.setNaziv(rs.getString("Naziv"));
                p.setCena(rs.getDouble("Cena"));
                p.setRokVazenja(rs.getDate("RokVazenja"));
                p.setVrstaProizvoda(vp);
                proizvodi.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proizvodi;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
       return "VrstaProizvoda JOIN Proizvod ON VrstaProizvoda.VrstaProizvodaID = Proizvod.VrstaProizvodaID";
    }

    

    @Override
    public String vratiUslovZaLogovanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
