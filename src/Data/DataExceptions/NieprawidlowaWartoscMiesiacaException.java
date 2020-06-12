package Data.DataExceptions;

/**
 * Klasa wyrzucana jako wyjątek, gdy  zostanie podana nie możliwa do osiągnięcia realnie wartość miesiąca w kalendarzu.
 * Ta klasa jest wyrzucana, gdy numer miesiąca jest mniejszy od 1 i wiekszy od 12.
 * Rozszerza klasę {@link NieprawidlowyFormatDatyException}.
 * Dziedziczą z niej: {@link ZaMalaWartoscMiesiacaException}, {@link ZaDuzaWartoscMiesiacaException}.
 * @author MF
 */
public class NieprawidlowaWartoscMiesiacaException extends NieprawidlowyFormatDatyException{
    /**
     * Konstruktor klasy {@link NieprawidlowaWartoscMiesiacaException}
     */
    public NieprawidlowaWartoscMiesiacaException(){
        super();
    }
}
