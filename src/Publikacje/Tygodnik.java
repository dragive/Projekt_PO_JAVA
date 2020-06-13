package Publikacje;

import Data.DzienTygodnia;
import Data.DzienTygodniaExceptions.ZaDuzyDzienTygodniaException;
import Data.DzienTygodniaExceptions.ZaMalyDzienTygodniaException;
import Konsola.Konsola;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

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
     * @throws ZaKrotkiTytulException Wyjątek podnoszony, gdy tytuł jest za krótki
     * @throws ZaDuzyDzienTygodniaException wyjątek podnoszony, gdy jest podany dzień tygodnia jest za duży
     * @throws ZaMalyDzienTygodniaException wyjątek podnoszony, gdy jest podany dzień tygodnia jest za mały
     */
    public Tygodnik(String tytul,DzienTygodnia dzienTygodnia) {
        super(tytul);

        this.dzienTygodnia=dzienTygodnia;
    }
    @Override
    public String toString() {
        return "Kategoria: Tygodnik              "+ Konsola.stalaSzerokosc("",20)+
                " Tytuł: "+ Konsola.stalaSzerokosc(getTytul(),20);

    }
}
