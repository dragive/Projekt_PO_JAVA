package Publikacje;

import Data.DzienTygodnia;
import Konsola.Konsola;
import java.util.Objects;

/**
 * Klasa finalna {@link Tygodnik} dziedziczy z klasy abstrakcyjnej {@link PublikacjaCykliczna}.
 * @author MF
 */
public final class Tygodnik extends PublikacjaCykliczna{
    /**
     * Prywatne pole klasy {@link Tygodnik}
     * Przechowuje informacje o dniu tygodnia
     */
    private DzienTygodnia dzienTygodnia;
    /**
     * Konstruktor klasy {@link Tygodnik}
     * @param tytul Tytuł danej publikacji
     * @param dzienTygodnia Dzień Tygodnia cyklicznego wydawania publikacji
    */
    public Tygodnik(String tytul,DzienTygodnia dzienTygodnia,String imieNazwiskoAutora) {
        super(tytul,imieNazwiskoAutora);

        this.dzienTygodnia=dzienTygodnia;
    }

    /**
     * @return Zwraca informacje o publikacji w postaci ciągu znaków, gotowych do wypisania
     */
    @Override
    public String toString() {
        return "Kategoria: Tygodnik        Autor: " + Konsola.stalaSzerokosc(imieNazwiskoAutora, 20) +
                " Tytuł: " + Konsola.stalaSzerokosc(getTytul(), 20) +
                " Dzien wydania: " + Konsola.stalaSzerokosc(dzienTygodnia.toString(), 15);
    }
    /**
     * Metoda do porównania 2 obiektów czy sa takie same
     * @param o Obiekt do porównań
     * @return zwraca wartość logiczna czy są takie same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tygodnik tygodnik = (Tygodnik) o;
        return dzienTygodnia.equals(tygodnik.dzienTygodnia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dzienTygodnia);
    }
}
