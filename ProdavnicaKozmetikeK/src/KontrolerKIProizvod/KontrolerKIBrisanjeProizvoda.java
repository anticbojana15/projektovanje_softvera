/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIProizvod;

import com.toedter.calendar.JDateChooser;
import domen.Proizvod;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sesija.Sesija;

import transfer.TransferObjekat;

public class KontrolerKIBrisanjeProizvoda {

    public static void obrisiProizvod(JTextField jtxtProizvodID, JTextField jtxtNaziv, JTextField jtxtCena, JDateChooser jtxtRokVazenja, JComboBox jcbVrsteProizvoda) {
        try {
            if (jtxtProizvodID.getText().isEmpty()) {
                throw new Exception("ID proizvoda nije unet!!!");
            }

            Proizvod p = new Proizvod();
            p.setProizvodID(Integer.parseInt(jtxtProizvodID.getText()));

            Sesija.dajObjekat().obrisiProizvod(p);

            TransferObjekat sto = Sesija.dajObjekat().procitajObjekat();

            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
            JOptionPane.showMessageDialog(null, sto.getPoruka(), "PORUKA", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE);
        }
        jtxtProizvodID.setText("");
        jtxtNaziv.setText("");
        jtxtCena.setText("");
        jtxtRokVazenja.setDate(null);
    }
}
