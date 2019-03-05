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
public class Hotel implements OpstiDomenskiObjekat {

    private Integer hotelId;
    private String naziv;
    private Integer kapacitet;

    public Hotel(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel() {
    }

    public Hotel(Integer hotelId, String naziv, Integer kapacitet) {
        this.hotelId = hotelId;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += (hotelId != null ? hotelId.hashCode() : 0);
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
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.hotelId, other.hotelId)) {
            return false;
        }
        return true;
    }

   

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "'" + naziv + "'";
    }

    @Override
    public String vratiNazivTabele() {
        return "Hotel";
    }

    @Override
    public String vratiKriterijum2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + naziv + "', " + kapacitet;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet resultSet) throws Exception {
        try {
            List<OpstiDomenskiObjekat> hotels = new LinkedList<>();
            while (resultSet.next()) {
                Hotel h = new Hotel();
                h.setHotelId(resultSet.getInt(1));
                h.setNaziv(resultSet.getString(2));
                h.setKapacitet(resultSet.getInt(3));
                hotels.add(h);
            }
            return hotels;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String[] vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKriterijum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "naziv, kapacitet";
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
