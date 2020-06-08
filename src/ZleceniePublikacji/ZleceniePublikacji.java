package ZleceniePublikacji;

import Publikacje.Publikacja;
import ZleceniePublikacji.ZleceniePublikacjiExceptions.UjemnaZaplataException;

/**
 * @author MF
 * Klasa publiczna ZleceniePublikacji
 */
public class ZleceniePublikacji {
    private Publikacja dzielo;
    private String dataUkonczenia;
    private float zaplata;

    /**
     * Konstruktor publiczny klasy ZleceniePublikacji
     * @param zaplata Należnosc pieniedzy za wydrukoanie danej pozycji
     * @param dataUkonczenia Data ukonczenia druku danej pozycji
     * @param dzielo Publikacja, której dotyczy sie zlecenie zaplaty
     * @throws UjemnaZaplataException Wyjątek wyrzucany przy ujemnej kwocie.
     */
    public ZleceniePublikacji(Float zaplata,String dataUkonczenia, Publikacja dzielo) throws UjemnaZaplataException {
        if(zaplata<0){throw new UjemnaZaplataException();}
        this.dzielo = dzielo;
        this. dataUkonczenia= dataUkonczenia;
        this.zaplata = zaplata;
    }

    /**
     * Publiczna metoda klasy ZleceniePublikacji
     * @return Zwraca date ukończenia
     */
    public String getDataUkonczenia(){
        return this.dataUkonczenia;
    }

    /**
     * Publiczna metoda klasy ZleceniePublikacji
     * @return Zwraca kwote, za którą ma być wydrukowana dana pozycja
     */
    public float getZaplata(){
        return this.zaplata;
    }

    /**
     * Publiczna metoda klasy ZleceniePublikacji
     * @param nowaData Ustawia nową datę ukończenia wydruku danej pozycji
     */
    public void przedluzUkonczenie(String nowaData){
        this.dataUkonczenia=nowaData;
    }

}
