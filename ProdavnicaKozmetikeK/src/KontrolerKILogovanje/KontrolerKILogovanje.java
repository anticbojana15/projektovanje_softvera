/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKILogovanje;

import domen.Radnik;
import forme.FrmGlavna;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sesija.Sesija;
import transfer.TransferObjekat;


public class KontrolerKILogovanje {

    public static void ulogujSe(JTextField jtxtUser, JTextField jtxtPass) {
        try {
            if (jtxtUser.getText().isEmpty()) {
                throw new Exception("Nije unet username!");
            }

            if (jtxtPass.getText().isEmpty()) {
                throw new Exception("Nije unet password!");
            }


            String user = jtxtUser.getText().trim();
            String pass = jtxtPass.getText().trim();
            Radnik r = new Radnik();
            r.setKorisnickoIme(user);
            r.setLozinka(pass);

            sesija.Sesija.dajObjekat().prijaviSe(r);

            TransferObjekat sto = sesija.Sesija.dajObjekat().procitajObjekat();

            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
          
            Radnik rd = (Radnik) sto.getPodaci();
            String ulogovan = (String) rd.getImePrezime();
              JOptionPane.showMessageDialog(null, sto.getPoruka(), ulogovan, JOptionPane.INFORMATION_MESSAGE);
            Sesija.dajObjekat().setUlogovaniRadnik(rd);
            FrmGlavna form = new FrmGlavna(rd);
            form.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GREŠKA!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
