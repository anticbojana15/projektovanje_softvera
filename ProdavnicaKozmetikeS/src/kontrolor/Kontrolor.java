/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolor;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import domen.Racun;
import domen.Radnik;
import domen.VrstaProizvoda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.Prijavljivanje.PrijaviSeSO;
import so.Proizvod.IzmeniProizvodSO;
import so.Proizvod.ObrisiProizvodSO;
import so.Proizvod.PronadjiProizvodSO;
import so.Proizvod.SacuvajProizvodSO;
import so.Proizvod.VratiProizvodeSO;
import so.Proizvod.VratiVrsteProizvodaSO;
import so.Racun.IzmeniRacunSO;
import so.Racun.StornirajiRacunSO;
import so.Racun.PronadjiRacunSO;
import so.Racun.SacuvajRacunSO;
import so.Racun.VratiRadnikeSO;

/**
 *
 * @author Dragan
 */
public class Kontrolor {

    private DatabaseBroker db;
    private static Kontrolor k;

    public Kontrolor() {
        db = new DatabaseBroker();
    }

    public static Kontrolor vratiObjekat() {
        if (k == null) {
            k = new Kontrolor();
        }
        return k;
    }

    public Radnik prijaviSe(Radnik radnik) throws ClassNotFoundException, SQLException, Exception {

        PrijaviSeSO rd = new PrijaviSeSO();
        rd.izvrsiOperaciju(radnik);
        return rd.getRadnik();
    }

    public List<OpstiDomenskiObjekat> vratiVrsteProizvoda() throws ClassNotFoundException, SQLException, Exception {

        VratiVrsteProizvodaSO vvp = new VratiVrsteProizvodaSO();
        vvp.izvrsiOperaciju(new VrstaProizvoda());
        return vvp.getLista();
    }

    public List<OpstiDomenskiObjekat> vratiProizvode() throws ClassNotFoundException, SQLException, Exception {

        VratiProizvodeSO vp = new VratiProizvodeSO();
        vp.izvrsiOperaciju(new Proizvod());
        return vp.getLista();
    }
    
    public List<OpstiDomenskiObjekat> vratiRadnike() throws ClassNotFoundException, SQLException, Exception {

        VratiRadnikeSO vr = new VratiRadnikeSO();
        vr.izvrsiOperaciju(new Radnik());
        return vr.getLista();
    }

    public void sacuvajProizvod(Proizvod proizvod) throws ClassNotFoundException, SQLException, Exception {

        SacuvajProizvodSO p = new SacuvajProizvodSO();
        p.izvrsiOperaciju(proizvod);
    }

    public void izmeniProizvod(Proizvod proizvod) throws ClassNotFoundException, SQLException, Exception {

        IzmeniProizvodSO p = new IzmeniProizvodSO();
        p.izvrsiOperaciju(proizvod);
    }

    public void obrisiProizvod(Proizvod proizvod) throws ClassNotFoundException, SQLException, Exception {

        ObrisiProizvodSO p = new ObrisiProizvodSO();
        p.izvrsiOperaciju(proizvod);
    }

    public Proizvod pronadjiProizvod(Proizvod proizvod) throws ClassNotFoundException, SQLException, Exception {

        PronadjiProizvodSO p = new PronadjiProizvodSO();
        p.izvrsiOperaciju(proizvod);
        return p.getProizvod();
    }

    public void sacuvajRacun(Racun racun) throws ClassNotFoundException, SQLException, Exception {

        SacuvajRacunSO r = new SacuvajRacunSO();
        r.izvrsiOperaciju(racun);
    }

    public void izmeniRacun(Racun racun) throws ClassNotFoundException, SQLException, Exception {

        IzmeniRacunSO r = new IzmeniRacunSO();
        r.izvrsiOperaciju(racun);
    }

    public void strornirajRacun(Racun racun) throws ClassNotFoundException, SQLException, Exception {

        StornirajiRacunSO r = new StornirajiRacunSO();
        r.izvrsiOperaciju(racun);
    }

    public Racun pronadjiRacun(Racun racun) throws ClassNotFoundException, SQLException, Exception {

        PronadjiRacunSO r = new PronadjiRacunSO();
        r.izvrsiOperaciju(racun);
        return r.getRacun();
    }
}
