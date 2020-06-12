package Data.DataExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy zostanie podany za wysoki numer miesiąca, nie możliwy do osiągnięcia.
 * Ta klasa rozszerza klasę {@link NieprawidlowaWartoscMiesiacaException}.
 * @author MF
 */
public final class ZaDuzaWartoscMiesiacaException extends NieprawidlowaWartoscMiesiacaException{
    /**
     * Konstruktor klasy {@link ZaDuzaWartoscMiesiacaException}
     */
    public ZaDuzaWartoscMiesiacaException(){
        super();
    }
}
