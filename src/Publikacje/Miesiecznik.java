package Publikacje;

import Publikacje.PublikacjaExceptions.NieprawidlowyFormatDatyException;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

/**
 * @author MF
 * Klasa Miesięcznika, dziedziczącej z klasy abstrakcyjnej <i>PublikacjaCykliczna</i>
 */
public class Miesiecznik extends PublikacjaCykliczna{
    /**
     * Prywatne pole klasy Miesięcznik
     * Przechowuje informacje o dniu miesiąca
     */
    private String dzienMiesiaca;

    /**
     * Konstruktor klasy Miesięcznik
     * @param tytul Tytuł danej publikacji
     * @param dzienMiesiaca Dzień miesiąca cyklicznego wydawania publikacji
     * @throws ZaKrotkiTytulException Wyjątek, podnoszony gdy tytuł jest za krótki
     * @throws NieprawidlowyFormatDatyException wyjątek podnoszony gdy jest podany nieprawidlowy format daty
     */
    public Miesiecznik(String tytul, String dzienMiesiaca)throws ZaKrotkiTytulException, NieprawidlowyFormatDatyException {
        super(tytul);
        if(dzienMiesiaca.length()<1){
            throw new NieprawidlowyFormatDatyException();
        }
        this.dzienMiesiaca=dzienMiesiaca;
    }
}
