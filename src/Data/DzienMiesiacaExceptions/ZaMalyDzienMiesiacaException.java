package Data.DzienMiesiacaExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy  zostanie podana za mała wartość dla dnia miesiąca.
 * Ta klasa rozszerza klasę {@link NieprawidlowyDzienMiesiacaException}.
 * @author MF
 */
public final class ZaMalyDzienMiesiacaException extends NieprawidlowyDzienMiesiacaException{
    /**
     * Konstruktor klasy {@link ZaMalyDzienMiesiacaException}
     */
    public ZaMalyDzienMiesiacaException(){super();}
}
