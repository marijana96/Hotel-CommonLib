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
public class SmestajnaJedinica implements OpstiDomenskiObjekat {

    private String brojSobe;
    private Double cena;
    private String status;
    List<StavkaRacuna> stavkeRacuna;
    String naziv;
    String tip;
    public SmestajnaJedinica() {
    }

    public SmestajnaJedinica(String brojSobe, Double cena, String status, List<StavkaRacuna> stavkeRacuna, String naziv, String tip) {
        this.brojSobe = brojSobe;
        this.cena = cena;
        this.status = status;
        this.stavkeRacuna = stavkeRacuna;
        this.naziv = naziv;
        this.tip = tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

   
  

  
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public String getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(String brojSobe) {
        this.brojSobe = brojSobe;
    }

   

   

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final SmestajnaJedinica other = (SmestajnaJedinica) obj;
        if (!Objects.equals(this.brojSobe, other.brojSobe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv+" "+ brojSobe;
    }

    @Override
    public String vratiKriterijum2() {
      return "tip";  }

    @Override
    public String vratiNazivTabele() {
        return "smestajnajedinica";
    }

    @Override
    public String vratiVrednostiZaInsert() {
           return " '" + brojSobe+ "', '" +naziv + "', '" + cena + "', '" + status + "', '" + tip + "'";
     }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet resultSet) throws Exception {
        try {
            List<OpstiDomenskiObjekat> rooms = new LinkedList<>();
            while (resultSet.next()) {
                SmestajnaJedinica r = new SmestajnaJedinica();
                r.setBrojSobe(resultSet.getString(1));
                r.setNaziv(resultSet.getString(2));
                r.setCena(resultSet.getDouble(3));
                r.setStatus(resultSet.getString(4));
                r.setTip(resultSet.getString(5));
                rooms.add(r);
            }
            return rooms;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String[] vratiID() {
        return new String[]{ "brojSobe"};  }

    @Override
    public ResultSet daLiPostoji(PreparedStatement ps) throws Exception {
         ps.setString(1, brojSobe);
       
        return ps.executeQuery();   }

    @Override
    public String vratiKriterijum() {
        return "brojSobe"; }

    @Override
    public String vratiAtributeZaInsert() {
         return "brojSobe, naziv, cena , status, tip ";
    }

    @Override
    public String vratiAtributeZaUpdate() {
        return "cena = ? , status= ? "; }

    @Override
    public void dodeliVrednosti(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIDUBazi() {
        return "brojSobe";   }

    @Override
    public void dodeliVrednostiZaUpdate(PreparedStatement ps) throws SQLException {
          ps.setString(2, status);
        ps.setDouble(1, cena);
      
         ps.executeUpdate();  }

    @Override
    public PreparedStatement dodeliVrednostiZaUpdate1(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributZaSortiranje() {
        return "brojSobe";  }

}
