package Umowy;


import Umowy.UmowyExceptions.PonowneRozwiazanieUmowyException;
import ZleceniePublikacji.ZleceniePublikacji;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MF
 * Klasa dziedzicząca z klasy abstrakcyjnej Umowa
 * Klasa reprezentuje umowy o prace.
 */
public class UmowaOPrace  extends  Umowa{
    /**
     * Data końca umowy
     */
    private String dataKonca;
    /**
     * Zmienna określająca czy dana umowa jest już rozwiązana, czy nie
     */
    private boolean czyRozwiazana;
    /**
     * Lista zleceń zawartych w umowie
     */
    private List<ZleceniePublikacji> zlecenia;

    /**
     * Konstruktor publiczny klasy UmowaOPrace
     * @param dataZawarcia Data zawarcia umowy.
     * @param dataKonca Data zakończenia umowy.
     */
    public UmowaOPrace(String dataZawarcia, String dataKonca){
        super(dataZawarcia);
        this.dataKonca=dataKonca;
        this.czyRozwiazana=false;
        zlecenia = new ArrayList<ZleceniePublikacji>();
    }

    /**
     * Metoda zwracająca date zakończenia umowy
     * @return Data zakończenia umowy
     */
    public String getDataKonca() {
        return dataKonca;
    }

    /**
     * Metoda służąca dodawaniu zleceń do konkretnej umowy
     * @param zlecenie Zlecenie, które ma być dodane do danej uwmoy
     */
    public void dodajZlecenie(ZleceniePublikacji zlecenie){
        this.zlecenia.add(zlecenie);
    }

    /**
     * Metoda służąca do pobrania zleceń publikacji zapisanych w danej umowie
     * @return Zwraca listę zleceń zapisanych
     */
    public List<ZleceniePublikacji> getZlecenia() {
        return this.zlecenia;
    }

    /**
     * Metoda służąca doprzedłużenia umowy
     * @param nowaData Nowa data zakończenia umowy
     */
    public void przedluz(String nowaData){
        this.dataKonca=nowaData;
    }

    /**
     * Rozwiązuje daną umowę.
     * @throws PonowneRozwiazanieUmowyException Wyjątek wyrzucany, gdy rozwiązywana jest juz umowa rozwiązana.
     */
    public void rozwiazUmowe() throws PonowneRozwiazanieUmowyException {
        if(this.czyRozwiazana==true) throw new PonowneRozwiazanieUmowyException();
        this.czyRozwiazana=true;
    }
}
