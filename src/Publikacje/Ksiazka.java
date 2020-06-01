package Publikacje;

import Publikacje.PublikacjaExceptions.ZaKrotkiGatunekException;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

/**
 * Klasa ksiażki
 */
public class Ksiazka  extends Publikacja{
    /**
     * Zmienna przechowywująca informacje jakiego gatunku jest dana książka
     */
    private String gatunek;

    /**
     * Konstruktor publiczny klasy Książka
     * @param tytul tytuł danej publikacji
     * @param gatunek gatunek danej ksiażki
     * @throws ZaKrotkiTytulException Wyjątek występujący,gdy następuje próba ustawienia za krótkiego tytułu
     * @throws ZaKrotkiGatunekException Wyjątek występujący,gdy następuje próba ustawienia za krótkiego gatunku
     */
    public Ksiazka(String tytul, String gatunek) throws ZaKrotkiTytulException, ZaKrotkiGatunekException
    {
        super(tytul);
        if (gatunek.length()<1){
            throw new ZaKrotkiGatunekException();
        }
        this.gatunek=gatunek;
    }
}
