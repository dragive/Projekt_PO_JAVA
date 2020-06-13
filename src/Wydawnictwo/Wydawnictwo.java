package Wydawnictwo;
import Autor.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Data.Data;
import Konsola.Konsola;
import Publikacje.Publikacja;


public class Wydawnictwo implements Serializable {
    private Magazyn magazyn;
    private DzialHandlowy sklep;
    private DzialDruku druk;
    public List<Autor> autorzy;
    private Data data;
    private List<Publikacja> publikacje;
    public Wydawnictwo(Data data){
        magazyn= new Magazyn();
        sklep = new DzialHandlowy();
        druk = new DzialDruku();
        autorzy= new ArrayList<Autor>();
        this.data= data;
        publikacje=new ArrayList<Publikacja>();
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
    public void wypiszWszystkieUmowy(){

        Iterator it = autorzy.iterator();
        Integer id=0;
        Autor autor;
        while(it.hasNext()){

            autor = (Autor) it.next();
            id=autor.wypiszKazdaUmowe((id));
        }
    }
    public Integer iloscWszystkichUmow(){
        Integer ilosc=0;
        Iterator it = autorzy.iterator();
        Integer id=0;
        Autor autor;
        while(it.hasNext()){

            autor = (Autor) it.next();
            ilosc+=autor.getUmowy().size();
        }
        return ilosc;
    }
    public void wypiszAktywneUmowy(){

        Iterator it = autorzy.iterator();
        Integer id=0;
        Autor autor;
        while(it.hasNext()){

            autor = (Autor) it.next();
            id=autor.wypiszAktywnaUmowe((id),data);
        }
    }
    public void zakonczUmowe(Integer ID){

        Iterator it = autorzy.iterator();
Integer i =0;
        Autor autor;
        while(it.hasNext()){

            autor = (Autor) it.next();
            i= autor.zakonczUmowe(i,ID);
        }

    }
    public void dodajPublikacje(Publikacja dzielo){
        publikacje.add(dzielo);
    }
    public List<Publikacja> getPublikacje(){return publikacje;}
    public void wypiszPublikacje(){
        for(Object a : publikacje){
            System.out.println(a.toString());
        }
    }
}
