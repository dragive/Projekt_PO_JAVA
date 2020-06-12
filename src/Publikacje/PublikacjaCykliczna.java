package Publikacje;

import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

/**
 * Klasa abstrakcyjna {@link PublikacjaCykliczna} rozszerza {@link Publikacja}
 * Dziedziczą z niej: {@link Tygodnik}, {@link Miesiecznik}.
 * @author MF
 */
public abstract class PublikacjaCykliczna extends Publikacja{
    /**
     * Konstruktor klasy abstrakcyjnej {@link PublikacjaCykliczna}.
     * @param tytul Jest to tytuł danej publikacji
     * @throws ZaKrotkiTytulException Podnoszony wyjątek {@link ZaKrotkiTytulException}, gdy tytuł jest długości 0
     */
    public PublikacjaCykliczna(String tytul) throws  ZaKrotkiTytulException
    {
        super(tytul);

    }
}
