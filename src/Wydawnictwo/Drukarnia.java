package Wydawnictwo;

import Publikacje.Publikacja;
import Wydawnictwo.KlasyPomocnicze.Pair;

import java.io.Serializable;
import java.net.Inet4Address;
import java.util.Queue;
import java.util.Vector;

public class Drukarnia implements Serializable {
    private Vector<Pair<Publikacja,Integer>> kolejkaDrukowania;
    private boolean drukAlbumow;

    public Drukarnia(boolean drukAlbumow){
        kolejkaDrukowania=new Vector<>();this.drukAlbumow=drukAlbumow;
    }
    public void zlozZamowienieNaDruk(Publikacja dzielo, Integer ilosc){
        kolejkaDrukowania.add(new Pair(dzielo,ilosc));
    }


    public Vector<Pair<Publikacja,Integer>> wydajPolecenieWydruku(){
        Vector<Pair<Publikacja,Integer>> ret;
        ret=new Vector (kolejkaDrukowania);
        kolejkaDrukowania.clear();
        return ret;
    }

    public Vector<Pair<Publikacja, Integer>> getKolejkaDrukowania() {
        return kolejkaDrukowania;
    }
}
