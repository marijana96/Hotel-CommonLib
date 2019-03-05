/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author marij
 */
public class StavkaRacuna implements OpstiDomenskiObjekat {

    private Integer brojRacuna;
    private SmestajnaJedinica smestajnaJedinica;
    private Date dolazak;
    private Date odlazak;
    private Racun racun;
    private Double suma;

    public StavkaRacuna(Integer brRac, Racun racun) {
        this.brojRacuna = brRac;
        this.racun = racun;
    }

    public StavkaRacuna(Integer brojRacuna, SmestajnaJedinica smestajnaJedinica, Date dolazak, Date odlazak, Racun racun, Double suma) {
        this.brojRacuna = brojRacuna;
        this.smestajnaJedinica = smestajnaJedinica;
        this.dolazak = dolazak;
        this.odlazak = odlazak;
        this.racun = racun;
        this.suma = suma;
    }

    public StavkaRacuna() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.brojRacuna);
        hash = 43 * hash + Objects.hashCode(this.racun);
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (!Objects.equals(this.brojRacuna, other.brojRacuna)) {
            return false;
        }
        if (!Objects.equals(this.racun, other.racun)) {
            return false;
        }
        return true;
    }

    public Integer getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Integer brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public SmestajnaJedinica getSmestajnaJedinica() {
        return smestajnaJedinica;
    }

    public void setSmestajnaJedinica(SmestajnaJedinica smestajnaJedinica) {
        this.smestajnaJedinica = smestajnaJedinica;
    }

    public Date getDolazak() {
        return dolazak;
    }

    public void setDolazak(Date dolazak) {
        this.dolazak = dolazak;
    }

    public Date getOdlazak() {
        return odlazak;
    }

    public void setOdlazak(Date odlazak) {
        this.odlazak = odlazak;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Stavka racuna [ br.Stavke =" + brojRacuna + " ]";
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return brojRacuna + ", '" + racun.getRacunId() + "', " + smestajnaJedinica.getBrojSobe() + ", '" +new java.sql.Date(dolazak.getTime())+ "', '" + new java.sql.Date(odlazak.getTime()) + "', " + suma;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKriterijum2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] vratiID() {
        return new String[]{"brojRacuna", "racunId"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement ps) throws Exception {
        ps.setInt(1, brojRacuna);
        ps.setString(2, racun.getRacunId());
        return ps.executeQuery();
    }

    @Override
    public String vratiKriterijum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeZaInsert() {
        return null;
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
    public PreparedStatement dodeliVrednostiZaUpdate1(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
