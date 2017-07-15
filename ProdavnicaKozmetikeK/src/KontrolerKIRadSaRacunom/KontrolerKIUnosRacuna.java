/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;



import com.toedter.calendar.JDateChooser;
import domen.Racun;
import domen.Radnik;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModel.TableStavke;
import transfer.TransferObjekat;


public class KontrolerKIUnosRacuna {
  public static void sacuvajRacun(JTextField jtxtRacunID, JDateChooser jtxtDatum, JComboBox jcbRadnik, JTable tabelaStavke, JRadioButton jbtnDA,JRadioButton jbtnNE){
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
            
            if(jbtnNE.isSelected()){
            Racun racun = ((TableStavke) tabelaStavke.getModel()).vratiRacun();
            racun.setRacunID(Integer.parseInt(jtxtRacunID.getText()));           
            Date datum= jtxtDatum.getDate();
            racun.setDatum(datum);
            Radnik radnik=(Radnik)jcbRadnik.getSelectedItem();
            racun.setRadnik(radnik);
            racun.setStorinira(false);

            TransferObjekat sto = sesija.Sesija.dajObjekat().sacuvajRacun(racun);
            if (sto.getIzuzetak()!=null) {
             throw sto.getIzuzetak();
            }
           JOptionPane.showMessageDialog(null, "Račun je uspešno sačuvan!", "PORUKA!", JOptionPane.INFORMATION_MESSAGE);
            }
  else{
    
     Racun racun = ((TableStavke) tabelaStavke.getModel()).vratiRacun();
            racun.setRacunID(Integer.parseInt(jtxtRacunID.getText()));           
            Date datum= jtxtDatum.getDate();
            racun.setDatum(datum);
            Radnik radnik=(Radnik)jcbRadnik.getSelectedItem();
            racun.setRadnik(radnik);
            racun.setStorinira(true);

            TransferObjekat sto = sesija.Sesija.dajObjekat().sacuvajRacun(racun);
            if (sto.getIzuzetak()!=null) {
             throw sto.getIzuzetak();
            }
           JOptionPane.showMessageDialog(null, "Račun je uspešno sačuvan!", "PORUKA!", JOptionPane.INFORMATION_MESSAGE);
     
}}catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(),"GREŠKA",JOptionPane.ERROR_MESSAGE);
        }
}
}