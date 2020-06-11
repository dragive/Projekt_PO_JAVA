package Data;


import Data.DzienTygodniaExceptions.ZaDuzyDzienTygodnia;
import Data.DzienTygodniaExceptions.ZaMalyDzienTygodnia;



public class DzienTygodnia {
    private int dzien;
    public DzienTygodnia(int dzienTygodnia){
        this.dzien=dzienTygodnia;
    }
    public static int getDzienTygodniaFromData(Data data){
        int miesiac=data.getMiesiac();
        int rok=data.getRok();
        int C=(rok/100);
        int Y=rok%100;
        if(miesiac==1||miesiac==2)Y--;
        return (data.getDzien()+( (int) ((2.6*(((miesiac-3+12)%12)+1))-0.2) ) -2*C+Y+ Y/4 + C/4+6)%7+1;
    }
    public DzienTygodnia(Data data){
        this.dzien=getDzienTygodniaFromData(data);
    }
    public static void sprawdzPoprawnoscDniaTygodnia(int dzien)throws ZaDuzyDzienTygodnia,ZaMalyDzienTygodnia {
        if(dzien>7)throw new ZaDuzyDzienTygodnia();
        if(dzien<1)throw new ZaMalyDzienTygodnia();
    }
    public void sprawdzPoprawnoscDniaTygodnia()throws ZaDuzyDzienTygodnia,ZaMalyDzienTygodnia {
        sprawdzPoprawnoscDniaTygodnia(this.dzien);
    }

    public void setDzien(int dzien)throws ZaMalyDzienTygodnia,ZaDuzyDzienTygodnia {
        sprawdzPoprawnoscDniaTygodnia(dzien);
        this.dzien=dzien;
    }
    public int getDzien(){return this.dzien;}

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

    public boolean equals(Data data) {
        return (getDzienTygodniaFromData(data)==this.dzien);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DzienTygodnia that = (DzienTygodnia) o;
        return getDzien() == that.getDzien();
    }

}
