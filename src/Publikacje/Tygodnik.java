package Publikacje;

import Data.DzienTygodnia;
import Data.DzienTygodniaExceptions.ZaDuzyDzienTygodniaException;
import Data.DzienTygodniaExceptions.ZaMalyDzienTygodniaException;
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
    public Tygodnik(String tytul,DzienTygodnia dzienTygodnia) throws ZaKrotkiTytulException, ZaDuzyDzienTygodniaException, ZaMalyDzienTygodniaException {
        super(tytul);
        dzienTygodnia.sprawdzPoprawnoscDniaTygodnia();
        this.dzienTygodnia=dzienTygodnia;
    }
}
