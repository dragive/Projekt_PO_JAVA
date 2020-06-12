package Wydawnictwo;


import Publikacje.Publikacja;
import Wydawnictwo.KlasyPomocnicze.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Magazyn  implements Serializable {
    private List<Pair < Publikacja, Integer>> publikacje;

    public Magazyn(){
        publikacje = new ArrayList<Pair < Publikacja, Integer>>();
    }
    public void dodajPublikacje(Publikacja dzielo,Integer ilosc){
        publikacje.add(new Pair(dzielo,ilosc));
    }
    public void dodajPublikacje(Publikacja dzielo,int ID){
        this.dodajPublikacje(dzielo,(Integer)ID);
    }
    public void realizacjaZakupu(Publikacja dzielo,int ilosc){

    }

}
