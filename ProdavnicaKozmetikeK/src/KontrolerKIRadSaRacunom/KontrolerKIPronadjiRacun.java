/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;


import com.toedter.calendar.JDateChooser;
import domen.Racun;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModel.TableStavke;
import transfer.TransferObjekat;


public class KontrolerKIPronadjiRacun {
         public static void pronadjiRacun(JTextField jtxtRacunID, JDateChooser jtxtDatum, JComboBox jcbRadnik, JTable tabelaStavke,JTextField jtxtiznos, JRadioButton jbtnDA,JRadioButton jbtnNE){
        try {
            if (jtxtRacunID.getText().isEmpty()) {
                throw new Exception("ID računa nije unet!!!");
            }                       
                       
            Racun r = new Racun();
            r.setRacunID(Integer.parseInt(jtxtRacunID.getText()));

           sesija.Sesija.dajObjekat().pronadjiRacun(r);
           
           TransferObjekat sto = sesija.Sesija.dajObjekat().procitajObjekat();
         
            Racun pronadjeniRacun = (Racun) sto.getPodaci();
            if (sto.getIzuzetak()!=null) {
             throw sto.getIzuzetak();
            }
           pronadjeniRacun.izracunajUkupno();
            jtxtDatum.setDate(pronadjeniRacun.getDatum());
                jcbRadnik.setSelectedItem(pronadjeniRacun.getRadnik());
                jtxtiznos.setText(Double.toString(pronadjeniRacun.getIznos()));
                
                if(pronadjeniRacun.isStorinira()==true){
                    jbtnDA.setSelected(true);
                 
                    
                }
                 else {  
                    jbtnNE.setSelected(true);
                 
                }
                ((TableStavke)tabelaStavke.getModel()).postaviRacun(pronadjeniRacun);
                
            }
        
        catch (Exception ex) {  
JOptionPane.showMessageDialog(null,ex.getMessage(), "GREŠKA!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       
    
    }  
}
