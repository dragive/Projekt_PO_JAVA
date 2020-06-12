package Umowy;

import Data.Data;

import java.io.Serializable;

/**
 * Klasa abstrakcyjma {@link Umowa}
 * Dziedziczą z niej klasy: {@link UmowaODzielo}, {@link UmowaOPrace}.
 * @author MF
 */
public abstract class Umowa implements Serializable {
    /**
     * Data zawarcia danej umowy
     */

    protected Data dataZawarcia;
    protected boolean czyAktywna;
    /**
     * Publiczna metoda klasy abstrakcyjnej {@link Umowa}
     * @return Zwraca datę zawarcia umowy.
     */

    public Data getDataZawarcia() {
        return this.dataZawarcia;
    }

    /**
     * Metoda klasy {@link Umowa}
     * @param dataZawarcia Zwraca date zawarcia umowy
     */

    public Umowa(Data dataZawarcia){

        this.dataZawarcia=dataZawarcia;

    }
    public void aktualizacnaAktywnosciUmowy(Data data){
        if(dataZawarcia.wczesniejsza(data)==1){
            czyAktywna =true;
        }
    }
    public boolean getCzyAktywna(){
        return this.czyAktywna;}
    public void kolejnyDzien(Data data){
        this.aktualizacnaAktywnosciUmowy(data);
    }
}
