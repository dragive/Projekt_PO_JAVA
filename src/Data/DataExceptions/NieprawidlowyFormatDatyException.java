package Data.DataExceptions;

/**
 * Klasa wyrzucana jako wyjątek, gdy  zostanie podany w jakikolwiek błędny sposób format daty.
 * Rozszerza klasę {@link Exception}.
 * Dziedziczą z niej: {@link NieprawidlowaWartoscDniaException}, {@link NieprawidlowaWartoscMiesiacaException}.
 * @author MF
 */
public class NieprawidlowyFormatDatyException extends Exception {
    /**
     * Konstruktor klasy {@link NieprawidlowyFormatDatyException}
     */
    public NieprawidlowyFormatDatyException(){
        super();
    }
}
