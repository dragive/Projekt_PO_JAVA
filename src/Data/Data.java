package Data;

import Data.DataExceptions.*;

public class Data {
    private int dzien,rok,miesiac;
    public Data(int rok,int miesiac,int dzien){
        this.rok=rok;
        this.dzien=dzien;
        this.miesiac=miesiac;
    }

    public Data(Data data){
        this.rok=data.getRok();
        this.dzien=data.getDzien();
        this.miesiac=data.getMiesiac();
    }
    public void setRok(int rok){
        this.rok=rok;
    }
    public void setMiesiac(int miesiac)throws ZaMalaWartoscMiesiacaException,ZaDuzaWartoscMiesiacaException{
        if(miesiac<1)
            throw new ZaMalaWartoscMiesiacaException();
        if(miesiac>12)throw new ZaDuzaWartoscMiesiacaException();
        this.miesiac=miesiac;
    }
    public void setDzien(int dzien)throws NieprawidlowaWartoscDniaException {

        if(dzien<1||dzien>31)
            throw new NieprawidlowaWartoscDniaException();
        this.dzien=dzien;
    }
    public int getDzien(){return this.dzien;}
    public int getRok(){return this.rok;}
    public int getMiesiac(){return this.miesiac;}

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

    public Data kolejnyDzien(){

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
        return this;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return this.getDzien() == data.getDzien() &&
                this.getRok() == data.getRok() &&
                this. getMiesiac() == data.getMiesiac();
    }

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

}
