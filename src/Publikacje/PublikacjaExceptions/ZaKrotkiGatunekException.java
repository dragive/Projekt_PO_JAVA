package Publikacje.PublikacjaExceptions;

/**
 * Klasa wyjątku ZaKrotkiGatunekException
 * @author MF
 */
public class ZaKrotkiGatunekException extends Exception{
    String message;
    public ZaKrotkiGatunekException(){
        super("Za krótki gatunek!");
    }
    public ZaKrotkiGatunekException(Throwable cause){
        super("Za krótki gatunek!",cause);
    }
    public ZaKrotkiGatunekException(String message, Throwable cause){
        super(message,cause);
    }


}
