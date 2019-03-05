/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

import java.io.Serializable;

/**
 *
 * @author marij
 */
public interface Operacija {
    public static final int OPERATION_LOGIN=1;
 public static final int UCITAJ_SVE_DRZAVE=2;
 public static final int PRETRAZI_GOSTE=3;
  public static final int PRETRAZI_GOSTEJMBG=4;
  public static final int UCITAJ_SVE_GOSTE=5;
   public static final int SACUVAJ_NOVOG_GOSTA=6;
  public static final int SACUVAJ_IZMENE_GOSTA=7;
    public static final int IZBRISI_GOSTA=8;
     public static final int SACUVAJ_NOVU_SJEDINICU=9;
     public static final int UCITAJ_SVE_SJEDINICE=10;
      public static final int PRETRAZI_SJEDINICEBROJ=11;
       public static final int PRETRAZI_SJEDINICETIP=12;
       public static final int SACUVAJ_RACUN=13;
}
