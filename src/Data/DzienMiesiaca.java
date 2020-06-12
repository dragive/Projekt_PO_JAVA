package Data;

import Data.DzienMiesiacaExceptions.ZaDuzyDzienMiesiacaException;
import Data.DzienMiesiacaExceptions.ZaMalyDzienMiesiacaException;

/**
 * Klasa {@link DzienMiesiaca} służy do przechowywania informacji kiedy dana publiakcja klasy {@link Publikacje.Miesiecznik} ma ukazywać się.
 * @author MF
 */
public class DzienMiesiaca {
    /**
     * Prywatne pole klsy {@link DzienMiesiaca} do przechowywania informacji odnośnie danego dnia miesiąca.
     */
    private int dzienMiesiaca;

    /**
     * Publiczny konstruktor klasy {@link DzienMiesiaca}.
     * @param dzienMiesiaca Parametr określający dzień miesiąca dla obiektów klasy {@link Publikacje.PublikacjaCykliczna}.
     */
    public DzienMiesiaca(int dzienMiesiaca){
        this.dzienMiesiaca =dzienMiesiaca;
    }

    /**
     * Publiczna statyczna metoda służąca do określania dnia miesiąca z obiektu klasy {@link Data}.
     * @param data Obiekt klasy {@link Data}, z którego pobrana będzie infrmacja odnośnie dnia miesiąca.
     * @return Zwraca wartość dnia miesiąca.
     */
    public static int getDzienMiesiacaFromData(Data data){
        return data.getDzien();
    }

    /**
     * Publiczny konstruktor klasy {@link DzienMiesiaca} kopiujący obiektu klasy {@link Data}.
     * @param data Obiekt, który ma być skopiowany.
     */
    public DzienMiesiaca(Data data){
        this.dzienMiesiaca = getDzienMiesiacaFromData(data);
    }

    /**
     * Publiczna metoda statyczna klasy {@link DzienMiesiaca}. Sprawdza czy podana wartość w parametrze jest możliwą wartośćią dnia miesiąca.
     * @param dzien Parametr typu int. Sprawdzana jest jego wartość pod kątem możliwych wartości do osiągnięcia.
     * @throws ZaDuzyDzienMiesiacaException wyjątek wyrzucany, gdy podana wartość jest za duza.
     * @throws ZaMalyDzienMiesiacaException wyjątek wyrzucany, gdy podana watość jest za mała.
     */
    public static void sprawdzPoprawnoscDniaMiesiaca(int dzien) throws ZaDuzyDzienMiesiacaException,ZaMalyDzienMiesiacaException {
        if(dzien<1)throw new ZaMalyDzienMiesiacaException();
        if(dzien>31)throw new ZaDuzyDzienMiesiacaException();
    }

    /**
     * Publiczna metoda obiektów klasy {@link DzienMiesiaca}. Sprawdza czy zapisana wartość w obiekcie klasy {@link DzienMiesiaca} jest poprawna.
     * @throws ZaDuzyDzienMiesiacaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienMiesiaca} jest za duża.
     * @throws ZaMalyDzienMiesiacaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienMiesiaca} jest za mała.
     */
    public void sprawdzPoprawnoscDniaMiesiaca() throws ZaDuzyDzienMiesiacaException,ZaMalyDzienMiesiacaException {
        sprawdzPoprawnoscDniaMiesiaca(this.dzienMiesiaca);
    }

    /**
     * Publiczna metoda obiektów klasy {@link DzienMiesiaca}. Służy do ustawienia dnia miesiąca.
     * @param dzien Pobiera numer dnia miesiąca.
     * @throws ZaDuzyDzienMiesiacaException Wyjątek wyrzucany gdy dzień miesiąca jest za duży.
     * @throws ZaMalyDzienMiesiacaException Wyjątek wyrzucany, gdzy dzień miesiaca jestza mały.
     */
    public void setDzien(int dzien) throws ZaDuzyDzienMiesiacaException,ZaMalyDzienMiesiacaException {
        sprawdzPoprawnoscDniaMiesiaca(dzien);
        this.dzienMiesiaca =dzien;
    }

    /**
     * Publiczna metoda klasy {@link DzienMiesiaca}.
     * @return Zwraca wartość dnia.
     */
    public int getDzien(){return this.dzienMiesiaca;}

    /**
     * Publiczna metoda obiektów klasy {@link DzienMiesiaca}.
     * @return Zwraca dzien miesiąca w formacje String.
     */
    @Override
    public String toString() {
        return ""+this.dzienMiesiaca;
    }

    /**
     * Publiczna metoda służąca do porównania czy obiekt klasy {@link Data} odpowiada odpowiedniemu dniu zapisanemu w obiekcie klasy {@link DzienMiesiaca}.
     * Gdy w dacie zapisanej w obiekcie klasy {@link Data} miesiąc nie ma tylu dni ile potrzeba w klasie by zrównały sie wartościami, to ostatniego dnia miesiąca zostanie zwrócona wartość true.
     * @param data Zwraca wartość true, gdy data z obiektu klasy {@link Data} odpowiada dniu miesiąca w obiekcie klasy {@link DzienMiesiaca}.
     * @return Zwraca wartośc logiczna mówiącą o zgodności dni miesiąca
     */
    public boolean equals(Data data) {
        return (data.getDzien()==this.dzienMiesiaca)||(data.getIloscDniWMiesiacu()<this.dzienMiesiaca);
    }

    /**
     * Publiczna metoda klasy {@link DzienMiesiaca} porównująca czy obiekt przekazany w parametrze jest taki sam jak obiekt z którego wywoływana jest ta metoda.
     * @param o Obiekt porównywany do obiektu klasy {@link DzienMiesiaca}
     * @return Zwraca true jeżeli oba obiekty są takie same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DzienMiesiaca that = (DzienMiesiaca) o;
        return this.dzienMiesiaca == that.getDzien();
    }

}
