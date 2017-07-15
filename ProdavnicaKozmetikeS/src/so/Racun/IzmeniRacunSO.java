/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Racun;

import db.DatabaseBroker;
import domen.Racun;
import domen.StavkaRacuna;
import java.util.Iterator;
import so.OpstaSistemskaOperacija;


public class IzmeniRacunSO extends OpstaSistemskaOperacija {
       @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova!");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
           DatabaseBroker.vratiObjekat().izmeni((Racun) o);
        Racun r = (Racun) o;
        StavkaRacuna st = new StavkaRacuna();
        st.setRacun(r);
        DatabaseBroker.vratiObjekat().obrisiSveSlogovePoRoditelju(st);
        for (Iterator it = r.getListaStavki().iterator(); it.hasNext();) {
            
            StavkaRacuna stavka = (StavkaRacuna) it.next();
            
            DatabaseBroker.vratiObjekat().sacuvaj(stavka);
        }
     
        }
        
    }
