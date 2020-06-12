package Wydawnictwo;

import Publikacje.Publikacja;
import Wydawnictwo.KlasyPomocnicze.Pair;

import java.io.Serializable;
import java.net.Inet4Address;
import java.util.Queue;

public class Drukarnia implements Serializable {
    private Queue<Pair<Publikacja,Integer>> kolejkaDrukowania;
    private boolean drukAlbumow;
    /*private boolean drukCzasopism;
    private boolean druk;*/

    public Drukarnia(boolean drukAlbumow){
        this.drukAlbumow=drukAlbumow;
    }
    public void zamow(Publikacja dzielo, int ilosc){
        kolejkaDrukowania.add(new Pair(dzielo,ilosc));
    }
    public Pair<Publikacja,Integer> drukuj(){
        Pair<Publikacja,Integer> wydrukowane=kolejkaDrukowania.poll();
        return wydrukowane;
    }
    public boolean getDrukAlbumow(){
        return this.drukAlbumow;
    }


}
