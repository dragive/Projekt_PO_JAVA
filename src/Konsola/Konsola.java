package Konsola;

import Data.*;
import Autor.Autor;
import Data.DataExceptions.NieprawidlowyFormatDatyException;
import Data.DzienMiesiacaExceptions.NieprawidlowyDzienMiesiacaException;
import Data.DzienTygodniaExceptions.NieprawidlowyDzienTygodniaException;
import Konsola.KonsolaThrowable.wyjscieZMenuThrowable;
import Publikacje.Ksiazka;
import Publikacje.Miesiecznik;
import Publikacje.Publikacja;
import Publikacje.Tygodnik;
import Umowy.UmowaODzielo;
import Umowy.UmowaOPrace;
import Wydawnictwo.Wydawnictwo;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Konsola implements Serializable{
 private Wydawnictwo wydawnictwo;

    public void startProgramu(){
        wczytajDane();
        String trescMenu="\n" +
                "[0] <- Wyjście z programu\n" +
                "[1] <- Zarządzanie autorami.\n" +
                "[2] <- Zarządzanie umowami.\n" +
                "[3] <- Zarządzanie publikacjami.\n" +
                "*[4] <- Zarządzanie dzialem druku.\n" +
                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true)silnikMenuGlowne(menu(trescMenu,"menu główne"));
    }
    private void silnikMenuGlowne(String cmd){
        switch (cmd){
            case "0":
                koniecProgramu();
                break;
            case "9":
                wydawnictwo.kolejnyDzien();
                System.out.println();
                break;
            case "1":
                try{zarzadzanieAutorami();}catch (wyjscieZMenuThrowable th){}
                break;
            case "2":
                try{zarzadzanieUmowami();}catch (wyjscieZMenuThrowable th){}
                break;
            case "3":
                try{zarzadzaniePublikacjami();}catch (wyjscieZMenuThrowable th){}
                break;
            case "4":
                try{zarzadzanieDzialemDruku();}catch (wyjscieZMenuThrowable th){}
                break;
            case "5":
                try{zarzadzanieSklepem();}catch (wyjscieZMenuThrowable th){}
                break;
            case "z":
                zapisObiektuDoPliku(wydawnictwo,"wyd.dat");
                break;

            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    private void silnikMenuAutorzy(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                wydawnictwo.wypiszAutorzy();
                break;
            case "2":
                dodajaAutora();
                break;
            case "3":
                usunAutora();
                break;
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    private void silnikMenuUmowy(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                wydawnictwo.wypiszWszystkieUmowy();
                break;
            case "2":
                wydawnictwo.wypiszAktywneUmowy();
                break;
            case "3":
                 try{dodajUmowe();} catch (wyjscieZMenuThrowable th){}
                break;
            case "4":
                zakonczUmowe();
                break;
                /*
            case "5":
                usunUmowe();//#todo pass
                break;
                */
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    private void silnikMenuPublikacje(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                wypiszPublikacje();
                break;
            case "2":
                wydawnictwo.dodajPublikacje( utworzPublikacje());
                break;
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    private void silnikMenuDzialDruku(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                dodajZlecenieDruku();//#todo
                break;
            case "2":
                wypiszZleceniaDruku();//#todo
                break;
            case "3":
                drukujZlecenieDruku(); //#todo
                break;
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    private void silnikMenuSklep(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                wyswietlStanSklepu();//#todo
                break;
            case "2":
                zakupSklep();//#todo
                break;
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    public void koniecProgramu(){
        zapisObiektuDoPliku(wydawnictwo,"wyd.dat");
        System.exit(0);
    }

    public String menu(String trescMenu,String poziom){
        System.out.print(trescMenu+"\n("+poziom+", data: "+wydawnictwo.getData().toString()+")~~ ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public void nieznanaKomenda(String str){
        System.out.println("Podano nieznaną opcję: '"+str+"'");
    }
    public static String menu(String trescMenu){
        System.out.print(trescMenu);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static String menuL(String trescMenu){
        System.out.print(trescMenu);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void wypiszPublikacje(){
        wydawnictwo.wypiszPublikacje();
    }
    public Publikacja utworzPublikacje(){
        Publikacja ret=null;
        String opcje="" +
                "[1] <- dodanie Książki\n" +
                "[2] <- dodanie Tygodnika\n" +
                "[3] <- dodanie Miesiecznika\n\n";
        String komunikatOBledzie="Podano nieprawidłową wartość. Proszę wybrać jedną z powyższych opcji.\n";
        String cmd;
        boolean wystapilBlad;
        do{
            wystapilBlad=false;
            if(wystapilBlad) cmd=menu(komunikatOBledzie,"dodawanie publikacji");
            else cmd=menu(opcje,"dodawanie umowy");
            switch (cmd){
                case "1":
                     ret= ( utworzPublikacjeKsiazke());

                    break;
                case "2":
                    ret= ( utworzPublikacjeTygodnik());
                    break;
                case "3":
                    ret= ( utworzPublikacjeMiesiecznik());
                    break;
                default:
                    wystapilBlad=true;

            }

        }while(wystapilBlad);
        return ret;
    }
    public Ksiazka utworzPublikacjeKsiazke(){
        String tytul=pobierzString("Podaj tytuł książki: ","Za krótki tytuł ksiązki. Podaj ponownie tytuł gatunku książki: ",true);
        String imieNazwisko=pobierzString("Podaj imię i nazwisko autora książki: ","Wczytany ciąg znaków nie może być imieniem i nazwiskiem" +
                " autora, bo jest zakrótki ksiązki. Podaj ponownie imie i nazwisko autora książki: ",true);
        String gatunek=pobierzString("Podaj nazwę gatunku książki: ","Za krótki gatunek ksiązki. Podaj ponownie nazwę gatunku książki: ",true);

        if(!sprawdzCzyjestZapisanyAutor(imieNazwisko))wydawnictwo.dodajAutora(new Autor(imieNazwisko));
        return (new Ksiazka(tytul,gatunek,imieNazwisko));
    }
    public Tygodnik utworzPublikacjeTygodnik(){

        String tytul=pobierzString("Podaj tytuł tygodnika: ","Za krótki tytuł tygodnika. Podaj dłuższy tytuł miesiecznika: ",true);
        String imieNazwisko=pobierzString("Podaj imię i nazwisko autora Tygodznika: ","Wczytany ciąg znaków nie może być imieniem i nazwiskiem" +
                " autora, bo jest zakrótki ksiązki. Podaj ponownie imie i nazwisko autora Tygodnika: ",true);
        System.out.println("Podaj dzień druku tygodnika.");
        DzienTygodnia dt = pobierzDzienTygodnia();
        if(!sprawdzCzyjestZapisanyAutor(imieNazwisko))wydawnictwo.dodajAutora(new Autor(imieNazwisko));
        return (new Tygodnik(tytul,dt,imieNazwisko));
    }
    public Miesiecznik utworzPublikacjeMiesiecznik(){
        String tytul=pobierzString("Podaj tytuł miesiecznika: ","Za krótki tytuł miesiecznika. Podaj dłuższy tytuł miesiecznika: ",true);
        String imieNazwisko=pobierzString("Podaj imię i nazwisko autora Miesiecznika: ","Wczytany ciąg znaków nie może być imieniem i nazwiskiem" +
                " autora, bo jest zakrótki ksiązki. Podaj ponownie imie i nazwisko autora Miesiecznika: ",true);
        System.out.println("Podaj dzień druku miesiecznika.");
        DzienMiesiaca dt = pobierzDzienMiesiaca();
        if(!sprawdzCzyjestZapisanyAutor(imieNazwisko))wydawnictwo.dodajAutora(new Autor(imieNazwisko));
        return (new Miesiecznik(tytul,dt,imieNazwisko));
    }

    public void dodajZlecenieDruku(){}
    public void wypiszZleceniaDruku(){}
    public void drukujZlecenieDruku(){}

    public void wyswietlStanSklepu(){}
    public void zakupSklep(){}

    void zarzadzanieAutorami()throws wyjscieZMenuThrowable{
        String trescMenu="\n[0] <- Wyjście do menu głównego\n[1] <- Wypisanie autorów.\n[2] <- Dodanie autora\n[3] <- Usunięcie autora.\n\nWpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuAutorzy(menu(trescMenu,"zarządzanie autorami"));
        }
    }
    void zarzadzanieUmowami()throws wyjscieZMenuThrowable{
        String trescMenu="\n[0] <- Wyjście do menu głównego\n[1] <- Wypisanie szystkich umów.\n[2] <- Wypisanie szystkich aktywych umów.\n[3] <- Dodaj umowe.\n[4] <- Usuniecie umowy.\n\nWpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuUmowy(menu(trescMenu,"zarządzanie umowami"));
        }
    }
    void zarzadzaniePublikacjami()throws wyjscieZMenuThrowable{
        String trescMenu="\n" +
                "[0] <- Wyjście do menu głównego\n" +
                "[1] <- Wypisanie wszystkich publiakcji.\n" +
                "[2] <- Dodanie publikacji.\n" +

                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuPublikacje(menu(trescMenu,"zarządzanie publikacjami"));
        }
    }
    void zarzadzanieDzialemDruku()throws wyjscieZMenuThrowable{
        String trescMenu="\n" +
                "[0] <- Wyjście do menu głównego\n" +
                "[1] <- Wypisanie szystkich umów.\n" +
                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuDzialDruku(menu(trescMenu,"zarządzanie dzialem druku"));
        }
    }
    void zarzadzanieSklepem()throws wyjscieZMenuThrowable{
        String trescMenu="\n" +
                "[0] <- Wyjście do menu głównego\n" +
                "[1] <- Wypisanie szystkich umów.\n" +
                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuSklep(menu(trescMenu,"zarządzanie sklepem"));
        }
    }
    void dodajUmowe()throws wyjscieZMenuThrowable{
        String opcje="\n" +
                    "[0] <- Powrót do zarządzania umowami\n" +
                    "[1] <- Dodanie umowy o prace\n" +
                    "[2] <- Dodanie umowy o dzielo\n" +
                    "\n";
        String komunikatOBledzie="Podano nieprawidłową wartość. Proszę wybrać jedną z powyższych opcji.\n";
        String cmd;
        boolean wystapilBlad;
        do{
            wystapilBlad=false;
            if(wystapilBlad) cmd=menu(komunikatOBledzie,"dodawanie umowy");
            else cmd=menu(opcje,"dodawanie umowy");
            switch (cmd){
                case "1":
                    dodajUmoweOPrace();
                    break;
                case "2":
                    dodajUmoweODzielo();
                    break;
                case "0":
                    if(true)throw new wyjscieZMenuThrowable();
                    break;

                default:

            }

        }while(wystapilBlad);
    }
    void dodajUmoweOPrace(){
        //do ktorego autora ma byc przypisana
        /*String wiadomosc="Proszę podać ID autora, z którym podspisywana jest umowa: ";
        String komunikatOBledzie="Nie istnieje autor o takim ID.";

        Integer ID;
        boolean ok=true;
        do {
            if(!ok){System.out.println(komunikatOBledzie);}
            ID = pobierzInteger(wiadomosc, komunikatOBledzie+" "+wiadomosc);
            if(ID<wydawnictwo.autorzy.size()&&ID>-1)ok=true;else ok=false;
        }while(!ok);
        //dodanie konkretnej umowy*/
        String wiadomosc="Proszę podać imię i nazwisko autora, z którym podspisywana jest umowa, i zatwierdź \"enterem\": ";
        String komunikatOBledzie="Imię i nazwisko autora jest za krótkie.";

        String imieNazwisko=null;
        boolean ok=true;
        do {
            if(!ok){System.out.println(komunikatOBledzie);}
            imieNazwisko = pobierzString(wiadomosc, komunikatOBledzie+" "+wiadomosc,true);
            if(imieNazwisko.length()>0)ok=true; else ok=false;
        }while(!ok);
        //dodanie konkretnej umowy
        if(!sprawdzCzyjestZapisanyAutor(imieNazwisko))wydawnictwo.dodajAutora(new Autor(imieNazwisko));
        Data dataR=null;//data rozpoczecia
        Data dataZ=null;//data zakonczenia
        System.out.println("Podaj datę rozpoczęcia umowy.");
        dataR=pobierzDate();
        System.out.println("Podaj datę zakonczenia umowy.");
        dataZ=pobierzDate();

        Iterator it = wydawnictwo.autorzy.iterator(),itPomocniczy=null;
        while(it.hasNext()){
            itPomocniczy=it;
            if(imieNazwisko.equals(( (Autor) (it.next())).getImieNazwisko() ) )break;
        }
        ((Autor) itPomocniczy.next()).dodajUmowe(new UmowaOPrace(dataR,dataZ));

    }
    void dodajUmoweODzielo(){
        Publikacja publ=null;
        Float kwota;
        boolean ok=true;

        String wiadomosc="Proszę podać imię i nazwisko autora, z którym podspisywana jest umowa, i zatwierdź \"enterem\": ";
        String komunikatOBledzie="Imię i nazwisko autora jest za krótkie.";

        String imieNazwisko=null;

        do {
            if(!ok){System.out.println(komunikatOBledzie);}
            imieNazwisko = pobierzString(wiadomosc, komunikatOBledzie+" "+wiadomosc,true);
            if(imieNazwisko.length()>0)ok=true; else ok=false;
        }while(!ok);
        String wiadomoscK="Proszę podać kwotęjaką otrzyma autor za napisanie publikacji: ";
        String komunikatOBledzieK="Podane dane nie są poprawną kwotą. ";


        ok=true;
        do {
            if(!ok){System.out.println(komunikatOBledzieK);}
            kwota = pobierzFloat(wiadomoscK, komunikatOBledzieK+" "+wiadomoscK);
            if(kwota<0)ok=false;else ok=true;
        }while(!ok);



        Data dataR=null;//data rozpoczecia
        Data dataZ=null;//data zakonczenia
        System.out.println("Podaj datę rozpoczęcia umowy.");
        dataR=pobierzDate();
        System.out.println("Podaj datę zakonczenia umowy.");
        dataZ=pobierzDate();

        publ = utworzPublikacje(); //tod dodanie publikacji dodanie wyboru czy utworzyc publikacje czy wykorzystac wczesniej utworzona


        Iterator it = wydawnictwo.autorzy.iterator(),itPomocniczy=null;
        while(it.hasNext()){
            itPomocniczy=it;
            if(imieNazwisko.equals(( (Autor) (it.next())).getImieNazwisko() ) )break;
        }
            ((Autor) itPomocniczy.next()).dodajUmowe(new UmowaODzielo((float) Math.round(kwota*100)/100,dataR,dataZ,publ));
    }
    void zakonczUmowe(){
        String message = "Podaj ID publikacji do usuniecia: ";
        String komunikat = "Nie ma takiej umowy o takim ID. ";
        Integer ID=null;
        boolean ok=true;
        do{
            if(!ok){System.out.println(komunikat);}
            ok=true;
            ID=pobierzInteger(message,komunikat+message);
            if(ID<wydawnictwo.iloscWszystkichUmow()&&ID>0)
                ok=false;

        }while(!ok);

        wydawnictwo.zakonczUmowe(ID);

    }

    private void dodajaAutora(){
        String imienazwisko,message;
        boolean first=false;
        do{
            if(first){message=("Imię i nazwisko autora nie może być tak krótkie. Proszę wpisać inną wartość.");}
            else{message=("Proszę podać imię i nazwisko autora odzielona spacją i zatwierdzić \"enterem\"");}
            System.out.println(message);
            first=true;
            Scanner scanner = new Scanner(System.in);
            imienazwisko=scanner.nextLine();
        }while(imienazwisko.length()==0);
        wydawnictwo.dodajAutora(new Autor(imienazwisko));
    }
    private void usunAutora(){
        System.out.print("Podaj id autora by go usunąć: ");
        int maxIdautora=wydawnictwo.autorzy.size();
        if(maxIdautora==0){System.out.println("Nie można usunąć żadnego autora, z powodu braku autorów.\n");return;}
        Scanner scanner = new Scanner(System.in);
        String wejscie;
        int indexDoUsuniecia=-1;
        boolean dalejWczytywac=false;
        do {
            dalejWczytywac=false;
            wejscie=scanner.nextLine();
            try{

                indexDoUsuniecia = Integer.parseInt(wejscie);

            }catch (NumberFormatException ex){
                dalejWczytywac=true;
               // ex.printStackTrace();
            }
            if(dalejWczytywac){System.out.print("Wpisywana wartość musi być dodatnią liczbą całkowitą. Prosze na nowo wprowadzić dane: ");}
        }while(dalejWczytywac);
        Integer id=0;
        Autor element;
        Iterator it = wydawnictwo.autorzy.iterator(),t;
        boolean usunieto=false;
        while(it.hasNext()){
            t=it;
            element = (Autor) it.next();
            if(id==indexDoUsuniecia){usunieto=true;it.remove();break;}
            id++;
        }
        if(!usunieto) System.out.println("\nNie usunięto żadnego autora, ponieważ nie ma takiego autora o takim ID.");
        else          System.out.println("\nPoprawnie usunięto autora.");
    }

    public boolean sprawdzCzyjestZapisanyAutor(String imieNazwisko){
        List<Autor> lista = wydawnictwo.getAutorzy();
        for (Autor t : lista){
            if(t.getImieNazwisko().equals(imieNazwisko))return true;
        }
return false;
    }

    public static void zapisObiektuDoPliku(Wydawnictwo o, String nazwaPliku){
        try{
            FileOutputStream outFile = new FileOutputStream(nazwaPliku);
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            objOut.writeObject(o);
            outFile.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static Object odczytObiektuZPliku(String nazwaPliku) throws IOException, ClassNotFoundException {
        Object ret=null;

            FileInputStream inFile = new FileInputStream(nazwaPliku);
            ObjectInputStream objIn = new ObjectInputStream(inFile);
            ret=objIn.readObject();
            inFile.close();


        return ret;

    }

    public void wczytajDane(){
        try{wydawnictwo=(Wydawnictwo) odczytObiektuZPliku("wyd.dat");}
        catch (IOException | ClassNotFoundException exception){
                wydawnictwo= new Wydawnictwo(new Data(2020,6,12));
        }

    }
    public static String stalaSzerokosc(String wiadomosc, int szerokosc){
        String str="";
        for(int i=0;i<szerokosc-wiadomosc.length();i++){
            str+=" ";
        }
        return wiadomosc+str;
    }
    public static Data pobierzDate(){
        boolean dataNiepoprawna=false;Data ret=null;
        do {
            try {


                Integer rok = 0, miesiac = 0, dzien = 0;
                String komunikatOBledzie = "Podano nieprawidłową wartość daty. Data ta nie występuje w kalendarzu. Wprowadz dane ponownie";
                String cmd;
                if(dataNiepoprawna)System.out.println(komunikatOBledzie);
                dataNiepoprawna=false;
                boolean wystapilBlad = false;
                do {

                    try {

                        if (wystapilBlad) {
                            cmd = menu("Niepoprawna wartosc roku. Proszę wpisać inną wartosc: ");
                        } else cmd = menu("Proszę podać rok daty: ");
                        rok = Integer.parseInt(cmd);
                        wystapilBlad = false;
                    } catch (NumberFormatException ex) {
                        wystapilBlad = true;
                    }

                } while (wystapilBlad);
                ////////////////////////
                wystapilBlad = false;
                do {

                    try {

                        if (wystapilBlad) {
                            cmd = menu("Niepoprawna wartosc miesiaca. Proszę wpisać inną wartosc: ");
                        } else cmd = menu("Proszę podać miesiac daty: ");
                        miesiac = Integer.parseInt(cmd);
                        wystapilBlad = false;
                    } catch (Exception ex) {
                        wystapilBlad = true;
                    }

                } while (wystapilBlad);
                ////////////////////////
                wystapilBlad = false;
                do {

                    try {

                        if (wystapilBlad) {
                            cmd = menu("Niepoprawna wartosc dnia. Proszę wpisać inną wartosc: ");
                        } else cmd = menu("Proszę podać dzien daty: ");
                        dzien = Integer.parseInt(cmd);
                        wystapilBlad = false;
                    } catch (Exception ex) {
                        wystapilBlad = true;
                    }

                } while (wystapilBlad);

                ret = new Data(rok, miesiac, dzien);
                ret.sprawdzData();
            } catch(NieprawidlowyFormatDatyException ex){dataNiepoprawna=true;}
        }while(dataNiepoprawna);
        return ret;
    }
    public static Integer pobierzInteger(String wiadomosc,String komunikatOBledzie) {
        String id;
        Integer ID=null;
        boolean ok = true;
        do {
            try {
                if (ok)
                    id = menu(wiadomosc);
                else {
                    id = menu(komunikatOBledzie);
                }
                ok=true;
                ID = Integer.parseInt(id);
            } catch (NumberFormatException ex) {
                ok = false;
            }
        } while (!ok);
        return ID;
    }
    public static Float pobierzFloat(String wiadomosc,String komunikatOBledzie) {
        String id;
        Float ID=null;
        boolean ok = true;
        do {
            try {
                if (ok)
                    id = menu(wiadomosc);
                else {
                    id = menu(komunikatOBledzie);
                }
                ok=true;
                ID = Float.parseFloat(id);


            } catch (NumberFormatException ex) {
                ok = false;
            }
        } while (!ok);
        return ID;
    }
    public static String pobierzString(String wiadomosc,String komunikatOBledzie, boolean wczytywanieCalejLinii) {
        String id=null;
        boolean ok = true;
        do {
            try {
                if (ok)
                    if(wczytywanieCalejLinii)
                        id = menuL(wiadomosc);
                    else
                        id = menu(wiadomosc);
                else {
                    if(wczytywanieCalejLinii)
                        id = menuL(komunikatOBledzie);
                    else
                        id = menu(komunikatOBledzie);

                }
                ok=true;
                if(id.length()==0)ok=false;
            } catch (NumberFormatException ex) {
                ok = false;
            }
        } while (!ok);
        return id;
    }

    public  static DzienTygodnia pobierzDzienTygodnia(){
        boolean dataNiepoprawna=false;DzienTygodnia ret=null;
        do {
            try {


                Integer dzien = 0;
                String komunikatOBledzie = "Podano nieprawidłową wartość dla dnia tygodnia. Wprowadz dane ponownie";
                String cmd;
                if(dataNiepoprawna)System.out.println(komunikatOBledzie);
                dataNiepoprawna=false;
                boolean wystapilBlad = false;
                do {

                    try {

                        if (wystapilBlad) {
                            cmd = menu("Niepoprawna wartosc dnia tygodnia.\nProszę wpisać wartosc od 1 (poniedziałek) do 7 (niedziela) włącznie: ");
                        } else cmd = menu("Proszę podać wartość dla dnia tygodnia od 1 (poniedziałek) do 7 (niedziela): ");
                         dzien = Integer.parseInt(cmd);
                         DzienTygodnia.sprawdzPoprawnoscDniaTygodnia(dzien);
                        wystapilBlad = false;
                    } catch (NumberFormatException | NieprawidlowyDzienTygodniaException ex) {
                        wystapilBlad = true;
                    }

                } while (wystapilBlad);


                ret = new DzienTygodnia(dzien);
                ret.sprawdzPoprawnoscDniaTygodnia();
            } catch(NieprawidlowyDzienTygodniaException ex){dataNiepoprawna=true;}
        }while(dataNiepoprawna);
        return ret;
    }
    public  static DzienMiesiaca pobierzDzienMiesiaca(){
        boolean dataNiepoprawna=false;DzienMiesiaca zwracanaWartosc=null;
        do {
            try {


                Integer dzien = 0;
                String komunikatOBledzie = "Podano nieprawidłową wartość dla dnia miesiąca. Wprowadz dane ponownie";
                String wejscie;
                if(dataNiepoprawna)System.out.println(komunikatOBledzie);
                dataNiepoprawna=false;
                boolean wystapilBlad = false;
                do {

                    try {

                        if (wystapilBlad) {
                            wejscie = menu("Niepoprawna wartosc dnia miesiąca.\nProszę wpisać wartosc od 1 do 31 włącznie: ");
                        } else wejscie = menu("Proszę podać wartość dla dnia miesiąca od 1 do 31: ");
                        dzien = Integer.parseInt(wejscie);
                        DzienMiesiaca.sprawdzPoprawnoscDniaMiesiaca(dzien);
                        wystapilBlad = false;
                    } catch (NumberFormatException | NieprawidlowyDzienMiesiacaException ex) {
                        wystapilBlad = true;
                    }

                } while (wystapilBlad);


                zwracanaWartosc = new DzienMiesiaca(dzien);
                zwracanaWartosc.sprawdzPoprawnoscDniaMiesiaca();
            } catch(NieprawidlowyDzienMiesiacaException ex){dataNiepoprawna=true;}
        }while(dataNiepoprawna);
        return zwracanaWartosc;
    }


}
