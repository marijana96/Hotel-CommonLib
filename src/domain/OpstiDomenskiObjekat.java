/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author marij
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;

    public String[] vratiID();

    public ResultSet daLiPostoji(PreparedStatement st) throws Exception;

    public String vratiKriterijum();

    public String vratiAtributeZaInsert();

    public String vratiAtributeZaUpdate();

    public void dodeliVrednosti(PreparedStatement st) throws SQLException;
    
    public String vratiIDUBazi();

    public void dodeliVrednostiZaUpdate(PreparedStatement st) throws SQLException;

    public String vratiKriterijum2();
public PreparedStatement dodeliVrednostiZaUpdate1(PreparedStatement st) throws SQLException;

    public String vratiAtributZaSortiranje();

   
    
}
