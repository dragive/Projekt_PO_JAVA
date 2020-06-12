package Data.DzienMiesiacaExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy  zostanie podana za duża wartość dla dnia miesiąca.
 * Ta klasa rozszerza klasę {@link NieprawidlowyDzienMiesiacaException}.
 * @author MF
 */
public final class ZaDuzyDzienMiesiacaException extends NieprawidlowyDzienMiesiacaException{
    /**
     * Konstruktor klasy {@link ZaDuzyDzienMiesiacaException}
     */
    public ZaDuzyDzienMiesiacaException(){super();}
}
