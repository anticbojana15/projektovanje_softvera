/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;




import domen.Radnik;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import transfer.TransferObjekat;


public class KontrolerKIPopuniComboRadnici {
       public static void prikaziRadnike(JComboBox jcbRadnici){
        try{
            TransferObjekat sto=sesija.Sesija.dajObjekat().vratiRadnike();
            if(sto.isSignal()){
                jcbRadnici.removeAllItems();
                List<Radnik> radnici=(List<Radnik>)sto.getPodaci();
                
       
                for(Radnik r : radnici){
                    jcbRadnici.addItem(r);
            }
            
            }
           
            else{
                JOptionPane.showMessageDialog(null, sto.getPoruka());
            }
            
             jcbRadnici.setSelectedItem(sesija.Sesija.dajObjekat().getUlogovaniRadnik());
            jcbRadnici.setEnabled(false);
        } catch (Exception ex) {
          ex.printStackTrace();
        } 
    }
       
       
          
        } 
    

