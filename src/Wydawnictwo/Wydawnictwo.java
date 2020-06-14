package Wydawnictwo;
import Autor.*;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import Data.Data;
import Konsola.Konsola;
import Publikacje.Publikacja;
import Umowy.Umowa;
import Wydawnictwo.KlasyPomocnicze.Pair;

import javax.swing.*;


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
    /*public void usunAutora(Autor tworca){
        Iterator it = this.autorzy.iterator();
        while(it.hasNext()){
            if(it.next().equals(tworca))
            {
                it.remove();
            }
        }
    }*/
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
    public void wypiszAutor(){
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
        if(id==0){System.out.println("\nNie ma żadnych aktywnych umów.\n");}
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
        if(id==0){System.out.println("\nNie ma żadnych aktywnych umów.\n");}
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
    public Integer getIDAutora(String imieNazwisko){
        Integer ID=0;
        for(Autor a:this.autorzy){
            if(a.getImieNazwisko().equals(imieNazwisko)){return ID;}
            ID++;
        }
        return -1;
    }
    public void dodajUmoweDoAutora(Umowa umowa, String imieNazwisko){
        Integer ID=getIDAutora(imieNazwisko);
        Autor a;
        if(ID==-1){
            a=new Autor(imieNazwisko);
            a.dodajUmowe(umowa);
        }
        else{
            Iterator it = autorzy.iterator();
            while(it.hasNext()&&ID-->0){
                it.next();
            }
            ((Autor) it.next()).dodajUmowe(umowa);
        }

    }
    public List<Publikacja> getPublikacje(){return publikacje;}

    public void wypiszPublikacje(){
        if(publikacje.size()==0){System.out.println("\nW wydawnictwie nie ma zapisanych żadnych publikacji.\n");return;}

        for(Object a : publikacje){
            System.out.println(a.toString());
        }
    }
    public void wypiszPublikacjeZID(){
        if(publikacje.size()==0){System.out.println("\nW wydawnictwie nie ma zapisanych żadnych publikacji.\n");return;}
        Integer i=0;
        for(Object a : publikacje){
            System.out.println("ID: "+Konsola.stalaSzerokosc(i.toString(),4)+a.toString());
            i++;
        }
    }
    public Publikacja getPublikacja(Integer ID){
        Iterator it=publikacje.iterator();
        while(it.hasNext()&&(ID)>0){
            ID--;
            it.next();
        }
        return (Publikacja) it.next();
    }

    public void dodajZlecenieDrukuPublikacji(Publikacja publikacja,Integer ilosc,Integer drukarnia){
        druk.dodajZlecenieDrukuPublikacji(publikacja,ilosc,drukarnia);
    }
    public void wydajPolecenieDruku(){

        Vector <Pair<Publikacja,Integer>> vector= druk.wydajPolecenieWydruku();
        Integer ret = vector.size();
        magazyn.przyjmijPublikacjeZWydruku(vector);

        //return ret;
    }

    public void wypiszZleceniaDruku() {
        druk.wypiszZleceniaDruku();
    }

    public void wypiszStanMagazynu() {
        magazyn.wypiszStanMagazynu(publikacje);
    }

    public void ustawCenePublikacji(){
        wypiszPublikacjeZID();
        Integer dane;
        boolean ok;
        Float cena;

        String mess=("Podaj ID publikacji dla której chcesz ustalić cene: ");
        String komunikatOBledzie="\nNie istnnieje publikacja o takim ID. Prosze wprowadzić inne dane.\n";
        String mess1=("Podaj cene publikacji: ");
        String komunikatOBledzie1="\nPodawana jest nieprawidlowa cena.\n";

        ok=true;
        do {
            if(!ok)System.out.println(komunikatOBledzie);
            ok=true;
            dane=Konsola.pobierzInteger(mess, komunikatOBledzie + mess);
            if(dane<0||dane>=publikacje.size())ok=false;
        }while(!ok);

        Iterator it = publikacje.iterator();
        while(dane>0&&it.hasNext()){dane--; it.next();}


        ok=true;
        do {
            if(!ok)System.out.println(komunikatOBledzie1);
            ok=true;
            cena =Konsola.pobierzFloat(mess1, komunikatOBledzie1 + mess1);
            if(cena<0)ok=false;
        }while(!ok);
        sklep.setCena((Publikacja)it.next(),((float) Math.round((cena*100)/100)));
    }

    public void wypisaniePublikacjiZCenaIID() {
        sklep.wypisaniePublikacjiZCenaIID(publikacje);
    }
}
