/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Proizvod;

import db.DatabaseBroker;
import domen.Proizvod;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Dragan
 */
public class SacuvajProizvodSO extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova!");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
       DatabaseBroker.vratiObjekat().sacuvaj((Proizvod)o);
    }
    
}
