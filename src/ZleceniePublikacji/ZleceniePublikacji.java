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

    /**
     * Publiczna metoda klasy {@link ZleceniePublikacji}
     * @param nowaData Ustawia nową datę ukończenia wydruku danej pozycji
     */

    public void przedluzUkonczenie(Data nowaData){
        this.dataUkonczenia=nowaData;
    }

    /**
     * Publiczna metoda złużąca do zmiany zaplaty w zawartej umowie.
     * @param nowaZaplata Nowa zaplata
     * @throws UjemnaZaplataException Wyjątek podnoszony, gdy zaplata będzie ujemna
     */
    public void zmienZaplate(float nowaZaplata) throws UjemnaZaplataException{
        if(nowaZaplata<0)throw new UjemnaZaplataException();
        this.zaplata=nowaZaplata;
    }

}
