package Wydawnictwo;

import Data.DzienTygodniaExceptions.ZaDuzyDzienTygodniaException;
import Publikacje.Publikacja;
import Wydawnictwo.WydawnictwoThrowable.ZamowienieThrowable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DzialHandlowy implements Serializable {
    private Map<Publikacja,Float> cenyPublikacji;
    public DzialHandlowy(){
        cenyPublikacji = new HashMap<Publikacja,Float>();
    }


}
