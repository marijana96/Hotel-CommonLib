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
public class Racun implements OpstiDomenskiObjekat{
    private String racunId;
  
    private Date datum;
    private Integer ziroRacun;
    private Gost gost;
    private List<StavkaRacuna> stavkeRacuna;
    private Hotel hotel;

    public Racun() {
    }

    public Racun(String racunId,Date datum, Integer ziroRacun, Gost gost, List<StavkaRacuna> stavkeRacuna, Hotel hotel) {
        this.racunId = racunId;
      
        this.datum = datum;
        this.ziroRacun = ziroRacun;
        this.gost = gost;
        this.stavkeRacuna = stavkeRacuna;
        this.hotel = hotel;
    }

  

   
    public Racun(String racunId){
        this.racunId=racunId;
    }
    public Racun(String racunId,Date datum){
        this.racunId=racunId;
        this.datum=datum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash +=(racunId !=null ? racunId.hashCode() :0);
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
        final Racun other = (Racun) obj;
        if (!Objects.equals(this.racunId, other.racunId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Racun: [" +racunId+"]";    }

    public String getRacunId() {
        return racunId;
    }

    public void setRacunId(String racunId) {
        this.racunId = racunId;
    }
    
   
   

   

    public Date getDatum() {
        return datum;
    }

    @Override
    public String vratiKriterijum2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(Integer ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public PreparedStatement dodeliVrednostiZaUpdate1(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   


////    @Override
////    public String insertIntoValues() {
////        return null;
////        /*
//     return "'"+invoiceId+"', "+guest.getGuestID()+ "'"+hotel.getHotelId()+"', "+  }
//*/
//    }

  




    @Override
    public String vratiNazivTabele() {
      return "racun"; }
    @Override
    public String vratiVrednostiZaInsert() {
      //  SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
       // String dat= sdf.format(datum);
       return " '" + racunId + "', '" +new java.sql.Date(datum.getTime())+ "', '" + ziroRacun + "', '" +hotel.getHotelId()+ "', '" + gost.getGostID() + "'" ;
   }
   

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] vratiID() {
       return new String [] {"racunId"}; }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
       st.setString(1, racunId);
    return st.executeQuery();}

    @Override
    public String vratiKriterijum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeZaInsert() {
       return null; }

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
    public String vratiAtributZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
