package Wydawnictwo;

import Konsola.Konsola;
import Publikacje.Publikacja;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DzialHandlowy implements Serializable {
    private Map<Publikacja,Float> cenyPublikacji;
    public DzialHandlowy(){
        cenyPublikacji = new HashMap<Publikacja,Float>();
    }
    public void setCena(Publikacja publ,Float cena){
        cenyPublikacji.put(publ,cena);
    }
    public Integer wypisaniePublikacjiZCenaIID(List<Publikacja>publikacjeLista,Magazyn magazyn){
        Integer ID=0;
        if(cenyPublikacji.size()==0){System.out.println("Nie ustalono ceny dla żandej publikacji.");return 0;}
        for(Publikacja publ : publikacjeLista){
            if(cenyPublikacji.get(publ)==null)continue;
            System.out.println(
                            "ID: "+ Konsola.stalaSzerokosc(ID.toString(),9)+
                            "Cena: "+Konsola.stalaSzerokosc( cenyPublikacji.get(publ).toString(),8)+
                            "Dostepna ilość: "+ Konsola.stalaSzerokosc(magazyn.sprawdzIloscPublikacjiWMagazynie(publ).toString(),6)+
                            publ.toString());
            ID++;
        }
        return ID;
    }
    public Float getCenaPublikacji(Publikacja publ){
        return cenyPublikacji.get(publ);
    }


    public List<Publikacja> getPublikacjeZCena(List<Publikacja> publikacjeLista) {
        Integer ID=0;
        List <Publikacja> ret = new ArrayList<Publikacja>();
        if(cenyPublikacji.size()==0){;return ret;}
        for(Publikacja publ : publikacjeLista){
            if(cenyPublikacji.get(publ)==null)continue;
            ret.add(publ);
            ID++;
        }
        return ret;
    }
}
