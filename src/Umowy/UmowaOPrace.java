package Umowy;


import Umowy.UmowyExceptions.PonowneRozwiazanieUmowyException;
import ZleceniePublikacji.ZleceniePublikacji;

import java.util.ArrayList;
import java.util.List;
import Data.Data;
/**
 * Klasa dziedzicząca z klasy abstrakcyjnej {@link Umowa}
 * Klasa reprezentuje umowy o prace.
 * @author MF
 */
public class UmowaOPrace  extends  Umowa{
    /**
     * Data końca umowy
     */

    private Data dataKonca;
    /**
     * Zmienna określająca czy dana umowa jest już rozwiązana, czy nie
     */

    /**
     * Lista zleceń zawartych w umowie
     */
    private List<ZleceniePublikacji> zlecenia;

    /**
     * Konstruktor publiczny klasy {@link UmowaOPrace}
     * @param dataZawarcia Data zawarcia umowy.
     * @param dataKonca Data zakończenia umowy.
     */
    public UmowaOPrace(Data dataZawarcia, Data dataKonca){
        super(dataZawarcia);
        this.dataKonca=dataKonca;
        this.czyAktywna=false;
        zlecenia = new ArrayList<ZleceniePublikacji>();
    }

    /**
     * Metoda zwracająca date zakończenia umowy
     * @return Data zakończenia umowy
     */
    public Data getDataKonca() {
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
     * @param iloscDni Ilość dni, o które przedlużana jest umowa.
     */

    public void przedluz(int iloscDni){
        for(int i=0;i<iloscDni;i++)this.dataKonca.kolejnyDzien();
    }


    /**
     * Rozwiązuje daną umowę.
     * @throws PonowneRozwiazanieUmowyException Wyjątek wyrzucany, gdy rozwiązywana jest juz umowa rozwiązana.
     */
    public void rozwiazUmowe() throws PonowneRozwiazanieUmowyException {
        if(this.czyAktywna==true) throw new PonowneRozwiazanieUmowyException();
        this.czyAktywna=true;
    }

    @Override
    public void aktualizacnaAktywnosciUmowy(Data data){
        if(dataZawarcia.wczesniejsza(data)==1&&data.wczesniejsza(dataKonca)==1)
            czyAktywna=true;
        else czyAktywna=false;
    }
    @Override
    public void kolejnyDzien(Data data){
        this.aktualizacnaAktywnosciUmowy(data);
    }

}
