/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaDistribucion;

import Entidades.Caja;
import Entidades.Cliente;
import TADs.NodoLista;
import Entidades.Camion;
import Entidades.Envio;
import Entidades.PedidoEspera;
import Entidades.Producto;
import TADs.Cola;
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
    public Retorno registrarProducto(String nombre, String descripcion) {
        
        Producto p1 = new Producto(nombre);
        if(getS().getListaProductos().pertenece(p1)){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        if(descripcion == "") {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        Producto p = new Producto(nombre, descripcion);
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
        if(cantUnidades <= 0) {
            return new Retorno(Retorno.Resultado.ERROR_3);
        }
        
        Camion existeCamion = new Camion(matriculaCamion);
        if(!this.getS().getListaCamiones().pertenece(existeCamion)){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        
        if(!this.getS().existeProducto(codigoProd)){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        if(this.getS().existeCaja(nroCaja)){
            return new Retorno(Retorno.Resultado.ERROR_4);
        }
        
        if(!this.getS().hayCapacidad()) {
            return new Retorno(Retorno.Resultado.ERROR_5);
        }
        
        Caja c = new Caja(nroCaja, cantUnidades);
        NodoLista cajaNL = new NodoLista(c);
        Producto pNuevo = new Producto(codigoProd);
        NodoLista nodoProducto = new NodoLista(pNuevo);
        NodoLista pNodoLista = getS().getListaProductos().obtenerElemento(nodoProducto);
        
        Producto producto = (Producto) pNodoLista.getDato();
        Cola cajas = producto.getCajas();
        cajas.encolar(cajaNL);
        this.getS().disminuirEspacio();          
        return new Retorno(Retorno.Resultado.OK);
    }
    
    @Override
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant) {
        Camion existeCamion = new Camion(matriculaCam);
        if(!this.getS().getListaCamiones().pertenece(existeCamion)){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        Cliente existeCliente = new Cliente(rutCliente);
        if(!this.getS().getListaClientes().pertenece(existeCliente)) {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }

        Producto buscarProducto = new Producto(codProducto);
        NodoLista prodNL = new NodoLista(buscarProducto);
        prodNL = this.getS().getListaProductos().obtenerElemento(prodNL);
        if(prodNL == null) {
            return new Retorno(Retorno.Resultado.ERROR_3);
        } 

        Producto pEncontrado = (Producto) prodNL.getDato();
        Cola listadoCajas = pEncontrado.getCajas();

        NodoLista cajaAuxNL = listadoCajas.getInicio();
        int cantRestante = cant;


        while(cantRestante > 0 && cajaAuxNL != null) {

            Caja cajaAux = (Caja) cajaAuxNL.getDato();

            if(cajaAux.getCantUnidades() > cantRestante){
                int unidades = cajaAux.getCantUnidades();
                unidades = unidades - cantRestante;
                cajaAux.setCantUnidades(unidades);
                pEncontrado.getCajas().getInicio().setDato(cajaAux);
                cantRestante = 0;

                //TODO: agregar pedido
            } else if(cajaAux.getCantUnidades() == cantRestante) {
                listadoCajas.desencolar();
                pEncontrado.setCajas(listadoCajas);
                cantRestante = 0;    

                //TODO: agregar pedido
            } else if(cajaAux.getCantUnidades() < cantRestante) {
                cantRestante = cantRestante - cajaAux.getCantUnidades();
                cajaAuxNL = cajaAuxNL.getSig();
                listadoCajas.desencolar();

                //TODO: agregar pedido
            }
            int enviado = cant - cantRestante;
            if(enviado != 0) {
                Envio envio = new Envio(rutCliente, enviado, codProducto, matriculaCam);
                NodoLista envioNL = new NodoLista(envio);
                if(this.getS().getListaEnvios().esVacia()) {
                    this.getS().getListaEnvios().agregarInicio(envioNL);
                } else {
                    this.getS().getListaEnvios().agregarFinal(envioNL);

                }
            }
            
            
            if(listadoCajas.getInicio() == null && cantRestante != 0) {
                PedidoEspera pEspera = new PedidoEspera(matriculaCam, rutCliente, codProducto, cantRestante);
                NodoLista EsperaNL = new NodoLista(pEspera);
                pEncontrado.getListaEspera().encolar(EsperaNL);                    
            }            
            
        }
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarCamiones() {
        NodoLista inicio = this.getS().getListaCamiones().getInicio();
        getS().getListaCamiones().mostrarREC(inicio);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarClientesOrdenado() {
        NodoLista inicio = this.getS().getListaClientes().getInicio();
        getS().getListaClientes().mostrarREC(inicio);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarProductos() {
        this.getS().listarProductosConSuStock();
        return new Retorno(Retorno.Resultado.OK);
    }
    

    @Override
    public Retorno ultimoProductoRegistrado() {
        Producto ultP = (Producto) this.getS().getListaProductos().getFin().getDato();
        NodoLista ultPNl = new NodoLista(ultP);
        Lista aux = new Lista();
        aux.agregarInicio(ultPNl);
        aux.mostrar();
        //revisar
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarEnvíosDeProducto(int codProd) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listarOrdenesPendientes(int codProd) {
        NodoLista nodoProducto = new NodoLista (new Producto(codProd));
        NodoLista producto = this.s.getListaProductos().obtenerElemento(nodoProducto);
        
        if (producto == null) {
            return new Retorno (Retorno.Resultado.ERROR_1);
        }
        this.s.listarOrdenesPendientes(codProd);
        return new Retorno(Retorno.Resultado.OK);
        

    }

    @Override
    public Retorno reporteDeEnviosDeProductos() {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }
    
}
