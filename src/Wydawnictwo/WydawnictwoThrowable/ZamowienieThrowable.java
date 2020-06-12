package Wydawnictwo.WydawnictwoThrowable;


import Publikacje.Publikacja;

public class ZamowienieThrowable extends Throwable{
    private Publikacja publikacja;
    private int ilosc;
    public ZamowienieThrowable(Publikacja dzielo,int ilosc){super();this.publikacja=dzielo;this.ilosc=ilosc;}

    public int getIlosc() {
        return ilosc;
    }

    public Publikacja getPublikacja() {
        return publikacja;
    }
}
