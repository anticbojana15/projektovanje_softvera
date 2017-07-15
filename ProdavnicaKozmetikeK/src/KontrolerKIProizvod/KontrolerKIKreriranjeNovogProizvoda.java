/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIProizvod;


import com.toedter.calendar.JDateChooser;
import domen.Proizvod;
import domen.VrstaProizvoda;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import transfer.TransferObjekat;


public class KontrolerKIKreriranjeNovogProizvoda {

    public static void sacuvajNoviProizvod(JTextField jtxtProizvodID, JTextField jtxtNaziv, JTextField jtxtCena, JDateChooser jtxtRokVazenja,  JComboBox jcbVrsteProizvoda) {

        try {
             if (jtxtProizvodID.getText().isEmpty()) {
                throw new Exception("ID proizvoda nije unet!!!");
            }
            if (jtxtNaziv.getText().isEmpty()) {
                throw new Exception("Nije unet naziv proizvoda!!!");
            }
            if (jtxtCena.getText().isEmpty()) {
                throw new Exception("Nije uneta cena proizvoda!!!");
            }
            if (jtxtRokVazenja.getDate()==null) {
                throw new Exception("Nije unet rok važenja proizvoda!!!");
            }
             
            if (jcbVrsteProizvoda.getSelectedIndex() == -1) {
                throw new Exception("Nije izabrana vrsta proizvoda!!!");
            }
        
            int proizvodID = Integer.parseInt(jtxtProizvodID.getText().trim());
            String naziv = jtxtNaziv.getText().trim();
            Double cena = Double.parseDouble(jtxtCena.getText().trim());
            Date rokVazenja = jtxtRokVazenja.getDate();
            VrstaProizvoda vrstaProizvoda = (VrstaProizvoda) jcbVrsteProizvoda.getSelectedItem();

            Proizvod p = new Proizvod(proizvodID, naziv, cena, rokVazenja, vrstaProizvoda);

            TransferObjekat sto = sesija.Sesija.dajObjekat().sacuvajProizvod(p);
            
            if (sto.getIzuzetak()!=null) {
              throw  sto.getIzuzetak();
            }
                JOptionPane.showMessageDialog(null,sto.getPoruka(),"PORUKA",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"GREŠKA",JOptionPane.ERROR_MESSAGE);
        }
        jtxtProizvodID.setText("");
        jtxtNaziv.setText("");
        jtxtCena.setText("");
        jtxtRokVazenja.setDate(null);
    }
}
