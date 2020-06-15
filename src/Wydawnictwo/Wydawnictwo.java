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
import Wydawnictwo.MagazynExceptions.MagazynZaMaloPublikacjiDoWykonaniaZakupuException;

import javax.swing.*;

/**
 * Klasa opisująca działanie wydawnictwa
 */
public class Wydawnictwo implements Serializable {
    /**
     * Prywatne pole klasy Wydawnictwo. Przechowuje informacje o magazynie
     */
    private Magazyn magazyn;
    /**
     * Prywatne pole klasy Wydawnictwo. Przechowuje informacje o Dziale Handlowym
     */
    private DzialHandlowy sklep;
    /**
     * Prywatne pole klasy Wydawnictwo. Przechowuje informacje o Dziale Druku
     */
    private DzialDruku druk;
    /**
     * Prywatne pole klasy Wydawnictwo. Przechowuje informacje o autorach
     */
    public List<Autor> autorzy;
    /**
     * Prywatne pole klasy Wydawnictwo. Przechowuje informacje o aktualnej dacie
     */
    private Data data;
    /**
     * Prywatne pole klasy Wydawnictwo. Przechowuje informacje o publikacjach
     */
    private List<Publikacja> publikacje;

    /**
     * Publiczny konstruktor klasy Wydawnictwo
     * @param data
     */
    public Wydawnictwo(Data data){
        magazyn= new Magazyn();
        sklep = new DzialHandlowy();
        druk = new DzialDruku();
        autorzy= new ArrayList<Autor>();
        this.data= data;
        publikacje=new ArrayList<Publikacja>();
    }

    /**
     * Metoda wykorzystywana do dodawnaia autora do listy Autorów zapisanych w wydawnictwie
     * @param tworca twórca który będzie dodany do listy autorów
     */
    public void dodajAutora(Autor tworca){
        autorzy.add(tworca);
    }

    /**
     * Metoda wykonywana, gdy ma nastąpić kolejny dzień w wydawnictwie
     */
    public void kolejnyDzien(){
        data.kolejnyDzien();
        Iterator it= autorzy.iterator();
        Autor x;
        while(it.hasNext()){
            x= (Autor) it.next();
            x.kolejnyDzien(data);
        }
    }

    /**
     * metoda slużąca do pobrania aktualnej daty w wydawnictwie
     * @return Zwracana jest aktualna data
     */
    public Data getData(){
        return data;
    }

    /**
     * Zwraca obiekt magazynu podlegającego pod wydawnictwo
     * @return Zwracany jest obiekt magazynu podelgający pod wydawnictwo
     */
    public Magazyn getMagazyn(){return magazyn;}

    /**
     * Metoda służąca do wypisywania autorów zapisanych w wydawnictwie na ekranie
     */
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

    /**
     * Metoda służąca do pobrania obiektu sklepu
     * @return Zwraca obiekt  klasy DzialHandlowy zapisany w wydawnictwie jako pole o nazwie sklep
     */
    public DzialHandlowy getSklep(){return sklep;}

    /**
     * Getter listy Autorów
     * @return Zwraca listę autorów
     */
    public List<Autor> getAutorzy() {
        return autorzy;
    }

    /**
     * Metoda służąca do wypisania wszystkich umów zawartych z jakimikolwiek autorami
     */
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

    /**
     * Metoda słuząca do pozyskania liczby umów zawartych z autorami
     * @return Zwraca liczbę umów zawartych z autorami
     */
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

    /**
     * Metoda służąca do wypisania aktywnych umów.
     */
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

    /**
     * Metoda wprowadzająca możliwość zakonczenia i rozwiazania umowy z danym autorem.
     * @param ID Numer umowy w liście do zakończenia
     */
    public void zakonczUmowe(Integer ID){

        Iterator it = autorzy.iterator();
Integer i =0;
        Autor autor;
        while(it.hasNext()){

            autor = (Autor) it.next();
            i= autor.zakonczUmowe(i,ID);
        }

    }

    /**
     * Metoda służąca do dodanie publiakcji do listy zapisanych wczensiej publikacji w wydawnictwie
     * @param dzielo Publikacja, która ma być dodana do listy publikacji w wydawnictwie
     */
    public void dodajPublikacje(Publikacja dzielo){
        publikacje.add(dzielo);
    }

    /**
     * Metoda służąca do określenia ID autora na liście z autorami
     * @param imieNazwisko Imie i nazwisko autora, dla którego ma być okreslone ID
     * @return ID autora w liście z autorami w wydwanictwie
     */
    public Integer getIDAutora(String imieNazwisko){
        Integer ID=0;
        for(Autor a:this.autorzy){
            if(a.getImieNazwisko().equals(imieNazwisko)){return ID;}
            ID++;
        }
        return -1;
    }

