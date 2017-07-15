/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIProizvod;


import com.toedter.calendar.JDateChooser;
import domen.Proizvod;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import transfer.TransferObjekat;


public class KontrolerKIPronadjProizvod {

    public static void pronadjiProizvod(JTextField jtxtProizvodID, JTextField jtxtNaziv, JTextField jtxtCena, JDateChooser jtxtRokVazenja,  JComboBox jcbVrsteProizvoda) {

        try {
            if (jtxtProizvodID.getText().isEmpty()) {
                throw new Exception("ID proizvoda nije unet!!!");
            }

            Proizvod p = new Proizvod();
            p.setProizvodID(Integer.parseInt(jtxtProizvodID.getText()));

            sesija.Sesija.dajObjekat().pronadjiProizvod(p);


            TransferObjekat sto = sesija.Sesija.dajObjekat().procitajObjekat();

            Proizvod pronadjeniProizvod = (Proizvod) sto.getPodaci();
            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
            jtxtNaziv.setText(pronadjeniProizvod.getNaziv());
            jtxtCena.setText(Double.toString(pronadjeniProizvod.getCena()));
            Date rokVazenja = pronadjeniProizvod.getRokVazenja();
            jtxtRokVazenja.setDate(rokVazenja);
            jcbVrsteProizvoda.setSelectedItem(pronadjeniProizvod.getVrstaProizvoda());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }
}
