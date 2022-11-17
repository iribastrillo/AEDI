package sistemaDistribucion;

import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws ParseException{
        Obligatorio obl = new Obligatorio();
        Pruebas p = new Pruebas (obl);
        p.probar(); 
    }
   
}
