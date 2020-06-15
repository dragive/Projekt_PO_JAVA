package Wydawnictwo;

import Publikacje.Publikacja;
import Wydawnictwo.KlasyPomocnicze.Pair;

import java.io.Serializable;
import java.net.Inet4Address;
import java.util.Queue;
import java.util.Vector;

/**
 * Klasa drukarni.
 */
public class Drukarnia implements Serializable {
    /**
     * Prywatne pole przechowujące publikacje i ich naklad w kolejce do drukowania
      */
    private Vector<Pair<Publikacja,Integer>> kolejkaDrukowania;
    /**
     * Informacja czy dana drukarnia obsluguje druk albumów
     */
    private boolean drukAlbumow;

    /**
     * Publiczny konstruktor klasy Drukarnia
     * @param drukAlbumow informacja czy ta drukarnia ma obslugiwać drukowanie Albumów
     */
    public Drukarnia(boolean drukAlbumow){
        kolejkaDrukowania=new Vector<>();this.drukAlbumow=drukAlbumow;
    }

    /**
     * Metoda złużąca do składania zamówień do druku
     * @param dzielo dzielo, które ma być wydrukowane
     * @param ilosc naklad dzieła do drukowania
     */
    public void zlozZamowienieNaDruk(Publikacja dzielo, Integer ilosc){
        kolejkaDrukowania.add(new Pair(dzielo,ilosc));
    }

    /**
     * Zwraca wydrukowane publikacje i czyści kolejke
     * @return Zwracane są wyrukowane publiakcje
     */
    public Vector<Pair<Publikacja,Integer>> wydajPolecenieWydruku(){
        Vector<Pair<Publikacja,Integer>> ret;
        ret=new Vector (kolejkaDrukowania);
        kolejkaDrukowania.clear();
        return ret;
    }

    /**
     * zwraca kolejke drukowania
     * @return Zwraca kolejke drukowania
     */
    public Vector<Pair<Publikacja, Integer>> getKolejkaDrukowania() {
        return kolejkaDrukowania;
    }
}
