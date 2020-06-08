package Umowy;

import Publikacje.Publikacja;
import ZleceniePublikacji.ZleceniePublikacjiExceptions.UjemnaZaplataException;

/**
 * @author MF
 * Klasa dziedzicząca z klasy abstrakcyjnej <i>Umowa</i>
 */
public class UmowaODzielo extends Umowa{
    /**
     * Publikacja, na której wytworzenie została podpisana umowa
     */
    private Publikacja dzielo;
    /**
     * Data ukończenia pracy nad daną publikacją
     */
    private String dataUkonczenia;
    /**
     * Kwota jaka sie należy autorowi za wykonaną prace
     */
    private float zaplata;

    /**
     * Publiczny konstruktor klasy UmowaODzielo
     * @param zaplata Wysokośc zaplaty za wykonaną pracę
     * @param dataZawarcia Data zawarcia umowy
     * @param dataUkonczenia Data ukończenia umowy
     * @param dzielo Dzieło, na którego wykonanie została podpisana umowa
     * @throws UjemnaZaplataException
     */
    public UmowaODzielo(Float zaplata,String dataZawarcia, String dataUkonczenia,Publikacja dzielo) throws UjemnaZaplataException {
        super(dataZawarcia);
        if (zaplata < 0) throw new UjemnaZaplataException();
        this.zaplata = zaplata;
        this.dataUkonczenia = dataUkonczenia;
        this.dzielo = dzielo;
    }

    /**
     * Publiczna metoda klasy UmowaODzielo
     * @return Zwracana jest data ukończenia.
     */
    public String getDataUkonczenia() {
        return this.dataUkonczenia;
    }

    /**
     * Publiczna metoda klasy UmowaODzielo
     * @return Zwracana jest zaplata
     */
    public float getZaplata() {
        return this.zaplata;
    }

    /**
     * Publiczna metoda klasy UmowaODzielo
     * @param nowaData Nowa data, do której będzie obowiązywać dana umowa
     */
    public void przedluzUkonczenie(String nowaData){
        this.dataUkonczenia=nowaData;
    }

    /**
     * Publiczna metoda klasy UmowaODzielo
     * @param nowaZaplata Nowa wartość zaplaty do aktualizacji w umowie
     * @throws UjemnaZaplataException Wyjątek podnoszony, gdy zaplata jest ujemna
     */
    public void zmienZaplate(float nowaZaplata) throws UjemnaZaplataException{
        if(zaplata<0)throw new UjemnaZaplataException();
        this.zaplata=zaplata;
    }
}
