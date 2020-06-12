package Data.DataExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy zostanie podany za niski numer dnia, nie możliwy do osiągnięcia.
 * Ta klasa rozszerza klasę {@link NieprawidlowaWartoscDniaException}.
 * @author MF
 */
public final class ZaMalaWartoscDniaException extends NieprawidlowaWartoscDniaException{
    /**
     * Konstruktor klasy {@link ZaMalaWartoscDniaException}
     */
    public ZaMalaWartoscDniaException(){
        super();
    }
}