package Publikacje;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

import java.io.Serializable;

/**
 * Klasa abstrakcyjna. Klasa bazowa dla klas {@link PublikacjaCykliczna} i {@link Ksiazka}.
 * @author MF
 *
 */


public abstract class Publikacja implements Serializable {
    /*todo dodanie autora publikajci*/
    /**
     * Zmienna zawierajaca tytuł publikacji.
     */
    private String tytul;
    /**
     * Zmienna charakterystyczna dla każdego obiektu z klasy {@link Publikacja}.
     */
    /*private int ID;*/
/**
     * Zmienna statyczna przeznaczona dla wyznaczania kolejnych ID.
     *//*
    static private int nextID;*/

    /**
     * Konstruktor abstrakcyjnej klasy {@link Publikacja}
     * Pobiera 1 parametr.
     * @param tytul Tytuł danej publikacji.
     * @exception Publikacje.PublikacjaExceptions.ZaKrotkiTytulException Wyjątek występujący przy tytule, którego długość jest równa 0.
     */
    public Publikacja (String tytul,String imieNazwiskoAutora)// throws ZaKrotkiTytulException
    {
            this.setTytul(tytul);
            this.imieNazwiskoAutora=imieNazwiskoAutora;
            /*ID=++nextID; //#todo pobranie wczytanie id*/
    }

    /**
     * Metoda klasy abstrakcyjnej {@link Publikacja}
     * @return Zwraca tutuł danej publikacji
     */
    public String getTytul(){
        return this.tytul;
    }

    /*
     * Metoda klasy abstrakcyjnej {@link Publikacja}
     * @return Zwraca charakterystyczny numer danej publikacji
     */
    /*public int getID(){
        return this.ID;
    }*/

    /**
     * Metoda abstrakcyjnej klasy {@link Publikacja}
     * Zapisauje tytuł publikacji.
     * @param tytul Parametr typu String, będący tytułem danej publikacji.
     * @throws Publikacje.PublikacjaExceptions.ZaKrotkiTytulException Wyjątek występujący przy tytule, którego długość jest równa 0.
     */
    protected void setTytul (String tytul)  {
        //if(tytul.length()<1)throw new ZaKrotkiTytulException();
        this.tytul=tytul;
    }

    public String getImieNazwiskoAutora(){return imieNazwiskoAutora;}
    protected String imieNazwiskoAutora;/*todo dodanie do klas pochodnych obslugi autora*/


}
