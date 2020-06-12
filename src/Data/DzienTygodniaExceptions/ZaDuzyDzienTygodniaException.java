package Data.DzienTygodniaExceptions;

/**
 * Klasa finalna wyrzucana jako wyjątek, gdy  zostanie podana za duża wartość dla dnia tygodnia.
 * Ta klasa rozszerza klasę {@link NieprawidlowyDzienTygodniaException}.
 * @author MF
 */
public final class ZaDuzyDzienTygodniaException extends NieprawidlowyDzienTygodniaException{
    /**
     * Konstruktor klasy {@link ZaDuzyDzienTygodniaException}
     */
    public ZaDuzyDzienTygodniaException(){super();}
}
