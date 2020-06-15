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
import Wydawnictwo.MagazynExceptions.MagazynZaMaloPublikacjiDoWykonaniaZakupuException;
import Wydawnictwo.Wydawnictwo;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa służąca do obsługi klasy {@link Wydawnictwo}. Wprowadza finkcjonlaności interfejsu tekstowego.
 * @author MF
 */
public class Konsola implements Serializable{
 private Wydawnictwo wydawnictwo;

    /**
     * Wykonanie metody oznacza wczytanie danych z pliku i uruchomienie Menu Głównego.
     */
    public void startProgramu(){
        wczytajDane();
        String trescMenu="\n" +
                "[0] <- Wyjście z programu\n" +
                "[1] <- Zarządzanie autorami.\n" +
                "[2] <- Zarządzanie umowami.\n" +
                "[3] <- Zarządzanie publikacjami.\n" +
                "[4] <- Zarządzanie dzialem druku.\n" +
                "[5] <- Zarządzanie sklepem.\n" +
                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true)silnikMenuGlowne(menu(trescMenu,"menu główne"));
    }

    /**
     * Metoda obslugująca komendy podawane w parametrze dla Menu Głównego.
     * @param cmd
     */
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
                try{
                    zarzadzanieDzialemHandlowym();}catch (wyjscieZMenuThrowable th){}
                break;
            case "z":
                zapisObiektuDoPliku(wydawnictwo,"wyd.dat");
                break;

            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    /**
     * Metoda obslugująca komendy podawane w parametrze dla Menu Autorzy.
     * @param cmd
     */
    private void silnikMenuAutorzy(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                wypiszAutorow();
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
    /**
     * Metoda obslugująca komendy podawane w parametrze dla Menu Umowy.
     * @param cmd
     */
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

            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    /**
     * Metoda obslugująca komendy podawane w parametrze dla Menu Publikacje.
     * @param cmd
     */
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
    /**
     * Metoda obslugująca komendy podawane w parametrze Menu Dzialu Druku.
     * @param cmd
     */
    private void silnikMenuDzialDruku(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                dodajZlecenieDruku();
                break;
            case "2":
                wydajPolecenieWydruku();
                break;
            case "3":
                wypiszZleceniaDruku();
                break;
            case "4":
                wypiszStanMagazynu();
                break;
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }
    /**
     * Metoda obslugująca komendy podawane w parametrze dla Menu Działu Handlowego.
     * @param cmd
     */
    private void silnikMenuDzialHandlowy(String cmd) throws wyjscieZMenuThrowable {
        switch (cmd){
            case "0":
                if(true)throw new wyjscieZMenuThrowable();
                break;
            case "1":
                wyswietlStanSklepu();
                break;
            case "2":
                zakupSklep();
                break;
            case"3":
                wypisaniePublikacjiZCenaIID();
                break;
            case "4":
                definiowowanieCenyPublikacji();
            default:
                nieznanaKomenda(cmd);
                break;
        }
    }


    /**
     * Metoda wykonywana pod koniec działania programu. Zapisuje do pliku stan programu.
     */
    public void koniecProgramu(){
        zapisObiektuDoPliku(wydawnictwo,"wyd.dat");
        System.exit(0);
    }

    /**
     * Metoda
     * @param trescMenu
     * @param poziom
     * @return
     */
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

    public void wypiszPublikacje() {
        wydawnictwo.wypiszPublikacje();
    }
    public void wypiszPublikacjeZID() {

        wydawnictwo.wypiszPublikacjeZID();
    }
    public Publikacja utworzPublikacje(){
        Publikacja ret=null;
        String opcje="\n" +
                "[1] <- Utworzenie Książki.\n" +
                "[2] <- Utworzenie Tygodnika.\n" +
                "[3] <- Utworzenie Miesiecznika.\n\n";
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
            if(ret==null)wystapilBlad=true; else wystapilBlad=false;
            System.out.print(ret);
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

    public void dodajZlecenieDruku(){
        if(wydawnictwo.getPublikacje().size()==0){System.out.println("\nW wydawnictwie nie ma zapisanych publiakcji, więc nie można wybrać publikacji do druku\n" +
                "Należy dodać publikacje i następnie wydać zlecenie druku\n");return;}
        String mess="\nPodaj ID publikacji: ";
        String komunikatOBledzie="Nie ma takiej publikacji o takim ID. ";
        //System.out.println(mess);
        Integer ID;
        wypiszPublikacjeZID();
        boolean ok=true;
        do{
            if(!ok)System.out.println(komunikatOBledzie);
            ok=true;
            ID=pobierzInteger(mess,komunikatOBledzie+mess);
            if(ID<0||ID>=wydawnictwo.getPublikacje().size())ok=false;
        }while(!ok);

        Publikacja publ = wydawnictwo.getPublikacja(ID);

        mess="Podaj ilość do wydrukowania publikacji "+publ.getTytul()+": ";
        komunikatOBledzie="Ilość musi być większa od 0. ";
        Integer ilosc;
        ok=true;
        do{
            if(!ok)System.out.println(komunikatOBledzie);
            ok=true;
            ilosc=pobierzInteger(mess,komunikatOBledzie+mess);
            if(ilosc<=0)ok=false;
        }while(!ok);

        mess="Wybierz drukarnie, w której ma być drukowana publikacja.\n" +
                "ID: [1] Możliwość drukowania wszystkich publikacji.\n" +
                "ID: [2] Możliwość drukowania wszystkich publikacji za wyjątkiem ksiązek będących albumami.\n" +
                "ID: [3] Możliwość drukowania wszystkich publikacji za wyjątkiem ksiązek będących albumami.\n" +
                "\n" +
                "Podaj ID drukarni: ";
        komunikatOBledzie="Nie można wydrukować publikacji "+publ.getTytul()+" w tej drukarni tej publikacji lub nie istnieje taka drukarnia o takim ID. ";
        Integer drukarnia=0;
        ok=true;
        do{
            if(!ok)System.out.println(komunikatOBledzie);
            ok=true;
            drukarnia=pobierzInteger(mess,komunikatOBledzie+mess);
            if(drukarnia<1||drukarnia>3||(publ instanceof Ksiazka &&drukarnia!=1 && ((Ksiazka)publ).getGatunek().toLowerCase().contains("album")))ok=false;
        }while(!ok);

        wydawnictwo.dodajZlecenieDrukuPublikacji(publ,ilosc,drukarnia-1);
    }
    public void wydajPolecenieWydruku(){
        wydawnictwo.wydajPolecenieDruku();
    }
    public void wypiszZleceniaDruku(){wydawnictwo.wypiszZleceniaDruku();}

    public void wyswietlStanSklepu(){ wypiszStanMagazynu();}
    public void zakupSklep(){
        /*wypisz id ceny i publikacje
        * gdy to mozliwe czyli wyisauje sie wiecej niz 1 to koniec: nie mazkupu
        *
        * pobranie ID i ilosci do kskutku az bedzie mozna to zrobic i odjecie od magazynu*/
        Integer naklad;
        Integer ilosc = wypisaniePublikacjiZCenaIID();
        if(ilosc==0){
            System.out.println("Nie można zatem wykonac jakiegokolwiek zakupu.");
            return;
        }
        boolean ok=true;
        ok=true;
        String mess1 = "Podaj ID publikacji, która ba być zakupiona: ";
        String komunikatOBledzie1="Nie ma publikacji o takim ID. ";
        Integer ID;
        do{
            if(!ok)System.out.println(komunikatOBledzie1);
            ok=true;
            ID=pobierzInteger(mess1,komunikatOBledzie1+mess1);
            if(ID<0||ID>=ilosc){ok=false;}
        }while(!ok);

        Iterator it = wydawnictwo.getPublikacjeZCena().iterator();
        while(it.hasNext()&&ID>0){ID--;it.next();}
        Publikacja p=(Publikacja)it.next();

        boolean okglowny=true;
        do {
            ok = true;
            String mess2 = "Podaj ilosc egzemplarzy publikacji, które będą zakupione: ";
            String komunikatOBledzie2 = "Nie można zakupić takiej ilości publikacji. ";

            do {
                if (!ok) System.out.println(komunikatOBledzie2);
                ok = true;
                naklad = pobierzInteger(mess2, komunikatOBledzie2 + mess2);
                if (naklad < 0 && wydawnictwo.getMagazyn().sprawdzIloscPublikacjiWMagazynie(p) >= naklad) {
                    ok = false;
                }

                //System.out.println(wydawnictwo.getMagazyn().sprawdzIloscPublikacjiWMagazynie(p));
            } while (!ok);


           try{ okglowny = true;wydawnictwo.zakupPublikacji(p,naklad);}catch (MagazynZaMaloPublikacjiDoWykonaniaZakupuException ex){okglowny=false;}
           if(!okglowny){
               System.out.print("Za malo publikacji w magazynie by móc dokonać takiego zakupu.");
           }


        }while(!okglowny);



        System.out.println("Zakupiono publikacje za: "+wydawnictwo.getSklep().getCenaPublikacji(p)*naklad+" zł.");



    }
    public Integer wypisaniePublikacjiZCenaIID(){
       return  wydawnictwo.wypisaniePublikacjiZCenaIID();
    }
    public void wypiszStanMagazynu() {
        wydawnictwo.wypiszStanMagazynu();
    }
    public void definiowowanieCenyPublikacji() {
        wydawnictwo.ustawCenePublikacji();
    }


    public void zarzadzanieAutorami()throws wyjscieZMenuThrowable{
        String trescMenu="\n[0] <- Wyjście do menu głównego\n[1] <- Wypisanie autorów.\n[2] <- Dodanie autora\n[3] <- Usunięcie autora.\n\nWpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuAutorzy(menu(trescMenu,"zarządzanie autorami"));
        }
    }
    public void zarzadzanieUmowami()throws wyjscieZMenuThrowable{
        String trescMenu="\n" +
                "[0] <- Wyjście do menu głównego.\n" +
                "[1] <- Wypisanie szystkich umów.\n" +
                "[2] <- Wypisanie szystkich aktywych umów.\n" +
                "[3] <- Dodaj umowe.\n[4] <- Zakonczenie umowy.\n" +
                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuUmowy(menu(trescMenu,"zarządzanie umowami"));
        }
    }
    public void zarzadzaniePublikacjami()throws wyjscieZMenuThrowable{
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
    public void zarzadzanieDzialemDruku()throws wyjscieZMenuThrowable{
        String trescMenu="\n" +
                "[0] <- Wyjście do menu głównego\n" +
                "[1] <- Zlecenie druku danej ilości jednej z zapisanych publikacji.\n" +
                "[2] <- Polecenie wydruku.\n" +
                "[3] <- Wypisanie publikacji czekających do druku.\n" +
                "[4] <- Wypisanie zawartości magazynu z wydrukowanymi publikacjami.\n" +
                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuDzialDruku(menu(trescMenu,"zarządzanie dzialem druku"));
        }
    }
    public void zarzadzanieDzialemHandlowym()throws wyjscieZMenuThrowable{
        String trescMenu="\n" +
                "[0] <- Wyjście do menu głównego\n" +
                "[1] <- Wyświetlenie ilości publikacji gotowych do sprzedarzy.\n" +
                "[2] <- Wykonanie zakupu w sklepie.\n" +
                "[3] <- Wypisanie cen przypisanych do publikacji.\n" +
                "[4] <- Ustalanie ceny publikacji.\n" +

                "\n" +
                "Wpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuDzialHandlowy(menu(trescMenu,"zarządzanie sklepem i działem handlowym"));
        }
    }
    public void dodajUmowe()throws wyjscieZMenuThrowable{
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
    public void dodajUmoweOPrace(){

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
        ok=true;
        while(true) {
            if(!ok)System.out.println("\nData konca jest wcześniejsza niż data rozpoczęcia umowy. Proszę wprowadzić ponownie dane.\n");
            System.out.println("\nPodaj datę rozpoczęcia umowy.");
            dataR = pobierzDate();
            System.out.println("\nPodaj datę zakonczenia umowy.");
            dataZ = pobierzDate();
            if(dataR.jestWiekszaOd(dataZ)>0)ok=false;
            if(ok)break;
        }

        wydawnictwo.dodajUmoweDoAutora(new UmowaOPrace(dataR,dataZ),imieNazwisko);

    }
    public void dodajUmoweODzielo(){
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
        String wiadomoscK="Proszę podać kwotę jaką otrzyma autor za napisanie publikacji: ";
        String komunikatOBledzieK="Podane dane nie są poprawną kwotą. ";


        ok=true;
        do {
            if(!ok){System.out.println(komunikatOBledzieK);}
            kwota = pobierzFloat(wiadomoscK, komunikatOBledzieK+" "+wiadomoscK);
            if(kwota<0)ok=false;else ok=true;
        }while(!ok);



        Data dataR=null;//data rozpoczecia
        Data dataZ=null;//data zakonczenia
        ok=true;
        while(true) {
            if(!ok)System.out.println("\nData konca jest wcześniejsza niż data rozpoczęcia umowy. Proszę wprowadzić ponownie dane.\n");
            System.out.println("\nPodaj datę rozpoczęcia umowy.");
            dataR = pobierzDate();
            System.out.println("\nPodaj datę zakonczenia umowy.");
            dataZ = pobierzDate();
            if(dataR.jestWiekszaOd(dataZ)>0)ok=false;
            if(ok)break;
        }

        do{System.out.println("\nWybierz typ i podaj dane do utworzenia publikacji.\n");publ = utworzPublikacje();} //tod dodanie publikacji dodanie wyboru czy utworzyc publikacje czy wykorzystac wczesniej utworzona
        while(publ==null);
/*
        Iterator it = wydawnictwo.autorzy.iterator(),itPomocniczy=it;
        while(it.hasNext()){
            itPomocniczy=it;
            if(imieNazwisko.equals(( (Autor) (it.next())).getImieNazwisko() ) )break;
        }
            ((Autor) itPomocniczy.next()).dodajUmowe(new UmowaODzielo((float) Math.round(kwota*100)/100,dataR,dataZ,publ));*/
        wydawnictwo.dodajPublikacje(publ);
        wydawnictwo.dodajUmoweDoAutora(new UmowaODzielo((float) Math.round(kwota*100)/100,dataR,dataZ,publ),imieNazwisko);

    }
    public void zakonczUmowe(){
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

    public void dodajaAutora(){
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
    public void usunAutora(){
        if(wydawnictwo.getAutorzy().size()==0){System.out.println("\nNie ma żadnego autora do usunięcia.\n\n");return;}
        wypiszAutorow();
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
    public void wypiszAutorow(){wydawnictwo.wypiszAutor();}

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
