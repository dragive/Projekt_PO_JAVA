package Umowy;

import Konsola.Konsola;
import Publikacje.Publikacja;
import ZleceniePublikacji.ZleceniePublikacjiExceptions.UjemnaZaplataException;
import Data.Data;

import java.io.Serializable;

/**
 * Klasa finalna dziedzicząca z klasy abstrakcyjnej {@link Umowa}.
 * @author MF
 */
public final class UmowaODzielo extends Umowa {
    /**
     * Publikacja, na której wytworzenie została podpisana umowa
     */
    private Publikacja dzielo;
    /**
     * Data ukończenia pracy nad daną publikacją (klasa {@link Publikacja} )
     */
    private Data dataUkonczenia;
    /**
     * Kwota jaka sie należy autorowi za wykonaną prace
     */
    private Float zaplata;

    /**
     * Publiczny konstruktor klasy {@link UmowaODzielo}
     * @param zaplata Wysokośc zaplaty za wykonaną pracę
     * @param dataZawarcia Data zawarcia umowy
     * @param dataUkonczenia Data ukończenia umowy
     * @param dzielo Dzieło, na którego wykonanie została podpisana umowa
     * @throws UjemnaZaplataException Wyjątek wyrzucany, gdy występuje nie prawidłowa, ujemna kwota zapłaty.
     */
    public UmowaODzielo(Float zaplata,Data dataZawarcia, Data dataUkonczenia,Publikacja dzielo)  {
        super(dataZawarcia);
       //if (zaplata < 0) throw new UjemnaZaplataException();
        this.zaplata = zaplata;
        this.dataUkonczenia = dataUkonczenia;
        this.dzielo = dzielo;
    }


    @Override
    public void aktualizacnaAktywnosciUmowy(Data data){
        if(dataZawarcia.wczesniejsza(data)==1&&data.wczesniejsza(dataUkonczenia)==1)
            czyAktywna=true;
            else czyAktywna=false;
    }
    @Override
    public void kolejnyDzien(Data data){
        this.aktualizacnaAktywnosciUmowy(data);
    }

    @Override
    public String toString() {

        return "Kategoria: \"O Dzieło\"     Na Dzielo: "+ Konsola.stalaSzerokosc( dzielo.getTytul(),20)+
                "   Data Zawarcia: " + dataZawarcia +
                "   Data Zakonczenia: " + dataUkonczenia +
                "   Zaplata: " + Konsola.stalaSzerokosc( zaplata.toString(),7);
    }
}
