import Umowy.Umowa;

import java.util.ArrayList;
import java.util.List;
/**
 * Klasa opisująca autorów publikacji (zobacz też: {@link Publikacje.Publikacja}).
 * @author ACH i MF
 */
class Autor {
    /**
     * Prywatne pole obiektów klasy {@link Autor} przechowujące informacje o imieniu i nazwisku autora.
     */
    private String imieNazwisko;
    /**
     * Prywatne pole obiektów klasy {@link Autor} przechowujące informacje o imieniu i nazwisu autora.
     */
    private List<Umowa> umowy ;

    /**
     * Konstruktor publiczny obiektów klasy {@link Autor}.
     * @param imieNazwisko Parametr definiujący jakie imię i nazwisko posaida autor.
     */
    public Autor(String imieNazwisko){
        umowy = new ArrayList<Umowa>();
        this.imieNazwisko = imieNazwisko;
    }

    /**
     * Metoda obiektów klasy {@link Autor}. Zwraca imię i nazwisko autora.
     * @return Zwraca imię i nazwisko autora.
     */
    public String getImieNazwisko(){
        return imieNazwisko;
    }
    /**
     * Metoda obiektów klasy {@link Autor}. Zwraca listę umów zawartych z autorem.
     * @return Zwraca listę umów zawartych z autorem
     */
    public List<Umowa> getUmowy(){
        return umowy;
    }

    /**
     Metoda obiektów klasy {@link Autor}. Zapisauje zawartą umowe z autorem.
     * @param umowa umowa zawarta z autorem, przypsiana do niego.
     */
    public void dodajUmowe(Umowa umowa){
        umowy.add(umowa);
    }
    
}
