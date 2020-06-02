package Autor;

import java.util.List;

/**
 *
 * @author 
 */
public class Autor {
    protected String imienazwisko;
    private List<Umowa> lista_umow;
    lista_umow = new List<Umowa>();
    
    public Autor(String imienazwisko){
        this.imienazwisko = imienazwisko;
    }
    public String getImieNazwisko(){
        return imienazwisko;
    }
    public List<Umowa> getUmowy(){
        return lista_umow;
    }
    public void dodajUmowe(Umowa){
        lista_umow.add(Umowa);
    }
    
}
