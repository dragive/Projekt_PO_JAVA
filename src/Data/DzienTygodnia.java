package Data;


import Data.DzienTygodniaExceptions.ZaDuzyDzienTygodniaException;
import Data.DzienTygodniaExceptions.ZaMalyDzienTygodniaException;

import java.io.Serializable;


/**
 * Klasa {@link DzienTygodnia} służy do przechowywania informacji kiedy dana publiakcja klasy {@link Publikacje.Tygodnik} ma ukazywać się.
 * @author MF
 */
public class DzienTygodnia implements Serializable {
    /**
     * Prywatne pole klsy {@link DzienTygodnia} do przechowywania informacji odnośnie danego dnia tygodnia.
     */
    private int dzien;

    /**
     * Publiczny konstruktor klasy {@link DzienTygodnia}.
     * @param dzienTygodnia parametr określający dzień miesiąca dla obiektów klasy {@link Publikacje.PublikacjaCykliczna}
     */
    public DzienTygodnia(int dzienTygodnia){
        this.dzien=dzienTygodnia;
    }
    /**
     * Publiczna statyczna metoda służąca do określania dnia tygodnia z obiektu klasy {@link Data}.
     * @param data Obiekt klasy {@link Data}, z którego pobrana będzie infrmacja odnośnie dnia tygodnia.
     * @return Zwraca wartość dnia tygodnia.
     */
    public static int getDzienTygodniaFromData(Data data){
        int miesiac=data.getMiesiac();
        int rok=data.getRok();
        int C=(rok/100);
        int Y=rok%100;
        if(miesiac==1||miesiac==2)Y--;
        return (data.getDzien()+( (int) ((2.6*(((miesiac-3+12)%12)+1))-0.2) ) -2*C+Y+ Y/4 + C/4+6)%7+1;
    }
    /**
     * Publiczny konstruktor klasy {@link DzienTygodnia} kopiujący obiektu klasy {@link Data}.
     * @param data Obiekt, który ma być skopiowany.
     */
    public DzienTygodnia(Data data){
        this.dzien=getDzienTygodniaFromData(data);
    }

    /**
     * Publiczna metoda obiektów klasy {@link DzienMiesiaca}. Sprawdza czy podana wartość w parametrze jest poprawna.
     * @param dzien nr dnia w tygodniu
     * @throws ZaDuzyDzienTygodniaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienTygodnia} jest za duża.
     * @throws ZaMalyDzienTygodniaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienTygodnia} jest za mała.
     */
    public static void sprawdzPoprawnoscDniaTygodnia(int dzien)throws ZaDuzyDzienTygodniaException, ZaMalyDzienTygodniaException {
        if(dzien>7)throw new ZaDuzyDzienTygodniaException();
        if(dzien<1)throw new ZaMalyDzienTygodniaException();
    }

    /**
     * Publiczna metoda obiektów klasy {@link DzienTygodnia}. Sprawdza czy zapisana wartość w obiekcie klasy {@link DzienTygodnia} jest poprawna.
     * @throws ZaDuzyDzienTygodniaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienTygodnia} jest za duża.
     * @throws ZaMalyDzienTygodniaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienTygodnia} jest za mała.
     */
    public void sprawdzPoprawnoscDniaTygodnia()throws ZaDuzyDzienTygodniaException, ZaMalyDzienTygodniaException {
        sprawdzPoprawnoscDniaTygodnia(this.dzien);
    }
    /**
     * Publiczna metoda obiektów klasy {@link DzienTygodnia}. Służy do ustawiania dnia tygodnia w obiektach klasy {@link DzienTygodnia}
     * @param dzien Parametr typu int oznaczający dzien tygodni do przypisania.
     * @throws ZaDuzyDzienTygodniaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienTygodnia} jest za duża.
     * @throws ZaMalyDzienTygodniaException Wyjątek wyrzucany, gdy zapisana wartość w obiekcie {@link DzienTygodnia} jest za mała.
     */
    public void setDzien(int dzien)throws ZaMalyDzienTygodniaException, ZaDuzyDzienTygodniaException {
        sprawdzPoprawnoscDniaTygodnia(dzien);
        this.dzien=dzien;
    }

    /**
     * Publiczna metoda obiektów klasy {@link DzienTygodnia}.
     * @return Zwraca wartość dnia tygodnia.
     */
    public int getDzien(){return this.dzien;}

    /**
     * Publiczna metoda obiektów klasy {@link DzienTygodnia}. Służy do wypisania słownie dnia tygodnia.
     * @return Słownie dzień tygodnia
     */
    @Override
    public String toString() {
        String ret="--";
        switch (this.dzien){
            case 1:
                ret="Poniedzialek";
                break;
            case 2:
                ret="Wtorek";
                break;
            case 3:
                ret="Sroda";
                break;
            case 4:
                ret="Czwartek";
                break;
            case 5:
                ret="Piatek";
                break;
            case 6:
                ret="Sobota";
                break;
            case 7:
                ret="Niedziela";
                break;
        }
        return ret;
    }

    /**
     * Publiczna metoda obiektów klasy {@link DzienTygodnia}. Zwraca wartość logiczną z porównania czy dizeń tygodnia w obiekcie klasy {@link Data} jest taki sam jak zapisany w obiekcie klasy {@link DzienTygodnia}
     * @param data obiekt klasy {@link Data} do porówniania.
     * @return wartość logiczna z porównania.
     */

    public boolean equals(Data data) {
        return (getDzienTygodniaFromData(data)==this.dzien);
    }
    /**
     * Publiczna metoda klasy {@link DzienTygodnia} porównująca czy obiekt przekazany w parametrze jest taki sam jak obiekt z którego wywoływana jest ta metoda.
     * @param o Obiekt porównywany do obiektu klasy {@link DzienTygodnia}
     * @return Zwraca true jeżeli oba obiekty są takie same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DzienTygodnia that = (DzienTygodnia) o;
        return getDzien() == that.getDzien();
    }

}
