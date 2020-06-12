package Wydawnictwo;


import Publikacje.Ksiazka;
import Publikacje.Publikacja;
import Wydawnictwo.WydawnictwoExceptions.ID_drukarniPozaZakresemException;
import Wydawnictwo.WydawnictwoExceptions.NiemozliwyDrukException;

import java.io.Serializable;


public class DzialDruku  implements Serializable {
    private Drukarnia[] drukarnie;
    private Drukarnia[] utworzDrukarnie(){
        Drukarnia lista [] =  {
                new Drukarnia(true),
                new Drukarnia(false),
                new Drukarnia(false)};
        return lista;
    }
    private static boolean czyAlbum(Publikacja dzielo){
        if(dzielo instanceof Ksiazka){
            Ksiazka ksiazka=(Ksiazka) dzielo;
            if(ksiazka.getGatunek().toLowerCase()=="album"){
                return true;
            }
        }
        return false;
    }

    public DzialDruku(){
        drukarnie=utworzDrukarnie();
    }
    public void zamow(Publikacja dzielo,int ilosc,int ID_drukarni) throws NiemozliwyDrukException, ID_drukarniPozaZakresemException {
        if(ID_drukarni<0||ID_drukarni>=drukarnie.length) throw new ID_drukarniPozaZakresemException();
        if(czyAlbum(dzielo)&& !drukarnie[ID_drukarni].getDrukAlbumow()){
            throw new NiemozliwyDrukException();
        }
        drukarnie[ID_drukarni].zamow(dzielo,ilosc);

    }

}
