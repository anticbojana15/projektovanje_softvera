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


public class VrstaProizvoda implements Serializable, OpstiDomenskiObjekat{
    private int vrstaProizvodaID;
    private String nazivVrsteProizvoda;

    public VrstaProizvoda() {
    }

    public VrstaProizvoda(int vrstaProizvodaID, String nazivVrsteProizvoda) {
        this.vrstaProizvodaID = vrstaProizvodaID;
        this.nazivVrsteProizvoda = nazivVrsteProizvoda;
    }

    public int getVrstaProizvodaID() {
        return vrstaProizvodaID;
    }

    public void setVrstaProizvodaID(int vrstaProizvodaID) {
        this.vrstaProizvodaID = vrstaProizvodaID;
    }

    public String getNazivVrsteProizvoda() {
        return nazivVrsteProizvoda;
    }

    public void setNazivVrsteProizvoda(String nazivVrsteProizvoda) {
        this.nazivVrsteProizvoda = nazivVrsteProizvoda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.vrstaProizvodaID;
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
        final VrstaProizvoda other = (VrstaProizvoda) obj;
        if (this.vrstaProizvodaID != other.vrstaProizvodaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivVrsteProizvoda;
    }

    @Override
    public String vratiNazivTabele() {
       return "VrstaProizvoda";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
         List<OpstiDomenskiObjekat> vrsteProizvoda=new ArrayList<>();
       try{
           while(rs.next()){
               int vrstaProizvodaID=rs.getInt("VrstaProizvodaID");
               String nazivVrsteProizvoda=rs.getString("NazivVrsteProizvoda");
               VrstaProizvoda vp=new VrstaProizvoda(vrstaProizvodaID, nazivVrsteProizvoda);
               vrsteProizvoda.add(vp);
           }
       } catch (SQLException ex) {
  ex.printStackTrace();
        }
       return vrsteProizvoda;
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

    @Override
    public String vratiUslovZaStorniranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
