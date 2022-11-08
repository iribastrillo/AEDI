
package sistemaDistribucion;

import Entidades.Cliente;
import Entidades.Camion;
import TADs.NodoLista;
import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws ParseException{
        
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodeprueba2(obl, p);
        
        
        obl.getS().getListaClientes().mostrarInversoREC(obl.getS().getListaClientes().getInicio());
        
        System.out.println("--------------------------------------------------");

        NodoLista nl = obl.getS().getListaClientes().obtenerElemento(new NodoLista(new Cliente("1253")));
        System.out.println("--------------------------------------------------");
        System.out.println("" + nl.getDato().equals(nl.getDato()));
        
        System.out.println("--------------------------------------------------");

        obl.eliminarCliente("1253");
        
        obl.getS().getListaClientes().mostrar();
        
        System.out.println("--------------------------------------------------");
        obl.getS().getListaCamiones().mostrar();
    }
        public static void juegodeprueba2(Obligatorio obl, Prueba p) throws ParseException {
            // escriba su juego de prueba aqui
            int MAX_CANT_PALABRAS_X_LINEA = 3;

            System.out.println( "1 ------------------------------------------------");
            p.ver(obl.crearSistemaDeDistribucion(MAX_CANT_PALABRAS_X_LINEA).resultado, Retorno.Resultado.OK, "Se creara sistema para 3 palabras por linea");
            p.ver(obl.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan los clientes");        
            p.ver(obl.agregarCamion("AAA111", 10).resultado, Retorno.Resultado.OK, "ajdkla");
            p.ver(obl.registrarProducto("1428", "Un pan", "un pan feteado").resultado, Retorno.Resultado.OK, "");
            p.ver(obl.altaDeStockDeProducto("AAA111", 1428, 102, 15).resultado, Retorno.Resultado.OK, obl.altaDeStockDeProducto("AAA111", 1428, 102, 15).valorString);
            p.ver(obl.altaDeStockDeProducto("AAA111", 1428, 102, 15).resultado, Retorno.Resultado.OK, obl.altaDeStockDeProducto("AAA111", 1428, 102, 15).valorString);
            p.ver(obl.reporteDeEnviosDeProductos().resultado, Retorno.Resultado.OK, obl.reporteDeEnviosDeProductos().valorString);
        }    
}
