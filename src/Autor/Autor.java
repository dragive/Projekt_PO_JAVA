package Autor;

import Autor.AutorExceptions.PusteImieNazwiskoException;
import Data.Data;
import Konsola.Konsola;
import Publikacje.Ksiazka;
import Publikacje.Publikacja;
import Umowy.Umowa;
import Umowy.UmowaODzielo;
import Umowy.UmowaOPrace;
import ZleceniePublikacji.ZleceniePublikacjiExceptions.UjemnaZaplataException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
     * Prywatna statyczna metoda klasy {@link Autor} sprawdza poprawność Imienia i nazwiska.
     *
     * @param imieNazwisko Parametr w którym przekazywana jest wartość imienia i nazwiska autora
     * @throws PusteImieNazwiskoException Wyrzucany wyjątek jako nieprawidłowość
     */
    private static void sprawdzImieNazwisko(String imieNazwisko) throws PusteImieNazwiskoException {
        if (imieNazwisko.length() == 0) throw new PusteImieNazwiskoException();
    }

    /**
     * Prywatna statyczna metoda klasy {@link Autor} sprawdza poprawność Imienia i nazwiska.
     *
     * @throws PusteImieNazwiskoException Wyrzucany wyjątek jako nieprawidłowość
     */
    public void sprawdzImieNazwisko() throws PusteImieNazwiskoException {
        sprawdzImieNazwisko(this.imieNazwisko);
    }

    public void kolejnyDzien(Data data) {

        Iterator it = umowy.iterator();
        Umowa u;
        while (it.hasNext()) {
            u = (Umowa) it.next();
            u.kolejnyDzien(data);
        }
    }

    @Override
    public String toString() {
        return "Imie i nazwisko: " + Konsola.stalaSzerokosc( imieNazwisko,20) + "\t\t\t\t Ilość umów: " + this.umowy.size();
    }

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

    public Integer zakonczUmowe(Integer poczatekEnumeracji, Integer indexDoUsuniecia) {
        Iterator it = umowy.iterator();
       // if (indexDoUsuniecia > poczatekEnumeracji) return;
        while (it.hasNext()) {
            if (poczatekEnumeracji == indexDoUsuniecia) {
                ((Umowa) (it.next())).zakonczManualnie();

            }
            it.next();
            poczatekEnumeracji++;
        }
        return poczatekEnumeracji;
    }


}


