package Publikacje;

import Data.DzienMiesiaca;
import Konsola.Konsola;
import java.util.Objects;

/**
 * Klasa finalna {@link Miesiecznik} dziedziczy z klasy abstrakcyjnej {@link PublikacjaCykliczna}
 * @author MF
 */
public final class Miesiecznik extends PublikacjaCykliczna{
    /**
     * Prywatne pole klasy {@link Miesiecznik}
     * Przechowuje informacje o dniu miesiąca
     */

    private DzienMiesiaca dzienMiesiaca;

    /**
     * Konstruktor klasy {@link Miesiecznik}
     * @param tytul Tytuł danej publikacji
     * @param dzienMiesiaca Dzień miesiąca cyklicznego wydawania publikacji
     */
    public Miesiecznik(String tytul, DzienMiesiaca dzienMiesiaca,String imieNazwiskoAutora)
    {
        super(tytul,imieNazwiskoAutora);
        //dzienMiesiaca.sprawdzPoprawnoscDniaMiesiaca();
        this.dzienMiesiaca=dzienMiesiaca;
    }
    @Override
    public String toString() {
        return "Kategoria: Miesiecznik     Autor: "+ Konsola.stalaSzerokosc(imieNazwiskoAutora,20)+
                " Tytuł: "+ Konsola.stalaSzerokosc(getTytul(),20)+
                " Dzien wydania: "+Konsola.stalaSzerokosc(dzienMiesiaca.toString(),15);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Miesiecznik that = (Miesiecznik) o;
        return dzienMiesiaca.equals(that.dzienMiesiaca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dzienMiesiaca);
    }
}
