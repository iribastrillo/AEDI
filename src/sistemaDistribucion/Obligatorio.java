/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaDistribucion;

import Entidades.Cliente;
import TADs.NodoLista;

/**
 *
 * @author Felipe
 */
public class Obligatorio  implements IObligatorio{

    private Sistema s;
    
    @Override
    public Retorno crearSistemaDeDistribucion(int cantidadmaxima) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.s = new Sistema();
        
        Cliente c = new Cliente("Pepe","1253",1234,"Direccion");
        Cliente c1 = new Cliente("Pepe1","1253",1234,"Direccion");
        Cliente c2 = new Cliente("Pepe2","1253",1234,"Direccion");
        Cliente c3 = new Cliente("Pepe3","1253",1234,"Direccion");
        s.listaClientes.agregarInicio(new NodoLista(c));
        s.listaClientes.agregarInicio(new NodoLista(c1));
        s.listaClientes.agregarInicio(new NodoLista(c2));
        s.listaClientes.agregarInicio(new NodoLista(c3));
        
        return ret;
    }

    @Override
    public Retorno agregarCliente(String nombre, String rut, int tel, String direccion) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Cliente c = new Cliente(nombre,rut,tel,direccion);
        NodoLista cl = new NodoLista(c);
        
        if(s.listaClientes.esVacia()) {
            s.listaClientes.agregarInicio(cl);
        } else if(s.listaClientes.pertenece(c)){
            ret = new Retorno(Retorno.Resultado.ERROR_1);
        } else {
            s.listaClientes.agregarFinal(cl);
        }
        
        
        return ret;
    }

    @Override
    public Retorno eliminarCliente(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        s.listaClientes.mostrar();
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
