package Publikacje;

import Autor.Autor;
import Konsola.Konsola;
import Konsola.Konsola.*;
import Publikacje.PublikacjaExceptions.ZaKrotkiGatunekException;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

/**
 * Klasa {@link Ksiazka} rozszerza klasę abstrakcyjną {@link Publikacja}.
 * @author MF
 */
public class Ksiazka  extends Publikacja{
    /**
     * Zmienna przechowywująca informacje jakiego gatunku jest dana książka
     */
    private String gatunek;


    /**
     * Konstruktor publiczny klasy Książka
     * @param tytul tytuł danej publikacji
     * @param gatunek gatunek danej ksiażki
     * @throws ZaKrotkiTytulException Wyjątek występujący,gdy następuje próba ustawienia za krótkiego tytułu
     * @throws ZaKrotkiGatunekException Wyjątek występujący,gdy następuje próba ustawienia za krótkiego gatunku
     */
    public Ksiazka(String tytul, String gatunek, String imieNazwiskoAutora)// throws ZaKrotkiTytulException, ZaKrotkiGatunekException
    {
        super(tytul,imieNazwiskoAutora);
        //this.imieNazwiskoAutora=imieNazwiskoAutora;
        this.gatunek=gatunek;
    }
    public String getGatunek(){
        return  this.gatunek;
    }


    @Override
    public String toString() {
        return "Kategoria: Ksiazka        " + " Autor: "+Konsola.stalaSzerokosc(imieNazwiskoAutora,20)+
                " Tytuł: "+ Konsola.stalaSzerokosc(getTytul(),20)+
                " Gatunek: "+ Konsola.stalaSzerokosc(getGatunek(),20);
    }
}
