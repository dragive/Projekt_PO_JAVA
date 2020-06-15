package Publikacje;


/**
 * Klasa abstrakcyjna {@link PublikacjaCykliczna} rozszerza {@link Publikacja}
 * Dziedziczą z niej: {@link Tygodnik}, {@link Miesiecznik}.
 * @author MF
 */
public abstract class PublikacjaCykliczna extends Publikacja{
    /**
     * Konstruktor klasy abstrakcyjnej {@link PublikacjaCykliczna}.
     * @param tytul Jest to tytuł danej publikacji
     */
    public PublikacjaCykliczna(String tytul,String imieNazwiskoAutora)
    {
        super(tytul,imieNazwiskoAutora);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
