package Data;

import Data.DzienMiesiacaExceptions.ZaDuzyDzienMiesiacaException;
import Data.DzienMiesiacaExceptions.ZaMalyDzienMiesiacaException;

public class DzienMiesiaca {
    private int dzienMiesiaca;
    public DzienMiesiaca(int dzienMiesiaca){
        this.dzienMiesiaca =dzienMiesiaca;
    }
    public static int getDzienMiesiacaFromData(Data data){
        return data.getDzien();
    }
    public DzienMiesiaca(Data data){
        this.dzienMiesiaca = getDzienMiesiacaFromData(data);
    }
    public static void sprawdzPoprawnoscDniaMiesiaca(int dzien) throws ZaDuzyDzienMiesiacaException,ZaMalyDzienMiesiacaException {
        if(dzien<1)throw new ZaMalyDzienMiesiacaException();
        if(dzien>31)throw new ZaDuzyDzienMiesiacaException();
    }

    public void sprawdzPoprawnoscDniaMiesiaca() throws ZaDuzyDzienMiesiacaException,ZaMalyDzienMiesiacaException {
        sprawdzPoprawnoscDniaMiesiaca(this.dzienMiesiaca);
    }

    public void setDzien(int dzien) throws ZaDuzyDzienMiesiacaException,ZaMalyDzienMiesiacaException {
        sprawdzPoprawnoscDniaMiesiaca(dzien);
        this.dzienMiesiaca =dzien;
    }
    public int getDzien(){return this.dzienMiesiaca;}

    @Override
    public String toString() {
        return ""+this.dzienMiesiaca;
    }

    public boolean equals(Data data) {
        return (data.getDzien()==this.dzienMiesiaca)||(data.getIloscDniWMiesiacu()<this.dzienMiesiaca);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DzienMiesiaca that = (DzienMiesiaca) o;
        return this.dzienMiesiaca == that.getDzien();
    }

}
