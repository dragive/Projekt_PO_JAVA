package Wydawnictwo;


import Konsola.Konsola;
import Publikacje.Publikacja;
import Wydawnictwo.KlasyPomocnicze.Pair;
import Wydawnictwo.MagazynExceptions.MagazynZaMaloPublikacjiDoWykonaniaZakupuException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Magazyn  implements Serializable {
    private Map<Publikacja, Integer> publikacje;

    public Magazyn(){
        publikacje = new HashMap<Publikacja, Integer>();
    }

    public void dodajPublikacje(Publikacja dzielo,Integer ilosc){

        if (!publikacje.containsKey(dzielo)) {
            publikacje.put(dzielo,ilosc);
        }else

        publikacje.put(dzielo,ilosc+publikacje.get(dzielo));
        /*//todo debug
        System.out.print(publikacje.get(dzielo).toString()+"  alaa  "+ilosc.toString());*/
    }
    public Integer sprawdzIloscPublikacjiWMagazynie(Publikacja klucz){
        if(publikacje.get(klucz)==null)publikacje.put(klucz,0);
        return publikacje.get(klucz);
    }

    public void wypiszStanMagazynu(List<Publikacja> listaPublikacjiWWydawnictwie){
        if(listaPublikacjiWWydawnictwie.size()==0){System.out.println("\nW magazynie nie ma żadnych książek, " +
                "ponieważ w wydawnictwie nie ma żadnych zapisanych książek.\n");return;}
        for(Publikacja element : listaPublikacjiWWydawnictwie){
            System.out.println("Ilość w magazynie: "+
                    Konsola.stalaSzerokosc(sprawdzIloscPublikacjiWMagazynie(element).toString(),6)
                    +element.toString());
        }
    }

    public void przyjmijPublikacjeZWydruku(Vector<Pair<Publikacja,Integer>> zWydruku){
        Publikacja p;
        Integer l;
        System.out.print(zWydruku.size());
        for(int i=0;i<zWydruku.size();i++){
            p=zWydruku.get(i).getFirst();
            l=zWydruku.get(i).getSecond();
            dodajPublikacje(p,l);
        }
    }

    public void zmniejszenieStanuMagazynu(Publikacja publ,Integer ilosc)throws MagazynZaMaloPublikacjiDoWykonaniaZakupuException {
        if(publikacje.get(publ)-ilosc<0)throw new MagazynZaMaloPublikacjiDoWykonaniaZakupuException();
        publikacje.put(publ,(publikacje.get(publ)-ilosc));
    }


}
