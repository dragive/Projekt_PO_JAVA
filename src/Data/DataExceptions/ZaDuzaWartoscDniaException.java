package Data.DataExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy zostanie podany za wysoki numer dnia, nie możliwy do osiągnięcia.
 * Ta klasa rozszerza klasę {@link NieprawidlowaWartoscDniaException}.
 * @author MF
 */
public final class ZaDuzaWartoscDniaException extends NieprawidlowaWartoscDniaException{
    /**
     * Konstruktor klasy {@link ZaDuzaWartoscDniaException}
     */
    public ZaDuzaWartoscDniaException(){
        super();
    }
}