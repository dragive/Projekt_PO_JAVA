import Publikacje.Publikacja;

import java.awt.*;
import java.lang.Exception;
public class test {
    public test(){
        try {
            Publikacja p = new Publikacja("");
        }
        catch (Exception exception){
            System.out.println(exception);
            System.exit(1);
        }
    }
}


