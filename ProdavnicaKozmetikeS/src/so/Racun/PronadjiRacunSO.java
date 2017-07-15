/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Racun;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.StavkaRacuna;
import java.util.Iterator;
import java.util.List;
import so.OpstaSistemskaOperacija;


public class PronadjiRacunSO extends OpstaSistemskaOperacija {

    Racun racun;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova!");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        List<OpstiDomenskiObjekat> listaRacuna = DatabaseBroker.vratiObjekat().pronadji((Racun) o);
        if (listaRacuna.size() > 0) {
            Racun r = (Racun) listaRacuna.get(0);
            StavkaRacuna stavka = new StavkaRacuna();
            stavka.setRacun(r);
            r.setListaStavki((List<StavkaRacuna>) DatabaseBroker.vratiObjekat().vratiDecuRoditelja(stavka));
            List<StavkaRacuna> stavke= r.getListaStavki();
            racun = r;
        }


    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    
   
}
