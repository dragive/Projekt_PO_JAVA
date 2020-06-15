package Umowy;


import Konsola.Konsola;

import ZleceniePublikacji.ZleceniePublikacji;

import java.util.ArrayList;
import java.util.List;
import Data.Data;
/**
 * Klasa dziedzicząca z klasy abstrakcyjnej {@link Umowa}
 * Klasa reprezentuje umowy o prace.
 * @author MF
 */
public class UmowaOPrace  extends  Umowa{
    /**
     * Data końca umowy
     */

    private Data dataKonca;
    /**
     * Zmienna określająca czy dana umowa jest już rozwiązana, czy nie
     */

    /**
     * Lista zleceń zawartych w umowie
     */
    private List<ZleceniePublikacji> zlecenia;

    /**
     * Konstruktor publiczny klasy {@link UmowaOPrace}
     * @param dataZawarcia Data zawarcia umowy.
     * @param dataKonca Data zakończenia umowy.
     */
    public UmowaOPrace(Data dataZawarcia, Data dataKonca){
        super(dataZawarcia);
        this.dataKonca=dataKonca;
        this.czyAktywna=false;
        zlecenia = new ArrayList<ZleceniePublikacji>();
    }

    /**
     * Sprawdzenie czy umowa jest aktualna i aktualizacja danych z tym zwiazanymi
     * @param data data dnia dla której ma nastąpić aktualizacja
     */
    @Override
    public void aktualizacnaAktywnosciUmowy(Data data){
        if(dataZawarcia.wczesniejsza(data)==1&&data.wczesniejsza(dataKonca)==1)
            czyAktywna=true;
        else czyAktywna=false;
    }

    /**
     * Działania związane z nastapieniem kolejnego dnia
     * @param data data kolejnego dnia
     */
    @Override
    public void kolejnyDzien(Data data){
        this.aktualizacnaAktywnosciUmowy(data);
    }

    /**
     * @return Zwrócenie informacji o umowie gotowych do wypisania.
     */
    @Override
    public String toString() {

        return "Kategoria: \"O Prace\"                 "+ Konsola.stalaSzerokosc( "",20)+
                "   Data Zawarcia: " + dataZawarcia+
                "   : " + dataZawarcia+
                "   Zaplata:        "+
                "   Data Zakonczenia: " + dataKonca;
    }

}
