package ZleceniePublikacji;

import Data.Data;
import Publikacje.Publikacja;
import ZleceniePublikacji.ZleceniePublikacjiExceptions.UjemnaZaplataException;

/**
 * Klasa publiczna {@link ZleceniePublikacji}
 * @author MF
 */
public class ZleceniePublikacji {
    private Publikacja dzielo;

    private Data dataUkonczenia;
    private float zaplata;

    /**
     * Konstruktor publiczny klasy {@link ZleceniePublikacji}
     * @param zaplata Należnosc pieniedzy za wydrukoanie danej pozycji
     * @param dataUkonczenia Data ukonczenia druku danej pozycji
     * @param dzielo Publikacja, której dotyczy sie zlecenie zaplaty
     * @throws UjemnaZaplataException Wyjątek wyrzucany przy ujemnej kwocie.
     */
    public ZleceniePublikacji(Float zaplata,Data dataUkonczenia, Publikacja dzielo) throws UjemnaZaplataException {
        if(zaplata<0){throw new UjemnaZaplataException();}
        this.dzielo = dzielo;
        this. dataUkonczenia= dataUkonczenia;
        this.zaplata = zaplata;
    }

    /**
     * Publiczna metoda klasy {@link ZleceniePublikacji}
     * @return Zwraca date ukończenia
     */
    public Data getDataUkonczenia(){
        return this.dataUkonczenia;
    }

    /**
     * Publiczna metoda klasy {@link ZleceniePublikacji}
     * @return Zwraca kwote, za którą ma być wydrukowana dana pozycja
     */
    public float getZaplata(){
        return this.zaplata;
    }



}
