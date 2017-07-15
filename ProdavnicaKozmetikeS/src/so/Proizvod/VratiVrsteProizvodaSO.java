/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Proizvod;

import db.DatabaseBroker;
import domen.VrstaProizvoda;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;


public class VratiVrsteProizvodaSO extends OpstaSistemskaOperacija{
List<OpstiDomenskiObjekat> lista;
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova!");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista=DatabaseBroker.vratiObjekat().vratiSve((VrstaProizvoda)o);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
