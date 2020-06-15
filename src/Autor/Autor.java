package Autor;


import Data.Data;
import Konsola.Konsola;
import Umowy.Umowa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Klasa opisująca autorów publikacji (zobacz też: {@link Publikacje.Publikacja}).
 * @author ACH i MF
 */
public class Autor implements Serializable {
    /**
     * Prywatne pole obiektów klasy {@link Autor} przechowujące informacje o imieniu i nazwisku autora.
     */
    private String imieNazwisko;
    /**
     * Prywatne pole obiektów klasy {@link Autor} przechowujące informacje o imieniu i nazwisu autora.
     */
    private List<Umowa> umowy;

    /**
     * Konstruktor publiczny obiektów klasy {@link Autor}.
     *
     * @param imieNazwisko Parametr definiujący jakie imię i nazwisko posaida autor.
     */
    public Autor(String imieNazwisko) {
        umowy = new ArrayList<Umowa>();
        this.imieNazwisko = imieNazwisko;
        /*try {
            umowy.add(new UmowaODzielo((float) 123.0, new Data(1000, 1, 1),
                    new Data(2000, 2, 2), new Ksiazka("tytul", "gatuenk","autor2")));
        } catch (Exception ex) {
        }
        try {
            umowy.add(new UmowaOPrace(new Data(1000, 1, 1), new Data(2000, 2, 2)));
        } catch (Exception ex) {
        }

        try {
            umowy.add(new UmowaODzielo((float) 13.0, new Data(2000, 1, 1),
                    new Data(2030, 2, 2), new Ksiazka("Ksiazka1", "gatuenk1","autor 2")));
        } catch (Exception ex) {
        }
        try {
            umowy.add(new UmowaOPrace(new Data(1990, 1, 1), new Data(1901, 2, 2)));
        } catch (Exception ex) {
        }*/
    }

    /**
     * Metoda obiektów klasy {@link Autor}. Zwraca imię i nazwisko autora.
     *
     * @return Zwraca imię i nazwisko autora.
     */
    public String getImieNazwisko() {
        return imieNazwisko;
    }

    /**
     * Metoda obiektów klasy {@link Autor}. Zwraca listę umów zawartych z autorem.
     *
     * @return Zwraca listę umów zawartych z autorem
     */
    public List<Umowa> getUmowy() {
        return umowy;
    }

    /**
     * Metoda obiektów klasy {@link Autor}. Zapisauje zawartą umowe z autorem.
     *
     * @param umowa umowa zawarta z autorem, przypsiana do niego.
     */
    public void dodajUmowe(Umowa umowa) {
        umowy.add(umowa);
    }

    /**
     * Aktualizacja Obiektu dla kolejnego dnia
     * @param data data, dla której ma być zakutualizowany obiekt
     */
    public void kolejnyDzien(Data data) {

        Iterator it = umowy.iterator();
        Umowa u;
        while (it.hasNext()) {
            u = (Umowa) it.next();
            u.kolejnyDzien(data);
        }
    }

    /**
     * @return Zwraca tekstową reprezentacje obiektu
     */
    @Override
    public String toString() {
        return "Imie i nazwisko: " + Konsola.stalaSzerokosc( imieNazwisko,20) + "\t\t\t\t Ilość umów: " + this.umowy.size();
    }

    /**
     * Wypisanie daneych z obiektu niezależnie od tego czy umowa jest rozwiazana czy nie
     * @param poczatekEnumeracji przekazywane dane by moc wypisaywac na ekranie w posataci ID
     * @return Zwraca ostatnie ID wypisane na ekranie
     */
    public int wypiszKazdaUmowe(Integer poczatekEnumeracji) {
        Iterator it = umowy.iterator();
        Umowa umowa;
        while (it.hasNext()) {

            umowa = (Umowa) it.next();
            System.out.println(Konsola.stalaSzerokosc("ID: " + poczatekEnumeracji.toString(), 10) + umowa.toString()
                    +" Podpisano z: "+Konsola.stalaSzerokosc(this.getImieNazwisko(),20));
            poczatekEnumeracji++;
        }
        return poczatekEnumeracji;
    }

    /**
     * Wypisauje aktywne umowy tylko
     * @param poczatekEnumeracji  przekazywane dane by moc wypisaywac na ekranie w posataci ID
     * @param data Data potrzeban do stprawdzenia czy dana umowa juest juz aktywna czy też juz moze rozwiazana
     * @return Zwraca ostatnio wypisane ID
     */
    public int wypiszAktywnaUmowe(Integer poczatekEnumeracji, Data data) {
        Iterator it = umowy.iterator();
        Umowa umowa;
        while (it.hasNext()) {

            umowa = (Umowa) it.next();
            umowa.aktualizacnaAktywnosciUmowy(data);
            if (umowa.getCzyAktywna() && !umowa.getZakonczonaManualnie()) {
                System.out.println(Konsola.stalaSzerokosc("ID: " + poczatekEnumeracji.toString(), 10) + umowa.toString()+" Podpisano z: "+Konsola.stalaSzerokosc(this.getImieNazwisko(),20));
            }
            poczatekEnumeracji++;
        }
        return poczatekEnumeracji;
    }

    /**
     * Metoda zakańcza umowe manualnie.
     * @param poczatekEnumeracji  przekazywane dane by moc wypisaywac na ekranie w posataci ID
     * @param indexDoUsuniecia ID umowy w liscie do rozwiazania.
     * @return Zwraca ostatni ID dla ktorego bylo to rozpatrywane
     */
    public Integer zakonczUmowe(Integer poczatekEnumeracji, Integer indexDoUsuniecia) {
        Iterator it = umowy.iterator();
       // if (indexDoUsuniecia > poczatekEnumeracji) return;
        while (it.hasNext()) {
            if (poczatekEnumeracji == indexDoUsuniecia) {
                ((Umowa) (it.next())).zakonczManualnie();

            }
            else it.next();
            poczatekEnumeracji++;
        }
        return poczatekEnumeracji;
    }
}


