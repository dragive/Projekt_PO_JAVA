package Data.DzienTygodniaExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy  zostanie podana za mała wartość dla dnia tygodnia.
 * Ta klasa rozszerza klasę {@link NieprawidlowyDzienTygodniaException}.
 * @author MF
 */
public final class ZaMalyDzienTygodniaException extends NieprawidlowyDzienTygodniaException{
    /**
     * Konstruktor klasy {@link ZaMalyDzienTygodniaException}
     */
    public ZaMalyDzienTygodniaException(){super();}
}
