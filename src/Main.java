import Konsola.Konsola;

/**
 * Klada główna programu. To z niej wykonują się inne działania
 */
public class Main {
    /**
     * Funkcja główna
     * @param args Parametry przekazane do programu
     */
    public static void main(String[] args) {
        Konsola konsola = new Konsola();
        try{konsola.startProgramu();}
        catch (Exception ex){
            ex.printStackTrace();

        }
    }
}
