package ZleceniePublikacji.ZleceniePublikacjiExceptions;

/**
 * @author MF
 */
public class UjemnaZaplataException extends Exception{
    String message;
    public UjemnaZaplataException(){
        super("Ujemna zaplata!");

    }
    public UjemnaZaplataException(Throwable cause){
        super("Ujemna zaplata!",cause);
    }
    public UjemnaZaplataException(String message, Throwable cause){
        super(message,cause);
    }
    public UjemnaZaplataException(String message)
    {
        super(message);
    }
}
