
package sistemaDistribucion;

import Entidades.Cliente;
import TADs.NodoLista;
import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws ParseException{
        
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodeprueba2(obl, p);        
        
    }
        public static void juegodeprueba2(Obligatorio obl, Prueba p) throws ParseException {
        // escriba su juego de prueba aqui
        int MAX_CANT_PALABRAS_X_LINEA = 3;
        
        System.out.println( "1 ------------------------------------------------");
        p.ver(obl.crearSistemaDeDistribucion(MAX_CANT_PALABRAS_X_LINEA).resultado, Retorno.Resultado.OK, "Se creara sistema para 3 palabras por linea");
        p.ver(obl.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan los clientes");        
        }    
}
