/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author marij
 */
public class Drzava implements OpstiDomenskiObjekat {

    private Integer pozivniBroj;
    private String naziv;

    public Drzava(Integer pozivniBroj, String naziv) {
        this.pozivniBroj = pozivniBroj;
        this.naziv = naziv;
    }

    public Drzava() {
    }

    public Drzava(Integer pozivniBroj) {
        this.pozivniBroj = this.pozivniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drzava other = (Drzava) obj;
        if (!Objects.equals(this.pozivniBroj, other.pozivniBroj)) {
            return false;
        }
        return true;
    }

    public String getNaziv() {
        return naziv;
    }

    public Integer getPozivniBroj() {
        return pozivniBroj;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPozivniBroj(Integer pozivniBroj) {
        this.pozivniBroj = pozivniBroj;
    }

    @Override
    public String toString() {
        return pozivniBroj + ", " + naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "drzava";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return pozivniBroj + ", '" + naziv;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> drzave = new LinkedList<>();
            while (rs.next()) {
                Drzava s = new Drzava();
                s.setPozivniBroj(rs.getInt(1));
                s.setNaziv(rs.getString(2));
                drzave.add(s);
            }
            return drzave;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String[] vratiID() {
      return new String[]{"pozivniBroj"} ;}

    @Override
    public ResultSet daLiPostoji(PreparedStatement ps) throws Exception {
        ps.setInt(1, pozivniBroj);
        ps.setString(2, naziv);
        return ps.executeQuery();
    }

    @Override
    public String vratiKriterijum() {
        return "naziv";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "pozivniBroj, naziv";
    }

    @Override
    public String vratiAtributeZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dodeliVrednosti(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIDUBazi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dodeliVrednostiZaUpdate(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKriterijum2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement dodeliVrednostiZaUpdate1(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributZaSortiranje() {
     return "naziv"; }
    

}
