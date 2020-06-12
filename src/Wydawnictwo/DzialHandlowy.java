package Wydawnictwo;

import Data.DzienTygodniaExceptions.ZaDuzyDzienTygodniaException;
import Publikacje.Publikacja;
import Wydawnictwo.WydawnictwoThrowable.ZamowienieThrowable;

import java.io.Serializable;

public class DzialHandlowy implements Serializable {
    public DzialHandlowy(){}
    public void zakup(Publikacja dzielo,int ilosc) throws ZamowienieThrowable {
        throw new ZamowienieThrowable(dzielo,ilosc);
    }
}
