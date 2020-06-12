package Konsola;

import Data.Data;
import Autor.Autor;
import Konsola.KonsolaThrowable.wyjscieZMenuThrowable;
import Wydawnictwo.Wydawnictwo;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Konsola implements Serializable{
 private Wydawnictwo wydawnictwo;


    private void silnikMenuGlowne(String cmd){
        switch (cmd){
            case "zakoncz":
            case "q":
            case "0":
                koniecProgramu();
                break;
            case "kolejnydzien":
            case "9":
                wydawnictwo.kolejnyDzien();
                System.out.println();
                break;
            case "zarzadzanieAutorami":
            case "za":
            case "1":
                try{zarzadzanieAutorami();}catch (wyjscieZMenuThrowable th){}
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
    public void koniecProgramu(){
        zapisObiektuDoPliku(wydawnictwo,"wyd.dat");
        System.exit(0);
    }
    public void nieznanaKomenda(String str){
        System.out.println("Podano nieznaną komendę: '"+str+"'");
    }
    public String menu(String trescMenu,String poziom){
        System.out.print(trescMenu+"\n("+poziom+", data: "+wydawnictwo.getData().toString()+")~~ ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void startProgramu(){
        wczytajDane();
        String trescMenu="\n[0] <- Wyjście z programu\n[1] <- Zarządzanie aktorami.\n\nWpisz numer opcji i zatwierdź \"enterem\"";
        while(true)silnikMenuGlowne(menu(trescMenu,"menu główne"));
    }

    void zarzadzanieAutorami()throws wyjscieZMenuThrowable{
        String trescMenu="\n[0] <- Wyjście do menu głównego\n[1] <- Wypisanie aktorów.\n[2] <- Dodanie aktora\n[3] <- Usunięcie aktora.\n\nWpisz numer opcji i zatwierdź \"enterem\"";
        while(true){
            silnikMenuAutorzy(menu(trescMenu,"zarządzanie autorami"));
        }
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
        int maxIdAktora=wydawnictwo.getAutorzy().size();
        if(maxIdAktora==0){System.out.println("Nie można usunąć żadnego autora, z powodu braku autorów.\n");return;}
        Scanner scanner = new Scanner(System.in);
        String wejscie;
        int indexDoUsuniecia=-1;
        boolean dalejWczytywac=false;
        do {
            dalejWczytywac=false;
            wejscie=scanner.nextLine();
            System.out.println("#"+wejscie+"#");
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
        Iterator it = wydawnictwo.getAutorzy().iterator(),t;
        while(it.hasNext()){
            t=it;
            element = (Autor) it.next();
            if(id==indexDoUsuniecia){t.remove();break;}
            id++;
        }
        //#todo komunikat o popranym usunieciu

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
    public static Object odczytObiektuZPliku(String nazwaPliku) throws IOException, ClassNotFoundException,FileNotFoundException {
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

}
