package Publikacje.PublikacjaExceptions;

/**
 * Klasa wyjątku ZaKrotkiGatunekException
 * @author MF
 */
public class ZaKrotkiTytulException extends Exception{
    String message;
    public ZaKrotkiTytulException(){
        super("Za krótki tytuł!");
    }
    public ZaKrotkiTytulException(Throwable cause){
        super("Za krótki tytuł!",cause);
    }
    public ZaKrotkiTytulException(String message,Throwable cause){
        super(message,cause);
    }


}
