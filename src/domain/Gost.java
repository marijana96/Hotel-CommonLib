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
public class Gost implements OpstiDomenskiObjekat {

    private Integer gostID;
    private String jmbg;
    private String imePrezime;

    private String kontakt;

    private Drzava drzava;

    public Gost() {
    }

    public Gost(Integer gostID) {
        this.gostID = gostID;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    public Gost(Integer gostID, String jmbg, String imePrezime, String kontakt, Drzava drzava) {
        this.gostID = gostID;
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
        this.kontakt = kontakt;
        this.drzava = drzava;
    }

    public Integer getGostID() {
        return gostID;
    }

    public void setGostID(Integer gostID) {
        this.gostID = gostID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gostID != null ? gostID.hashCode() : 0);
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
        final Gost other = (Gost) obj;
        if (!Objects.equals(this.gostID, other.gostID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "gost";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " '" + jmbg + "', '" + imePrezime + "', '" + drzava.getPozivniBroj() + "', '" + kontakt + "', '" + drzava.getNaziv()+ "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet resultSet) throws Exception {
        try {
            List<OpstiDomenskiObjekat> guests = new LinkedList<>();
            while (resultSet.next()) {
                Gost g = new Gost();
                g.setGostID(resultSet.getInt(1));
                g.setJmbg(resultSet.getString(2));
                g.setImePrezime(resultSet.getString(3));
                g.setKontakt(resultSet.getString(5));
           //     g.getDrzava.((Drzava) resultSet.getObject(5));
           Drzava d= new Drzava();
           d.setPozivniBroj(resultSet.getInt(4));
           d.setNaziv(resultSet.getString(6));
//                g.getDrzava().setPozivniBroj(resultSet.getInt(5));
//                g.getDrzava().setNaziv("");
g.setDrzava(d);
                guests.add(g);

            }
            return guests;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String[] vratiID() {
        return new String[]{"jmbg", "imePrezime"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement ps) throws Exception {
        ps.setString(1, jmbg);;
        ps.setString(2, imePrezime);
        return ps.executeQuery();

    }

    @Override
    public String vratiKriterijum() {
        return "imePrezime";
    }

    @Override
    public String vratiKriterijum2() {
      return "jmbg"; }

    @Override
    public String vratiAtributeZaInsert() {
        return "jmbg, imePrezime, pozivniBroj, kontakt, drzava";
    }

    @Override
    public String vratiAtributeZaUpdate() {
        return "imePrezime = ? , pozivniBroj = ?, kontakt = ? , drzava = ?";
    }

    @Override
    public void dodeliVrednosti(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIDUBazi() {
        return "gostId";
    }

    @Override
    public void dodeliVrednostiZaUpdate(PreparedStatement ps) throws SQLException {
      //  ps.setInt(1, gostID);
        ps.setString(2, jmbg);
        ps.setString(1, imePrezime);
        ps.setInt(2, drzava.getPozivniBroj());
        ps.setString(3, kontakt );
        ps.setString(4, drzava.getNaziv());
         ps.setInt(5, gostID);
         ps.executeUpdate();
    }
    
//      st.setString(2, imeprezime);
//        st.setString(1, jmbg);
//        st.setString(3, adresa);
//        st.setString(4, kontaktTelefon);
//        st.setInt(5, putnikID);
//    }
    @Override
   public PreparedStatement dodeliVrednostiZaUpdate1(PreparedStatement ps) throws SQLException{
        ps.setInt(1, gostID);
        ps.setString(2, jmbg);
        ps.setString(3, imePrezime);
        ps.setInt(4, drzava.getPozivniBroj());
        ps.setString(5, kontakt );
        ps.setString(6, drzava.getNaziv());
        return ps;
   }

    @Override
    public String vratiAtributZaSortiranje() {
     return "imePrezime";  }
    

}
