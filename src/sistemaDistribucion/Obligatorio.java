/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaDistribucion;

import Entidades.Cliente;
import TADs.NodoLista;
import Entidades.Camion;
import Entidades.Producto;
import Entidades.StockProductos;
import TADs.Lista;

/**
 *
 * @author Pérez, G. 249454 ; Ribas, I. 242158
 */
public class Obligatorio  implements IObligatorio{

    private Sistema s;
    
    /**
     * @return the s
     */
    public Sistema getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Sistema s) {
        this.s = s;
    }
    
    @Override
    public Retorno crearSistemaDeDistribucion(int cantidadmaxima) {        
        if (cantidadmaxima <= 0) {
            return new Retorno (Retorno.Resultado.ERROR_1);
        }
        this.setS(new Sistema(cantidadmaxima));
//        Cliente c = new Cliente("Pepe","1253",1234,"Direccion");
//        Cliente c1 = new Cliente("Pepe1","1234",1234,"Direccion");
//        Cliente c2 = new Cliente("Pepe2","12345",1234,"Direccion");
//        Cliente c3 = new Cliente("Pepe3","123456",1234,"Direccion");
        
        this.agregarCliente("Adolfo","1253",1234,"Direccion");
        this.agregarCliente("Gonzalo","1234",1234,"Direccion");
        this.agregarCliente("Bautista","1234",1234,"Direccion");
        this.agregarCliente("Ignacio","12345",1234,"Direccion");
        this.agregarCliente("Carmen","123456",1234,"Direccion");
        this.listarCamiones();
        this.agregarCamion("AAV4543", 10);
        this.agregarCamion("AAV4543", 15);
        this.agregarCamion("AAK4543", 10);
        this.eliminarCamion("AAV4543");
        this.agregarCamion("AAA1111", 1);
        this.agregarCamion("AAA1000", -1);
        this.listarCamiones();
        this.registrarProducto("1428","Pan Marbella Lactal 550g", "Pan lacteado en fetas");
        this.registrarProducto("1429","Pan Marbella Ingegral 580g", "Pan lacteado en fetas");
        this.registrarProducto("1429","Pan Marbella Ingegral 580g", "Pan integral en fetas");
        //this.listarProductos();
        System.out.println("-------ULTIMO PRODUCTO-------");
        this.ultimoProductoRegistrado();
        
        this.altaDeStockDeProducto("AAA1111", 1428, 101, 10);
        

        
        return new Retorno (Retorno.Resultado.OK);
    }

    @Override
    public Retorno agregarCliente(String nombre, String rut, int tel, String direccion) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Cliente c = new Cliente(nombre,rut,tel,direccion);
        NodoLista cl = new NodoLista(c);
        
        if(getS().getListaClientes().esVacia()) {
            getS().getListaClientes().agregarInicio(cl);
        } else if(getS().getListaClientes().pertenece(c)){
            ret = new Retorno(Retorno.Resultado.ERROR_1);
        } else {
            getS().getListaClientes().agregarOrd(cl);
        }  
        return ret;
    }

    @Override
    public Retorno eliminarCliente(String rut) {
        Cliente cliente = new Cliente (rut);
        NodoLista nodo = new NodoLista(cliente);
        NodoLista nodoCliente = this.getS().getListaClientes().obtenerElemento(nodo);
        
        if (nodoCliente == null) {
            return new Retorno (Retorno.Resultado.ERROR_1);
        }
        if (this.getS().tieneEntregas(cliente)) {
            return new Retorno (Retorno.Resultado.ERROR_2);
        }
        this.getS().getListaClientes().borrarElemento(nodo);
        return new Retorno (Retorno.Resultado.OK);
    }

    @Override
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas) {
        
        if(toneladasMaxSoportadas <= 0){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        Camion c = new Camion(matricula, toneladasMaxSoportadas);
        NodoLista cl = new NodoLista(c);
        
        if(getS().getListaCamiones().esVacia()) {
            getS().getListaCamiones().agregarInicio(cl);
        } else if(getS().getListaCamiones().pertenece(c)){
            return new Retorno(Retorno.Resultado.ERROR_1);
        } else {
            getS().getListaCamiones().agregarOrd(cl);
        }
        
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "dsafdsgsfda";
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno eliminarCamion(String matricula) {
        Camion c = new Camion(matricula);
        NodoLista cNl = new NodoLista(c);
        
        NodoLista aux = this.getS().getListaCamiones().obtenerElemento(cNl);
        if(aux == null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        if(getS().tieneEntregas(c)){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        this.getS().getListaCamiones().borrarElemento(aux);
        return new Retorno(Retorno.Resultado.OK);  
        
    }

    @Override
    public Retorno registrarProducto(String codigo, String nombre, String descripcion) {
        
        if(descripcion == "") {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        Producto p = new Producto(codigo, nombre, descripcion);
        NodoLista pNl = new NodoLista(p);
        
        if(getS().getListaProductos().esVacia()) {
            getS().getListaProductos().agregarInicio(pNl);
        } else if(getS().getListaProductos().pertenece(p)){
            return new Retorno(Retorno.Resultado.ERROR_1);
        } else {
            this.getS().getListaProductos().agregarOrd(pNl);
        }
        return new Retorno(Retorno.Resultado.OK);        
    }

    @Override
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        if(this.getS().getCapacidadMaxima() <= 0) {
            ret = new Retorno(Retorno.Resultado.ERROR_5);
            ret.valorString = "No hay capacidad para almacenar la caja.";
            return ret;
        }
        
        if(cantUnidades <= 0) {
            ret = new Retorno(Retorno.Resultado.ERROR_3);
            ret.valorString = "Unidades debe ser mayor que 0.";
            return ret;
        }
        
        Camion camion = new Camion(matriculaCamion);
        if(!this.getS().getListaCamiones().pertenece(camion)){
            ret = new Retorno(Retorno.Resultado.ERROR_1);
            ret.valorString = "No existe camión.";
            return ret;
        }
        
        Lista productos = getS().getListaProductos();
        NodoLista pr = productos.getInicio();
        Producto actual = (Producto) pr.getDato();
        String strCodProd = Integer.toString(codigoProd);

        while(pr != null) {
            if(!actual.existeProducto(strCodProd)){
                ret = new Retorno(Retorno.Resultado.ERROR_2);
                ret.valorString = "No existe producto.";
                return ret;
            }
            pr = pr.getSig();
        }
        
        Lista stock = this.getS().getStockProductos();
        
        StockProductos nuevoStock = new StockProductos(matriculaCamion, Integer.toString(codigoProd), nroCaja, cantUnidades);
        NodoLista nuevoStockNL = new NodoLista(nuevoStock);

        if(!stock.esVacia()){
            
            NodoLista stockNL = stock.getInicio();
            StockProductos stockDato = (StockProductos) stockNL.getDato();
            while(stockNL != null) {
                if(stockDato.getNroCaja() == nroCaja) {
                    ret = new Retorno(Retorno.Resultado.ERROR_4);
                    ret.valorString = "Ya existe ese nro. de caja.";
                    return ret;
                }
                stockNL = stockNL.getSig();
            }
        } else {
            this.getS().getStockProductos().agregarInicio(nuevoStockNL);
            ret = new Retorno(Retorno.Resultado.OK);
            ret.valorString = "Se ingresó stock correctamente.";
            return ret;
        }
        this.getS().getStockProductos().agregarFinal(nuevoStockNL);
        ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "Se ingresó stock correctamente.";
        return ret;
    }

    @Override
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno listarCamiones() {
        this.getS().getListaCamiones().mostrar();
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarClientesOrdenado() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        getS().getListaClientes().mostrar();
        return ret;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno listarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno ultimoProductoRegistrado() {
        Producto ultP = (Producto) this.getS().getListaProductos().getFin().getDato();
        NodoLista ultPNl = new NodoLista(ultP);
        Lista aux = new Lista();
        aux.agregarInicio(ultPNl);
        aux.mostrar();
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarEnvíosDeProducto(int codProd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno listarOrdenesPendientes(int codProd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno reporteDeEnviosDeProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        this.getS().getStockProductos().mostrar();
        ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "Se muestra correctamente.";
        
        
        
        return ret;
        
    }
    
}
