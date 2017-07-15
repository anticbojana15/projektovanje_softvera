/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;

import domen.Racun;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModel.TableStavke;
import transfer.TransferObjekat;


public class KontrolerKIStornirajRacun {
    public static void stornirajRacun(JTextField jtxtRacunID, JRadioButton jrbDA){
        try {
            if (jtxtRacunID.getText().isEmpty()) {
                throw new Exception("ID računa nije unet!!!");
            }                        
            
             if(jrbDA.isSelected()){
            Racun racun = new Racun();
            racun.setRacunID(Integer.parseInt(jtxtRacunID.getText()));
            racun.setStorinira(true);
             TransferObjekat sto = sesija.Sesija.dajObjekat().stornirajRacun(racun);
            boolean signal = sto.isSignal();
            if (signal) {
                JOptionPane.showMessageDialog(null, sto.getPoruka());
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka());
            }
             }else{
             }

           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    
    }  
}
