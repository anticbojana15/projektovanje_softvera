/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;

import javax.swing.JTable;
import tableModel.TableStavke;

/**
 *
 * @author Dragan
 */
public class KontrolerKIObrisiStavku {

    public static void obrisiStavku(JTable tabelaStavke) {
        int st = tabelaStavke.getSelectedRow();
        TableStavke ts = (TableStavke) tabelaStavke.getModel();
        ts.obrisiStavku(st);
    }
}
