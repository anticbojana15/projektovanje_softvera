/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import domen.VrstaProizvoda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class TableStavke extends AbstractTableModel {

   Racun racun;
    String[] columnNames = new String[]{"Rb ", "Količina ", "Proizvod"};
    SimpleDateFormat sdf;

    public TableStavke(Racun racun) {
        this.racun = racun;
        sdf = new SimpleDateFormat("dd.MM.yyyy");
    }

   

    @Override
    public int getRowCount() {
        return racun.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        StavkaRacuna sr = racun.getListaStavki().get(rowIndex);
     
        switch (columnIndex) {
            case 0:
                return sr.getRb();
               
            case 1:
                return sr.getKolicina();
                
            case 2:
                return sr.getProizvod();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        StavkaRacuna st = racun.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                st.setRb(Integer.parseInt(String.valueOf(value)));
               racun.izracunajUkupno();
                break;
            case 1:
                st.setKolicina(Integer.parseInt(String.valueOf(value)));
                racun.izracunajUkupno();
                break;           
            case 2:
                st.setProizvod((Proizvod) value);
                 racun.izracunajUkupno();
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    public void dodajStavku() throws Exception {
        racun.dodajStavku();
        fireTableDataChanged();
    }

    public void obrisiStavku(int red) {

        racun.obrisiStavku(red);
        fireTableRowsDeleted(red, red);
    }

    public Racun vratiRacun() {       
        
        return racun;
    }
    
    public void postaviRacun(Racun r){
        racun = r;
        fireTableDataChanged();
    }
}
