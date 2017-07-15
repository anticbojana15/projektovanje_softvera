/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import domen.Racun;
import domen.Radnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontrolor.Kontrolor;
import transfer.TransferObjekat;

/**
 *
 * @author Dragan
 */
public class NitObradaKlijenta extends Thread {

    Socket refKlijent;
    ObjectInputStream inSocket;
    ObjectOutputStream outSocket;

    public NitObradaKlijenta(Socket refKlijent) throws IOException {
        this.refKlijent = refKlijent;
        inSocket = new ObjectInputStream(refKlijent.getInputStream());
        outSocket = new ObjectOutputStream(refKlijent.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {

                Object obj = inSocket.readObject();
                TransferObjekat kto = (TransferObjekat) obj;
                int operacija = kto.getOperacija();
                TransferObjekat sto = new TransferObjekat();

                switch (operacija) {


                    case konstante.Konstante.PRIJAVI_SE:
                        try {
                            Radnik ulogovan = null;
                            Radnik radnik = (Radnik) kto.getPodaci();
                            ulogovan = Kontrolor.vratiObjekat().prijaviSe(radnik);
                            if (ulogovan == null) {
                                sto.setIzuzetak(new Exception("Radnik sa unetim korisničkim imenom i lozinkom ne postoji!"));

                            }
                            sto.setPodaci(ulogovan);
                            sto.setPoruka("Uspešno prijavljivanje!");


                        } catch (Exception ex) {
                            sto.setIzuzetak(ex);
                            ex.printStackTrace();
                        }
                        break;

                    case konstante.Konstante.SACUVAJ_PROIZVOD:
                        Object proizvod = kto.getPodaci();
                        try {
                            Kontrolor.vratiObjekat().sacuvajProizvod((Proizvod) proizvod);
                            sto.setSignal(true);
                            sto.setPoruka("Proizvod je uspešno sačuvan!");
                        } catch (Exception ex) {

                            sto.setIzuzetak(new Exception("Proizvod nije sačuvan!"));
                            ex.printStackTrace();
                        }
                        break;

                    case konstante.Konstante.VRATI_PROIZVODE:
                        try {
                            List<OpstiDomenskiObjekat> proizvodi = Kontrolor.vratiObjekat().vratiProizvode();
                            sto.setSignal(true);
                            sto.setPodaci(proizvodi);
                        } catch (Exception e) {
                            sto.setSignal(false);
                            sto.setPoruka("Proizvodi nisu vraćeni!");
                        }
                        break;
                        
                    case konstante.Konstante.VRATI_RADNIKE:
                        try {
                            List<OpstiDomenskiObjekat> radnici = Kontrolor.vratiObjekat().vratiRadnike();
                            sto.setSignal(true);
                            sto.setPodaci(radnici);
                        } catch (Exception e) {
                            sto.setSignal(false);
                            sto.setPoruka("Radnici nisu vraćeni!");
                        }
                        break;    

                    case konstante.Konstante.IZMENI_PROIZVOD:

                        try {
                            Object pr = kto.getPodaci();
                            Kontrolor.vratiObjekat().izmeniProizvod((Proizvod) pr);
                            sto.setPoruka("Proizvod je uspešno izmenjen!");

                        } catch (Exception ex) {

                            sto.setIzuzetak(new Exception("Proizvod nije izmenjen!"));
                            ex.printStackTrace();
                        }
                        break;

                    case konstante.Konstante.OBRISI_PROIZVOD:
                        Object pro = kto.getPodaci();
                        try {
                            Kontrolor.vratiObjekat().obrisiProizvod((Proizvod) pro);
                            sto.setSignal(true);
                            sto.setPoruka("Proizvod je uspešno obrisan!");
                        } catch (Exception ex) {
                            
                            sto.setIzuzetak(new Exception("Proizvod nije obrisan!"));
                            ex.printStackTrace();
                        }
                        break;


                    case konstante.Konstante.PRONADJI_PROIZVOD:
                        try {
                            Proizvod pronadjiProizvod = (Proizvod) kto.getPodaci();
                            Proizvod proizv = Kontrolor.vratiObjekat().pronadjiProizvod(pronadjiProizvod);

                            if (proizv == null) {
                                sto.setIzuzetak(new Exception("Traženi proizvod nije pronađen!"));

                            }
                            sto.setSignal(true);
                            sto.setPodaci(proizv);

                        } catch (Exception ex) {

                            sto.setIzuzetak(ex);
                            ex.printStackTrace();
                        }
                        break;


                    case konstante.Konstante.VRATI_VRSTE_PROIZVODA:
                        try {
                            List<OpstiDomenskiObjekat> vp = Kontrolor.vratiObjekat().vratiVrsteProizvoda();
                            sto.setSignal(true);
                            sto.setPodaci(vp);

                        } catch (Exception e) {
                            sto.setSignal(false);
                            sto.setPoruka("Vrste proizvoda nisu vraćene!");
                        }
                        break;

                    case konstante.Konstante.SACUVAJ_RACUN:
                        Object racun = kto.getPodaci();
                        try {
                            kontrolor.Kontrolor.vratiObjekat().sacuvajRacun((Racun) racun);
                            sto.setSignal(true);
                            sto.setPoruka("Račun je uspešno sačuvan!");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                             sto.setIzuzetak(new Exception("Račun nije sačuvan!"));
                        }
                        break;

                    case konstante.Konstante.IZMENI_RACUN:
                        try {

                            Object r = kto.getPodaci();
                            kontrolor.Kontrolor.vratiObjekat().izmeniRacun((Racun) r);
                            sto.setPoruka("Račun je uspešno izmenjen!");

                        } catch (Exception ex) {

                            sto.setIzuzetak(new Exception("Račun nije izmenjen!"));
                            ex.printStackTrace();
                        }
                        break;

                    case konstante.Konstante.STORNIRAJ:
                        Object rc = kto.getPodaci();
                        try {
                            kontrolor.Kontrolor.vratiObjekat().strornirajRacun((Racun)rc);
                            sto.setSignal(true);
                            sto.setPoruka("Račun je storniran!");
                        } catch (Exception ex) {
                            Logger.getLogger(NitObradaKlijenta.class.getName()).log(Level.SEVERE, null, ex);
                            sto.setSignal(false);
                            sto.setPoruka("Račun nije storniran!");
                            ex.printStackTrace();
                        }
                        break;

                    case konstante.Konstante.PRONADJI_RACUN:
                        try {
                            Racun racunPronadji = (Racun) kto.getPodaci();
                            Racun rac = kontrolor.Kontrolor.vratiObjekat().pronadjiRacun(racunPronadji);
                            if (rac == null) {
                                sto.setIzuzetak(new Exception("Traženi račun nije pronađen!"));

                            }
                            sto.setSignal(true);
                            sto.setPodaci(rac);
                        } catch (Exception ex) {

                            sto.setIzuzetak(ex);
                            ex.printStackTrace();
                        }
                        break;

                }
                outSocket.writeObject(sto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
