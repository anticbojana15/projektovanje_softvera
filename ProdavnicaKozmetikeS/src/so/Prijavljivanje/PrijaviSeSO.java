/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Prijavljivanje;

import db.DatabaseBroker;
import domen.Radnik;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Dragan
 */
public class PrijaviSeSO extends OpstaSistemskaOperacija{
  
     Radnik radnik;
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova!");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
         Radnik rd = (Radnik) o;
         

         
         List<OpstiDomenskiObjekat> radnici = DatabaseBroker.vratiObjekat().vratiSve(rd);
        for (int i = 0; i < radnici.size(); i++) {
            Radnik r = (Radnik) radnici.get(i);
            if (r.getKorisnickoIme().equals(rd.getKorisnickoIme()) && r.getLozinka().equals(rd.getLozinka())) {
                radnik= (Radnik)radnici.get(i);
            }
        }
                  
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

   
}
        
      