package Publikacje;

import Data.DzienMiesiaca;
import Data.DzienMiesiacaExceptions.ZaDuzyDzienMiesiacaException;
import Data.DzienMiesiacaExceptions.ZaMalyDzienMiesiacaException;

import Konsola.Konsola;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

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
     * @throws ZaKrotkiTytulException Wyjątek, podnoszony gdy tytuł jest za krótki
     * @throws ZaMalyDzienMiesiacaException wyjątek podnoszony gdy jest za mały dzień miesiąca
     * @throws ZaDuzyDzienMiesiacaException wyjątek podnoszony gdy jest za duży dzień miesiąca
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
}
