/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class Odgovor implements Serializable{
    private Object data;
    private Object error;
   String poruka;
    private StatusOdgovora status;
    public Odgovor() {
    }

    public Odgovor(Object data, Object error, StatusOdgovora status) {
        this.data = data;
        this.error = error;
        this.status = status;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
   
    
}
