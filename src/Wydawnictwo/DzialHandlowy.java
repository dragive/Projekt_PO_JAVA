package Wydawnictwo;

import Konsola.Konsola;
import Publikacje.Publikacja;
import java.io.Serializable;
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
    public void wypisaniePublikacjiZCenaIID(List<Publikacja>publikacjeLista){
        Integer ID=0;
        if(cenyPublikacji.size()==0){System.out.println("Nie ustalono ceny dla żandej publikacji.\n");return;}
        for(Publikacja publ : publikacjeLista){
            if(cenyPublikacji.get(publ)==null)continue;
            System.out.println(
                            "ID: "+ Konsola.stalaSzerokosc(ID.toString(),9)+
                            cenyPublikacji.get(publ).toString()+
                            publ.toString());
            ID++;
        }
    }


}
