package Publikacje.PublikacjaExceptions;

/**
 * Klasa wyjątku ZaKrotkiGatunekException
 *
 * @author MF
 */
//#todo usunąć to i przekrztałcic w Data
public class NieprawidlowyFormatDatyException extends Exception{
    public NieprawidlowyFormatDatyException(){
        super("Nieprawidłowy format daty!");
    }


}
