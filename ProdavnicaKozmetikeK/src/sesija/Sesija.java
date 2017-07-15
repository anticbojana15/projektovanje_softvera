/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Proizvod;
import domen.Racun;
import domen.Radnik;
import forme.FrmLogin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.TransferObjekat;


public class Sesija {

    private static Sesija sesija;
    private Socket socket;
    private ObjectInputStream inSocket;
    private ObjectOutputStream outSocket;
    private Radnik ulogovaniRadnik;

    public static Sesija dajObjekat() throws IOException {
        if (sesija == null) {
            sesija = new Sesija();
        }
        return sesija;
    }

    public Sesija() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
        outSocket = new ObjectOutputStream(socket.getOutputStream());
        inSocket = new ObjectInputStream(socket.getInputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void posaljiObjekat(TransferObjekat kto) throws IOException {
        outSocket.writeObject(kto);
    }

    public TransferObjekat procitajObjekat() throws IOException, ClassNotFoundException {
        return (TransferObjekat) inSocket.readObject();
    }

    public void prijaviSe(Radnik radnik) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.PRIJAVI_SE);
        kto.setPodaci(radnik);

        posaljiObjekat(kto);

    }

    public Radnik getUlogovaniRadnik() {
        return ulogovaniRadnik;
    }

    public void setUlogovaniRadnik(Radnik ulogovaniRadnik) {
        this.ulogovaniRadnik = ulogovaniRadnik;
    }

    
    public TransferObjekat sacuvajProizvod(Proizvod proizvod) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.SACUVAJ_PROIZVOD);
        kto.setPodaci(proizvod);

        outSocket.writeObject(kto);

        TransferObjekat sto = (TransferObjekat) inSocket.readObject();
        return sto;

    }

    
    public void pronadjiProizvod(Proizvod proizvod) throws IOException, ClassNotFoundException {
        TransferObjekat kto = new TransferObjekat();
        kto.setPodaci(proizvod);
        kto.setOperacija(konstante.Konstante.PRONADJI_PROIZVOD);

        posaljiObjekat(kto);

    }

    
    public void izmeniProizvod(Proizvod proizvod) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.IZMENI_PROIZVOD);
        kto.setPodaci(proizvod);

        posaljiObjekat(kto);

    }

    
    public void obrisiProizvod(Proizvod proizvod) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.OBRISI_PROIZVOD);
        kto.setPodaci(proizvod);


       posaljiObjekat(kto);


    }

    public TransferObjekat vratiVrsteProizvoda() throws IOException, ClassNotFoundException {
        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.VRATI_VRSTE_PROIZVODA);

        outSocket.writeObject(kto);


        TransferObjekat sto = (TransferObjekat) inSocket.readObject();
        return sto;
    }

    
    public TransferObjekat vratiProizvode() throws IOException, ClassNotFoundException {
        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.VRATI_PROIZVODE);

        outSocket.writeObject(kto);


        TransferObjekat sto = (TransferObjekat) inSocket.readObject();
        return sto;
    }
    
    
    public TransferObjekat vratiRadnike() throws IOException, ClassNotFoundException {
        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.VRATI_RADNIKE);
        
        outSocket.writeObject(kto);
        
        TransferObjekat sto = (TransferObjekat) inSocket.readObject();
        return sto;
    }
    
    public TransferObjekat sacuvajRacun(Racun racun) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.SACUVAJ_RACUN);
        kto.setPodaci(racun);

        outSocket.writeObject(kto);

        TransferObjekat sto = (TransferObjekat) inSocket.readObject();
        return sto;

    }
    
    public void izmeniRacun(Racun racun) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.IZMENI_RACUN);
        kto.setPodaci(racun);

        posaljiObjekat(kto);

    }
    
    public TransferObjekat stornirajRacun(Racun racun) throws Exception {

        TransferObjekat kto = new TransferObjekat();
        kto.setOperacija(konstante.Konstante.STORNIRAJ);
        kto.setPodaci(racun);
        
        outSocket.writeObject(kto);

        TransferObjekat sto = (TransferObjekat) inSocket.readObject();
        return sto;

    }
    
    public void pronadjiRacun(Racun racun) throws IOException, ClassNotFoundException {
        TransferObjekat kto = new TransferObjekat();
        kto.setPodaci(racun);
        kto.setOperacija(konstante.Konstante.PRONADJI_RACUN);

        outSocket.writeObject(kto);

    }

    public static void main(String[] args) {

        try {
            Sesija.dajObjekat();
            FrmLogin glavna = new FrmLogin();
            glavna.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
