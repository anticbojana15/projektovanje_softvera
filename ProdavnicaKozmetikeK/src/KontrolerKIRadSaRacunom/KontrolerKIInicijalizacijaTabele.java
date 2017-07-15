/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;
import domen.Proizvod;
import domen.Racun;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import sesija.Sesija;
import tableModel.TableStavke;
import transfer.TransferObjekat;


public class KontrolerKIInicijalizacijaTabele {

    public static void inicijalizujTabelu(JTable tabelaStavke) {
        try {
            
            tabelaStavke.setModel(new TableStavke(new Racun()));
            popuniComboBoxProizvod(tabelaStavke);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIInicijalizacijaTabele.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
       

    }

    public static void popuniComboBoxProizvod(JTable tabelaStavke) {
        try {
            TransferObjekat sto = sesija.Sesija.dajObjekat().vratiProizvode();
            JComboBox jcbProizvod = new JComboBox();

            if (sto.isSignal()) {
                List<Proizvod> p = (List<Proizvod>) sto.getPodaci();
                jcbProizvod.setModel(new DefaultComboBoxModel(p.toArray()));
            }

            TableColumnModel tcd = tabelaStavke.getColumnModel();
            TableColumn tc = tcd.getColumn(2);
            tc.setCellEditor(new DefaultCellEditor(jcbProizvod));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   
}
