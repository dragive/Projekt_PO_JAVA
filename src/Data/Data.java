package Data;

import Data.DataExceptions.*;

import java.io.Serializable;

/**
 * Klasa {@link Data} wykorzystywana jest do określania czasu, definiowania dat w całym projekcie. Na jej podstawie rozstrzyga się okresy trwania np. umów.
 * @author MF
 */
public class Data implements Serializable {
    /**
     * Prywatne pole klasy {@link Data}. Przechowuje informacje o dniu w dacie.
     */
    private int dzien;
    /**
     * Prywatne pole klasy {@link Data}. Przechowuje informacje o roku w dacie.
     */
    private int rok;
    /**
     * Prywatne pole klasy {@link Data}. Przechowuje informacje o miesiącu w dacie.
     */
    private int miesiac;

    /**
     * Publiczny konstruktor klasy {@link Data}.
     * @param rok Parametr typu int. Definiuje rok w dacie.
     * @param miesiac Parametr typu int. Definiuje miesiąc w dacie.
     * @param dzien Parametr typu int. Definiuje dzień w dacie.
     */
    public Data(int rok,int miesiac,int dzien){
        this.rok=rok;
        this.dzien=dzien;
        this.miesiac=miesiac;
    }
    /**
     * Publiczny konstruktor kopiujący klasy {@link Data}.
     * @param data Pobierany obiekt takiego samego typu jak klasa {@link Data}.
     */
    public Data(Data data){
        this.rok=data.getRok();
        this.dzien=data.getDzien();
        this.miesiac=data.getMiesiac();
    }

    /**
     * Publiczna metoda klasy {@link Data} służąca do nadpisania wartość w prywatnym polu rok klasy {@link Data}.
     * @param rok wartość roku w dacie.
     */
    public void setRok(int rok){
        this.rok=rok;
    }
    /**
     * Publiczna metoda klasy {@link Data} służąca do nadpisania wartość w prywatnym polu miesiąc klasy {@link Data}.
     * Wartość musi być z zakresu od 1 do 12 włącznie.
     * @param miesiac wartość miesiąca w dacie.
     * @throws ZaMalaWartoscMiesiacaException Wyjątek podnoszony, gdy podawana jest za mała, nie możliwa do osiągnięcia wartość miesiąca.
     * @throws ZaDuzaWartoscMiesiacaException Wyjątek podnoszony, gdy podawana jest za duża, nie możliwa do osiągnięcia wartość miesiąca.
     */
    public void setMiesiac(int miesiac)throws ZaMalaWartoscMiesiacaException,ZaDuzaWartoscMiesiacaException{
        if(miesiac<1)
            throw new ZaMalaWartoscMiesiacaException();
        if(miesiac>12)throw new ZaDuzaWartoscMiesiacaException();
        this.miesiac=miesiac;
    }
    /**
     * Publiczna metoda klasy {@link Data} służąca do nadpisania wartość w prywatnym polu dzien klasy {@link Data}.
     * Wartość wstępnie jest sprawdzana pod kątem możliwego wyjścia poza zakres 1-31. Nalezy po wywołaniu sprawdzić czy format daty jest poprawny.
     * @param dzien wartość miesiąca w dacie.
     * @throws NieprawidlowaWartoscDniaException Wyjątek podnoszony, gdy podawana jest za mała, nie możliwa do osiągnięcia wartość miesiąca.
     */
    public void setDzien(int dzien)throws NieprawidlowaWartoscDniaException {

        if(dzien<1||dzien>31)
            throw new NieprawidlowaWartoscDniaException();
        this.dzien=dzien;
    }

    /**
     * Publiczny getter klasy {@link Data} zwracający nr dnia.
     * @return Zwraca numer dnia.
     */
    public int getDzien(){return this.dzien;}
    /**
     * Publiczny getter klasy {@link Data} zwracający nr roku.
     * @return Zwraca numer roku.
     */
    public int getRok(){return this.rok;}

    /**
     * Publiczny getter klasy {@link Data} zwracający nr miesiąca.
     * @return Zwraca numer miesiąca.
     */
    public int getMiesiac(){return this.miesiac;}

