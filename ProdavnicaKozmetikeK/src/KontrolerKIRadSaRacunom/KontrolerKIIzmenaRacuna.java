/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;

import com.toedter.calendar.JDateChooser;
import domen.Racun;
import domen.Radnik;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import sesija.Sesija;
import tableModel.TableStavke;
import transfer.TransferObjekat;

public class KontrolerKIIzmenaRacuna {
     public static void sacuvajIzmenuRacuna(JTextField jtxtRacunID, JDateChooser jtxtDatum, JComboBox jcbRadnik, JTable tabelaStavke){
        try {
              if (jtxtRacunID.getText().isEmpty()) {
                throw new Exception("ID računa nije unet!!!");
            }                        
            if (jtxtDatum.getDate()==null) {
                throw new Exception("Nije unet datum!!!");
            }
            if (jcbRadnik.getSelectedIndex() == -1) {
                throw new Exception("Nije prijavljen radnik koji unosi račun!!!");
            }
            Racun racun = ((TableStavke) tabelaStavke.getModel()).vratiRacun();
            racun.setRacunID(Integer.parseInt(jtxtRacunID.getText()));            
            racun.setDatum(jtxtDatum.getDate());
            Radnik radnik=(Radnik)jcbRadnik.getSelectedItem();
            racun.setRadnik(radnik);

           Sesija.dajObjekat().izmeniRacun(racun);
            
            TransferObjekat sto = Sesija.dajObjekat().procitajObjekat();
            if (sto.getIzuzetak()==null) {
                JOptionPane.showMessageDialog(null, sto.getPoruka(), "PORUKA", JOptionPane.INFORMATION_MESSAGE);  
            } else {
               JOptionPane.showMessageDialog(null, sto.getIzuzetak(), "GREŠKA", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
      
    
    }  
}
