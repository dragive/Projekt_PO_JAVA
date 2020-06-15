package Wydawnictwo;


import Konsola.Konsola;
import Publikacje.Ksiazka;
import Publikacje.Publikacja;
import Wydawnictwo.KlasyPomocnicze.Pair;
import jdk.swing.interop.DispatcherWrapper;

import java.io.Serializable;
import java.util.*;


public class DzialDruku  implements Serializable {
    private Vector<Drukarnia> drukarnie;



    public DzialDruku(){
        drukarnie=new Vector<Drukarnia>();
        drukarnie.add(new Drukarnia(true));
        drukarnie.add(new Drukarnia(false));
        drukarnie.add(new Drukarnia(false));
    }

    public void dodajZlecenieDrukuPublikacji(Publikacja publikacja,Integer ilosc,Integer drukarnia){
        Drukarnia d =drukarnie.get(drukarnia);
        d.zlozZamowienieNaDruk(publikacja,ilosc);
        drukarnie.set(drukarnia,d);
    }
    public static Vector<Pair<Publikacja,Integer>> ujednolicenieVectoraZWydrukowanymiPublikacjami(Vector<Pair<Publikacja,Integer>> vector1, Vector<Pair<Publikacja,Integer>> vector2){
        Map<Publikacja, Integer> mapa= new HashMap<Publikacja,Integer>();
        Vector<Pair<Publikacja,Integer>> vector= new Vector<Pair<Publikacja,Integer>> ();

        for(int i=0;i<vector1.size();i++){
            if(mapa.get(vector1.get(i).getFirst())==null)
            {
                mapa.put(vector1.get(i).getFirst(),vector1.get(i).getSecond());
            }else
            mapa.put(vector1.get(i).getFirst(),vector1.get(i).getSecond()+mapa.get(vector1.get(i).getFirst()));
        }

        for(int i=0;i<vector2.size();i++){
            if(mapa.get(vector2.get(i).getFirst())==null)
            {
                mapa.put(vector2.get(i).getFirst(),vector2.get(i).getSecond());
            }else
            mapa.put(vector2.get(i).getFirst(),vector2.get(i).getSecond()+mapa.get(vector2.get(i).getFirst()));
        }

        for(Map.Entry m : mapa.entrySet()){
            vector.add(new Pair<Publikacja,Integer>((Publikacja)m.getKey(),(Integer)m.getValue()));
        }

        return vector;
    }
    public Vector<Pair<Publikacja,Integer>> wydajPolecenieWydruku(){

        Vector <Pair<Publikacja,Integer>> vector ;
        Drukarnia drukarnia1,drukarnia2,drukarnia3;

        drukarnia1=drukarnie.get(0);
        drukarnia2=drukarnie.get(1);
        drukarnia3=drukarnie.get(2);

        vector = ujednolicenieVectoraZWydrukowanymiPublikacjami(drukarnia1.wydajPolecenieWydruku(),ujednolicenieVectoraZWydrukowanymiPublikacjami(drukarnia2.wydajPolecenieWydruku(),drukarnia3.wydajPolecenieWydruku()));
        drukarnie.set(0,drukarnia1);
        drukarnie.set(1,drukarnia2);
        drukarnie.set(2,drukarnia3);


        //todo debugfor(int i=0;i<vector.size();i++)System.out.println(vector.get(i).getFirst().toString()+"   "+vector.get(i).getSecond().toString());

        return vector;
    }


    public void wypiszZleceniaDruku() {
        System.out.println();
        for(int i=0;i<3;i++){
            wypiszZleceniaDrukuDlaDrukarni(i);
            System.out.println();
        }
    }
    private void wypiszZleceniaDrukuDlaDrukarni(Integer nrDrukarni) {
        System.out.println("Drukarnia "+((Integer)(nrDrukarni+1)).toString()+".:");
        Vector<Pair<Publikacja,Integer>> kolejka = drukarnie.get(nrDrukarni).getKolejkaDrukowania();
        for(int i=0;i<kolejka.size();i++){
            System.out.print("\t"+
                    Konsola.stalaSzerokosc("Ilość: "+kolejka.get(i).getSecond().toString(),12)+
                    kolejka.get(i).getFirst().toString());
        }
    }
}
