/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Dragan
 */
public class TransferObjekat implements Serializable {

    private boolean signal;
    private int operacija;
    private Object poruka;
    private Object podaci;
    private Exception izuzetak;

    public boolean isSignal() {
        return signal;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getPoruka() {
        return poruka;
    }

    public void setPoruka(Object poruka) {
        this.poruka = poruka;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public Exception getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Exception izuzetak) {
        this.izuzetak = izuzetak;
    }
    
    
}
