package sistemaDistribucion;

import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws ParseException{
        Obligatorio obl = new Obligatorio();
        Pruebas p = new Pruebas (obl);
        p.probar(); 
    }
        public static void juegodeprueba2(Obligatorio obl, Prueba p) throws ParseException {
        // escriba su juego de prueba aqui
        int MAX_CANT_PALABRAS_X_LINEA = 4;
        
        System.out.println( "------------------------------------------------");
        
        p.ver(obl.crearSistemaDeDistribucion(MAX_CANT_PALABRAS_X_LINEA).resultado, Retorno.Resultado.OK, "Se creara sistema para 3 palabras por linea");
        p.ver(obl.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan los clientes");   
        
        
        }    
}
