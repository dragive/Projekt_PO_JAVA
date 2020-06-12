package Data.DataExceptions;

/**
 * Klasa wyrzucana jako wyjątek, gdy  zostanie podana nie możliwa do osiągnięcia realnie wartość dnia w kalendarzu.
 * Ta klasa zazwyczaj jest wyrzucana, gdy dzień miesiąca jest mniejszy od 1 i wiekszy od 31. Może być również wyrzucona dla innych miesięcy, posiadających mniejsza ilość dni w miesiącu.
 * Rozszerza klasę {@link NieprawidlowyFormatDatyException}.
 * Dziedziczą z niej: {@link ZaMalaWartoscDniaException}, {@link ZaDuzaWartoscDniaException}.
 * @author MF
 */
public class NieprawidlowaWartoscDniaException extends NieprawidlowyFormatDatyException{
    /**
     * Konstruktor klasy {@link NieprawidlowaWartoscDniaException}
     */
    public NieprawidlowaWartoscDniaException(){
        super();
    }
}