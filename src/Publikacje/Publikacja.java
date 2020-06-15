package Publikacje;

import java.io.Serializable;
import java.util.Objects;

/**
 * Klasa abstrakcyjna. Klasa bazowa dla klas {@link PublikacjaCykliczna} i {@link Ksiazka}.
 * @author MF
 *
 */


public abstract class Publikacja implements Serializable {

    /**
     * Zmienna zawierajaca tytuł publikacji.
     */
    private String tytul;

    /**
     * Konstruktor abstrakcyjnej klasy {@link Publikacja}
     * Pobiera 1 parametr.
     * @param tytul Tytuł danej publikacji.

     */
    public Publikacja (String tytul,String imieNazwiskoAutora)// throws ZaKrotkiTytulException
    {
            this.setTytul(tytul);
            this.imieNazwiskoAutora=imieNazwiskoAutora;

    }

    /**
     * Metoda klasy abstrakcyjnej {@link Publikacja}
     * @return Zwraca tutuł danej publikacji
     */
    public String getTytul(){
        return this.tytul;
    }


    /**
     * Metoda abstrakcyjnej klasy {@link Publikacja}
     * Zapisauje tytuł publikacji.
     * @param tytul Parametr typu String, będący tytułem danej publikacji.
     
     */
    protected void setTytul (String tytul)  {
        //if(tytul.length()<1)throw new ZaKrotkiTytulException();
        this.tytul=tytul;
    }

    public String getImieNazwiskoAutora(){return imieNazwiskoAutora;}
    protected String imieNazwiskoAutora;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publikacja that = (Publikacja) o;
        return getTytul().equals(that.getTytul()) &&
                getImieNazwiskoAutora().equals(that.getImieNazwiskoAutora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTytul(), getImieNazwiskoAutora());
    }
}
