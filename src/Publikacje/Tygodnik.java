package Publikacje;

import Publikacje.PublikacjaExceptions.NieprawidlowyFormatDatyException;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

/**
 * @author MF
 * Klasa Tygodnika, dziedziczącej z klasy abstrakcyjnej <i>PublikacjaCykliczna</i>
 */
public class Tygodnik extends PublikacjaCykliczna{
    /**
     * Prywatne pole klasy Tygodnik
     * Przechowuje informacje o dniu tygodnia
     */
    private String dzienTygodnia;
    /**
     * Konstruktor klasy Tygodnik
     * @param tytul Tytuł danej publikacji
     * @param dzienTygodnia Dzień Tygodnia cyklicznego wydawania publikacji
     * @throws ZaKrotkiTytulException Wyjątek, podnoszony gdy tytuł jest za krótki
     * @throws NieprawidlowyFormatDatyException wyjątek podnoszony gdy jest podany nieprawidlowy format daty
     */
    public Tygodnik(String tytul,String dzienTygodnia)throws ZaKrotkiTytulException, NieprawidlowyFormatDatyException {
        super(tytul);
        if(dzienTygodnia.length()<1){
            throw new NieprawidlowyFormatDatyException();
        }
        this.dzienTygodnia=dzienTygodnia;
    }
}
