package Data.DataExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy zostanie podany za niski numer miesiąca, nie możliwy do osiągnięcia.
 * Ta klasa rozszerza klasę {@link NieprawidlowaWartoscMiesiacaException}.
 * @author MF
 */
public final class ZaMalaWartoscMiesiacaException extends NieprawidlowaWartoscMiesiacaException{
    /**
     * Konstruktor klasy {@link ZaMalaWartoscMiesiacaException}
     */
    public ZaMalaWartoscMiesiacaException(){
        super();
    }

}
