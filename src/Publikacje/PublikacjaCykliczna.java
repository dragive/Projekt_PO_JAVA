package Publikacje;

import Publikacje.PublikacjaExceptions.ZaKrotkiGatunekException;
import Publikacje.PublikacjaExceptions.ZaKrotkiTytulException;

public abstract class PublikacjaCykliczna extends Publikacja{
    public PublikacjaCykliczna(String tytul) throws  ZaKrotkiTytulException
    {
        super(tytul);

    }
}
