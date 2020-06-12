package Wydawnictwo;
import Autor.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Data.Data;
import Konsola.Konsola;



public class Wydawnictwo implements Serializable {
    private Magazyn magazyn;
    private DzialHandlowy sklep;
    private DzialDruku druk;
    private List<Autor> autorzy;
    private Data data;
    public Wydawnictwo(Data data){
        magazyn= new Magazyn();
        sklep = new DzialHandlowy();
        druk = new DzialDruku();
        autorzy= new ArrayList<Autor>();
        this.data= data;
    }
    public void dodajAutora(Autor tworca){
        autorzy.add(tworca);
    }
    public void usunAutora(Autor tworca){
        Iterator it = this.autorzy.iterator();
        while(it.hasNext()){
            if(it.next().equals(tworca))
            {
                it.remove();
            }
        }
    }
    public void kolejnyDzien(){
        data.kolejnyDzien();
        Iterator it= autorzy.iterator();
        Autor x;
        while(it.hasNext()){
            x= (Autor) it.next();
            x.kolejnyDzien(data);
        }
    }
    public Data getData(){
        return data;
    }
    public void wypiszAutorzy(){
        if (autorzy.size()==0){
            System.out.println("\n\tW wydawnictwie nie ma zapisanych żadnych autorów.\n");
        }
        Integer id=0;
        Autor element;
        Iterator it = autorzy.iterator();
        while(it.hasNext()){
            element = (Autor) it.next();
            System.out.println("ID: "+ Konsola.stalaSzerokosc(id.toString(), 10) + "\t\t" + Konsola.stalaSzerokosc(element.toString(), 20));
            id++;
        }
    }

    public List<Autor> getAutorzy() {
        return autorzy;
    }
}
