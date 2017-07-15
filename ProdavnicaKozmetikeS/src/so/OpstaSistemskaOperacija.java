/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;

/**
 *
 * @author Dragan
 */
public abstract class OpstaSistemskaOperacija {
    
    public final void izvrsiOperaciju(Object o) throws Exception{
        try{
            DatabaseBroker.vratiObjekat().otvoriBazu();
            proveriPreduslov(o);
            izvrsiKonkretnuOperaciju(o);
            DatabaseBroker.vratiObjekat().commitTransakcije();
        }catch(Exception e){
            DatabaseBroker.vratiObjekat().rollbackTransakcije();
            throw e;
        }finally{
            DatabaseBroker.vratiObjekat().zatvoriBazu();
        }
    }
  protected abstract void proveriPreduslov(Object o) throws Exception;
  protected abstract void izvrsiKonkretnuOperaciju(Object o) throws Exception;
}
