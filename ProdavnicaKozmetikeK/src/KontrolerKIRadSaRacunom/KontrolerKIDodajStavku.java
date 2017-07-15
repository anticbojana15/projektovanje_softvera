/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontrolerKIRadSaRacunom;

import domen.Racun;
import javax.swing.JTable;
import tableModel.TableStavke;


public class KontrolerKIDodajStavku {
    public static void dodajStavku(JTable tabelaStavke) throws Exception{
        ((TableStavke)tabelaStavke.getModel()).dodajStavku();
    } 
}
