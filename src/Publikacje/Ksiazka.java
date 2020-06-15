package Publikacje;

import Konsola.Konsola;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return Objects.equals(getGatunek(), ksiazka.getGatunek());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGatunek());
    }
}
