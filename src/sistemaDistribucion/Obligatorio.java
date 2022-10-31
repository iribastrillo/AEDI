/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaDistribucion;

import Entidades.Cliente;
import Entidades.Camion;
import TADs.NodoLista;
import Entidades.Camion;

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
        
        this.agregarCamion("AAV4543", 10);
        this.agregarCamion("AAV4543", 15);
        this.agregarCamion("AAK4543", 10);


        
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
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno eliminarCamion(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno registrarProducto(String código, String nombre, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno listarCamiones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