    /**
     * Publiczna metoda klasy {@link Data} służąca do kontorli poprawności formatu daty zapisanym w obiekcie klasy {@link Data}.
     * Rok jest dowolny, miesiąc musi być z zakresu 1-12, dzień musi należeć do przedziału dni wyznaczonych przez rok (czy jest przestępny czy nie) i przez miesiąc.
     * @throws ZaMalaWartoscDniaException Wyjątek podnoszony, gdy występuje za mała wartość dnia nie możliwa do osiągnięcia w kalendarzu.
     * @throws ZaDuzaWartoscDniaException Wyjątek podnoszony, gdy dla danego miesiąca i roku nie możliwe jest osiągnięcie takiego numery dnia.
     * @throws ZaMalaWartoscMiesiacaException Wyjątek podnoszony, gdy w formacie daty jest podana za niska wartość miesiąca.
     * @throws ZaDuzaWartoscMiesiacaException Wyjątek podnoszony, gdy w formacie daty jest podana za wysoka wartość miesiąca.
     */
    public void sprawdzData()throws ZaMalaWartoscDniaException,ZaDuzaWartoscDniaException,ZaMalaWartoscMiesiacaException,ZaDuzaWartoscMiesiacaException{
        if(this.dzien<1)
            throw new ZaMalaWartoscDniaException();
        if(this.miesiac<1)
            throw new ZaMalaWartoscMiesiacaException();
        if(this.miesiac>12)
            throw new ZaDuzaWartoscMiesiacaException();
        if(this.getIloscDniWMiesiacu()<this.dzien)
            throw new ZaDuzaWartoscDniaException();
    }

    /**
     * Publiczna metoda klasy {@link Data}. Służy do przechodzenia do kolejnego dnia.
     * Dokonuje korekty daty jeżeli jest to wymaane.
     */
    public void kolejnyDzien(){

        this.dzien+=1;
        boolean poprawnyFormatDaty=false;
        while(!poprawnyFormatDaty){
            poprawnyFormatDaty=true;
            try{
                this.sprawdzData();
            }
            catch (NieprawidlowaWartoscDniaException ex){
                poprawnyFormatDaty=false;
                this.dzien=1;
                this.miesiac+=1;
                continue;
            }
            catch (NieprawidlowaWartoscMiesiacaException ex){
                poprawnyFormatDaty=false;
                this.miesiac=1;
                this.rok+=1;
                continue;
            }

        }
    }

    /**
     * Metoda publiczna klasy {@link Data} służy do wypisaywanie formatu daty "RRRR-MM-DD".
     * @return Zwaraca datę.
     */
    @Override
    public String toString() {
        String miesiac;
        miesiac=""+this.miesiac;
        if(miesiac.length()==1)
            miesiac="0"+miesiac;

        String dzien;
        dzien=""+this.dzien;
        if(dzien.length()==1)
            dzien="0"+dzien;

        String rok;
        rok=""+this.rok;

        return rok+"-"+miesiac+"-"+dzien;
    }

    /**
     * Publiczna metoda klasy {@link Data} służąca do porównywania w obiektów czy są takie same.
     * @param o Obiekt do porównania.
     * @return Zwraca wartość true jeżeli są takie same, jeżeli nie są takie same zwraca wartość false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return this.getDzien() == data.getDzien() &&
                this.getRok() == data.getRok() &&
                this. getMiesiac() == data.getMiesiac();
    }

    /**
     * Publiczna metoda klasy {@link Data} służąca do określania ile maksymlanie może być dni w miesiącu zapisanym w konkretnym obiekcie klasy {@link Data}.
     * @return Zwraca wartość od 28 do 31 w zależności od roku i miesiąca.
     */
    public int getIloscDniWMiesiacu(){
        int iloscDni=0;
        boolean przestepny=false;
        if( (this.rok%400==0) || ( (this.rok%100!=0) && (this.rok%4==0) ) )
            przestepny=true;
        switch (this.miesiac){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                iloscDni=31;
                break;
            case 2:
                if(przestepny)iloscDni=29;else iloscDni=28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                iloscDni=30;
                break;
        }
        return iloscDni;
    }
    public int wczesniejsza(Data data){
        if(this.rok>data.rok)return -1;
        else if(this.rok==data.rok){
            if(this.miesiac>data.miesiac)return -1;
            else if(this.miesiac==data.miesiac){
                if(this.dzien>data.dzien)return -1;
                else if(this.dzien==data.dzien){
                    return 0;
                }
                else return 1;
            }
            else return 1;
        }
        else return 1;

    }

}
