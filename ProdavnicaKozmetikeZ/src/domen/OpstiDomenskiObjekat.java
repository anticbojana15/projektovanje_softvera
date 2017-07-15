/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author student1
 */
public interface OpstiDomenskiObjekat {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();      

    public String vratiVrednostiZaUpdate();

    public String vratiUslovZaIzmeniSlog();

    public String vratiUslovZaPronadjiSlog();

    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja();

    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs);

    public String vratiNazivTabeleSaJOINom();
    
    public String vratiUslovZaLogovanje();

    public String vratiUslovZaSortiranje();
    
    public String vratiUslovZaStorniranje();
}
