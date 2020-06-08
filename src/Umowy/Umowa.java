package Umowy;

/**
 * @author MF
 * Klasa abstrakcyjma Umowa
 */
public abstract class Umowa {
    /**
     * Data zawarcia danej umowy
     */
    protected String dataZawarcia;

    /**
     * Publiczna metoda klasy abstrakcyjnej Umowa
     * @return Zwraca datę zawarcia umowy.
     */
    public String getDataZawarcia() {
        return this.dataZawarcia;
    }

    /**
     * Metoda klasy Umowa
     * @param dataZawarcia Zwraca date zawarcia umowy
     */
    public Umowa(String dataZawarcia){
        this.dataZawarcia=dataZawarcia;
    }
}
