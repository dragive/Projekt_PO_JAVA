package Umowy.UmowyExceptions;


/**
 * @author MF
 * Klasa Wyjątku. Wyrzucana, gdy nastepuje ponowna próba rozwiązania umowy.
 */
public class PonowneRozwiazanieUmowyException extends Exception{
    public PonowneRozwiazanieUmowyException(){
        super("Próba ponownego rozwiązania umowy cześniej już rozwiązanej!");
    }
    public PonowneRozwiazanieUmowyException(Throwable cause){
        super("Próba ponownego rozwiązania umowy cześniej już rozwiązanej!",cause);
    }
}