    /**
     * Dodanie Umowy do konkretnego autora
     * @param umowa Umowa, która ma być dodana do autora
     * @param imieNazwisko Imie i nazwisko autora, do którego ma być dopisana umowa
     */
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

    /**
     * Publiczny Getter listy publikacji zapisanych w wydawnictwie
     * @return Lista z zapisanymi publikacjami w wydawnictwie
     */
    public List<Publikacja> getPublikacje(){return publikacje;}

    /**
     * Metoda służąca do wypisywania wszystkich zapisanych publikacji w wydawnictwie
     */
    public void wypiszPublikacje(){
        if(publikacje.size()==0){System.out.println("\nW wydawnictwie nie ma zapisanych żadnych publikacji.\n");return;}

        for(Object a : publikacje){
            System.out.println(a.toString());
        }
    }

    /**
     * Metoda służąca do wypisywania wszystkich zapisanych publikacji w wydawnictwie wraz z ich ID w liście
     */
    public void wypiszPublikacjeZID(){
        if(publikacje.size()==0){System.out.println("\nW wydawnictwie nie ma zapisanych żadnych publikacji.\n");return;}
        Integer i=0;
        for(Object a : publikacje){
            System.out.println("ID: "+Konsola.stalaSzerokosc(i.toString(),4)+a.toString());
            i++;
        }
    }

    /**
     * Pobranie publikacji z listy publikacji zapisanych w wydawnictwie
     * @param ID pozycja w liście danej publikacji
     * @return Zwracana jest publiakcja stojąca na danej podanej w parametrze pozycji
     */
    public Publikacja getPublikacja(Integer ID){
        Iterator it=publikacje.iterator();
        while(it.hasNext()&&(ID)>0){
            ID--;
            it.next();
        }
        return (Publikacja) it.next();
    }

    /**
     * Metoda służąca do dodania zlecenia druku konkretnej publikacji do konkretnej drukarni.
     * @param publikacja Publikacja, która będzie drukowana
     * @param ilosc nakład drukowanej publikacji
     * @param drukarnia ID drukarni, w której ma się odbyć druk
     */
    public void dodajZlecenieDrukuPublikacji(Publikacja publikacja,Integer ilosc,Integer drukarnia){
        druk.dodajZlecenieDrukuPublikacji(publikacja,ilosc,drukarnia);
    }

    /**
     * Wydanie polecenia wydruku we wszystkich drukarniach na raz
     */
    public void wydajPolecenieDruku(){

        Vector <Pair<Publikacja,Integer>> vector= druk.wydajPolecenieWydruku();
        Integer ret = vector.size();

        magazyn.przyjmijPublikacjeZWydruku(vector);


    }

    /**
     * Metoda służąca do wypisania wszystkich zlecen druku w poszczegołnych drukarniach
     */
    public void wypiszZleceniaDruku() {
        druk.wypiszZleceniaDruku();
    }

    /**
     * Metoda wypisaująca stan ,agazynu w wydawnictwie
     */
    public void wypiszStanMagazynu() {
        magazyn.wypiszStanMagazynu(publikacje);
    }

    /**
     * Metoda służąca definicji ceny publikajcji w sklepie wydawnictwa
     */
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

    /**
     * Metoda relizująca zmniejszenie stanu magazynu w wydawnictwie o dana ilosc danych publikacji
     * @param publ publikacja, dla której ma być zminiejszony stan w magazynie
     * @param ilosc ilość, o którą ma zmniejszyć się stan danej publikacji w magazynie
     * @throws MagazynZaMaloPublikacjiDoWykonaniaZakupuException Wyjątek podnoszony, gdy nie ma wsytarczającej ilości danej publiakcji by zrealizować to działanie
     */
    public void zakupPublikacji(Publikacja publ,Integer ilosc) throws MagazynZaMaloPublikacjiDoWykonaniaZakupuException {
        magazyn.zmniejszenieStanuMagazynu(publ,ilosc);
    }

    /**
     * Metoda służąca do wypisania Publikacji z cenami i ich ID
     * @return Zwracana jest wartość ile jest publikajci wypisaywanych i posaidających cene
     */
    public Integer wypisaniePublikacjiZCenaIID() {
        return sklep.wypisaniePublikacjiZCenaIID(publikacje,magazyn);
    }

    /**
     * Metoda służąca do zwrócenia listy publikacji zawierających cene
     * @return Zwracana jest lista publikacji zawierających cene
     */
    public List<Publikacja> getPublikacjeZCena() {
        /*todo debug usunac if(publikacje.get(0)==sklep.getPublikacjeZCena(publikacje))System.out.println("123123123");*/
        return sklep.getPublikacjeZCena(publikacje);
    }
}
