/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIProizvod;


import domen.VrstaProizvoda;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import transfer.TransferObjekat;


public class KontrolerKIPopuniVrsteProizvoda {
       public static void prikaziVrsteProizvoda(JComboBox jcbVrsteProizvoda){
        try{
            TransferObjekat sto=sesija.Sesija.dajObjekat().vratiVrsteProizvoda();
            if(sto.isSignal()){
                jcbVrsteProizvoda.removeAllItems();
                List<VrstaProizvoda> vp=(List<VrstaProizvoda>)sto.getPodaci();
                
       
                for(VrstaProizvoda v : vp){
                    jcbVrsteProizvoda.addItem(v);
            }}else{
                JOptionPane.showMessageDialog(null, sto.getPoruka());
            }
        } catch (Exception ex) {
          ex.printStackTrace();
        } 
    }
}
