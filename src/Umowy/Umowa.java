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
    /**
     * Pole zawierające informacje czy dana umowa jest jeszcze nie rozwiązana i aktywna
     */
    protected boolean czyAktywna;
    /**
     * Pole zawiera inforamcje czy została już ta umowa zakończona manualnie
     */
    protected boolean zakonczonaManualnie;

    /**
     * Metoda klasy {@link Umowa}
     * @param dataZawarcia Zwraca date zawarcia umowy
     */

    public Umowa(Data dataZawarcia){
        zakonczonaManualnie=false;
        this.dataZawarcia=dataZawarcia;

    }

    /**
     * Metoda aktualizująca informacje czy umowa jest jeszcze aktualna czy juz zakonczona
     * @param data data dnia dla której ma nastąpić aktualizacja
     */
    public void aktualizacnaAktywnosciUmowy(Data data){
        if(dataZawarcia.wczesniejsza(data)==1){
            czyAktywna =true;
        }
    }

    /**
     * @return Zwraca informacje czy jest umowa dalej aktywna
     */
    public boolean getCzyAktywna(){
        return this.czyAktywna;}

    /**
     * Aktualizacja danych dla umowy, pod kątem kolejnego dnia i sprawdzenie czy nie jest rozwiązana
     * @param data data kolejnego dnia
     */
    public void kolejnyDzien(Data data){
        this.aktualizacnaAktywnosciUmowy(data);
    }

    /**
     * Metoda służąca do rozwiązania umowy z danym autorem.
     */
    public void zakonczManualnie(){
        this.zakonczonaManualnie=true;
    }

    /**
     * Metoda sprawdza czy umowa została zakończona manualnie.
     * @return Zwraca informacje czy umowa została zakończona manualnie.
     */
    public boolean getZakonczonaManualnie(){ return  this.zakonczonaManualnie;}
}
