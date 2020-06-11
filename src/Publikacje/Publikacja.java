package Publikacje;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

/**
 * @author MF<br>
 * Klasa abstrakcyjna.
 * Klasa bazowa dla klas Publikacja Cykliczna i Ksiażka.
 *
 */


public abstract class Publikacja {
    /**
     * Zmienna zawierajaca tytuł publikacji.
     */
    private String tytul;
    /**
     * Zmienna charakterystyczna dla każdego obiektu z klasy Publikacja.
     */
    private int ID;
    /**
     * Zmienna statyczna przeznaczona dla wyznaczania kolejnych ID.
     */
    static private int nextID;

    /**
     * Konstruktor abstrakcyjnej klasy Publikacja
     * Pobiera 1 parametr.
     * @param tytul Tytuł danej publikacji.
     * @exception Publikacje.PublikacjaExceptions.ZaKrotkiTytulException Wyjątek występujący przy tytule, którego długość jest równa 0.
     */
    public Publikacja (String tytul) throws ZaKrotkiTytulException
    {
            this.setTytul(tytul);
    }

    /**
     * Metoda klasy abstrakcyjnej Publikacja
     * @return Zwraca tutuł danej publikacji
     */
    public String getTytul(){
        return this.tytul;
    }

    /**
     * Metoda klasy abstrakcyjnej Publikacja
     * @return Zwraca charakterystyczny numer danej publikacji
     */
    public int getID(){
        return this.ID;
    }

    /**
     * Metoda abstrakcyjnej klasy Publikacja
     * Zapisauje tytuł publikacji.
     * @param tytul Parametr typu String, będący tytułem danej publikacji.
     * @throws Publikacje.PublikacjaExceptions.ZaKrotkiTytulException Wyjątek występujący przy tytule, którego długość jest równa 0.
     */
    protected void setTytul (String tytul) throws ZaKrotkiTytulException {
        if(tytul.length()<1)throw new ZaKrotkiTytulException();
        this.tytul=tytul;
    }

}
