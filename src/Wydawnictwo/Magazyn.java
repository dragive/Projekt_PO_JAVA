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

/**
 * Klasa realizująca działanie magazynu.
 */
public class Magazyn  implements Serializable {
    /**
     * Pole służące do przechowywania danych o ilośc publikacji umieszczonych w magazynie
     */
    private Map<Publikacja, Integer> publikacje;

    /**
     * Publiczny konstruktor klasy Magazyn
     */
    public Magazyn(){
        publikacje = new HashMap<Publikacja, Integer>();
    }

    /**
     * Metoda służąca dodawaniu danej ilości publikacji do magazynu
     * @param dzielo Publikacja której egzemplarze są dodawane do magazynu
     * @param ilosc Ilość danej publikajcji dodawanej do magazynu
     */
    public void dodajPublikacje(Publikacja dzielo,Integer ilosc){

        if (!publikacje.containsKey(dzielo)) {
            publikacje.put(dzielo,ilosc);
        }else

        publikacje.put(dzielo,ilosc+publikacje.get(dzielo));
        /*//todo debug
        System.out.print(publikacje.get(dzielo).toString()+"  alaa  "+ilosc.toString());*/
    }

    /**
     * Metoda pobierająca i zwracająca ilość publikacji w magazynie
     * @param klucz publikacja, ktorej ilość w magazynie ma być pobrana i zwrócona
     * @return Zwracana jest ilość danej publikacji w magazynie
     */
    public Integer sprawdzIloscPublikacjiWMagazynie(Publikacja klucz){
        if(publikacje.get(klucz)==null)publikacje.put(klucz,0);
        return publikacje.get(klucz);
    }

    /**
     * Metoda służąca do wypisania stany magazynu na konsoli
     * @param listaPublikacjiWWydawnictwie Lista wszystkich dostępnych publikacji dla których ma być wypisany stan
     */
    public void wypiszStanMagazynu(List<Publikacja> listaPublikacjiWWydawnictwie){
        if(listaPublikacjiWWydawnictwie.size()==0){System.out.println("\nW magazynie nie ma żadnych książek, " +
                "ponieważ w wydawnictwie nie ma żadnych zapisanych książek.\n");return;}
        for(Publikacja element : listaPublikacjiWWydawnictwie){
            System.out.println("Ilość w magazynie: "+
                    Konsola.stalaSzerokosc(sprawdzIloscPublikacjiWMagazynie(element).toString(),6)
                    +element.toString());
        }
    }

    /**
     * Metoda przyjmująca dostawe z Działu druku i Drukarń i dodająca publikacje do stanu magazynu
     * @param zWydruku Wykaz ile i jakich publikacji nastapił wydruk
     */
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

    /**
     * Metoda służąca do realizowania zakupu poprzez mniejszenie stanu w magazynie danje publikacji
     * @param publ publikacja dla której ma być zmiejszony stan w magazynue
     * @param ilosc ilość o jaką ma być zmneijszony stan w magazynie
     * @throws MagazynZaMaloPublikacjiDoWykonaniaZakupuException Wyjątek wyrzucany, gdy w magazynie nie ma wystaczającej ilośći publikacji
     */
    public void zmniejszenieStanuMagazynu(Publikacja publ,Integer ilosc)throws MagazynZaMaloPublikacjiDoWykonaniaZakupuException {
        if(publikacje.get(publ)-ilosc<0)throw new MagazynZaMaloPublikacjiDoWykonaniaZakupuException();
        publikacje.put(publ,(publikacje.get(publ)-ilosc));
    }


}
