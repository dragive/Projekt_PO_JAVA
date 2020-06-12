package Umowy;

import Data.Data;

/**
 * Klasa abstrakcyjma {@link Umowa}
 * Dziedziczą z niej klasy: {@link UmowaODzielo}, {@link UmowaOPrace}.
 * @author MF
 */
public abstract class Umowa {
    /**
     * Data zawarcia danej umowy
     */

    protected Data dataZawarcia;

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
}
