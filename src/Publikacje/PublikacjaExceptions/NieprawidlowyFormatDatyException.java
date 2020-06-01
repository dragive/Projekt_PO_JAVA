package Publikacje.PublikacjaExceptions;

/**
 * Klasa wyjątku ZaKrotkiGatunekException
 * @author MF
 */
public class NieprawidlowyFormatDatyException extends Exception{
    String message;
    public NieprawidlowyFormatDatyException(){
        super("Nieprawidłowy format daty!");
    }
    public NieprawidlowyFormatDatyException(Throwable cause){
        super("Nieprawidłowy format daty!",cause);
    }
    public NieprawidlowyFormatDatyException(String message, Throwable cause){
        super(message,cause);
    }


}
