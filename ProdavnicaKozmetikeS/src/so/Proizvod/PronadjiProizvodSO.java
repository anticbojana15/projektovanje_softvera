/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Proizvod;

import db.DatabaseBroker;
import domen.Proizvod;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;


public class PronadjiProizvodSO extends OpstaSistemskaOperacija{
    private Proizvod  proizvod;
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova!");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
       
         Proizvod p = (Proizvod) o;
         
         List<OpstiDomenskiObjekat> listaProizvoda = DatabaseBroker.vratiObjekat().vratiSpojeneTabeleSaUslovom(p);
         if  (listaProizvoda.size()>0){
             proizvod = (Proizvod) listaProizvoda.get(0);
         }
//         else{
//             throw new Exception("Ne postoji clan sa tom sifrom!");
//         }
         
         
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

  
}
