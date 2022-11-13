
package sistemaDistribucion;

import Entidades.Caja;
import Entidades.Camion;
import TADs.Lista;
import Entidades.Cliente;
import Entidades.Envio;
import Entidades.Producto;
import TADs.Cola;
import TADs.NodoLista;


public class Sistema {

    private Lista listaClientes;
    private Lista listaEnvios;
    private Lista listaCamiones;
    private int capacidadMaxima;
    private int capacidadActual;
    private Lista listaProductos;
    private Lista listaStock;
    
    public  Sistema(int capacidadCajas){
        this.listaClientes = new Lista();
        this.listaEnvios = new Lista();
        this.capacidadMaxima = capacidadCajas;
        this.capacidadActual = 0;
        this.listaCamiones = new Lista();
        this.listaProductos = new Lista();
        this.listaStock = new Lista();
    }
    /**
     * @return the listaClientes
     */
    public Lista getListaClientes() {
        return listaClientes;
    }
    /**
     * @param listaClientes the listaClientes to set
     */
    public void setListaClientes(Lista listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * @return the capacidadMaxima
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * @param capacidadMaxima the capacidadMaxima to set
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    /**
     * @return the listaEnvios
     */
    public Lista getListaEnvios() {
        return listaEnvios;
    }

    /**
     * @param listaEnvios the listaEnvios to set
     */
    public void setListaEnvios(Lista listaEnvios) {
        this.listaEnvios = listaEnvios;
    }    
        /**
     * @return the listaCamiones
     */
    public Lista getListaCamiones() {
        return listaCamiones;
    }

    /**
     * @param listaCamiones the listaCamiones to set
     */
    public void setListaCamiones(Lista listaCamiones) {
        this.listaCamiones = listaCamiones;
    }
    
    public boolean tieneEntregas (Cliente cliente) {
        boolean ok = false;
        NodoLista aux = this.listaEnvios.getInicio();
        if(aux == null) {
            return false;
        }
        while (!ok) {
            Envio envio = (Envio) aux.getDato();
            if (envio.getCliente().compareTo(cliente) == 0) {
                ok = true;
            }
        }
        return ok;
    }
    
    public boolean tieneEntregas(Camion camion) {
        boolean ok = false;
        NodoLista aux = this.listaEnvios.getInicio();
        if(aux == null){
            return false;
        }
        while(!ok) {
            Envio envio = (Envio) aux.getDato();
            if(envio.getCamion().compareTo(camion) == 0) {
                ok = true;
            }
        }
        return ok;
    }

    /**
     * @return the listaProductos
     */
    public Lista getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(Lista listaProductos) {
        this.listaProductos = listaProductos;
    }

   /**
     * @return the listaStock
     */
    public Lista getListaStock() {
        return listaStock;
    }

    /**
     * @param listaStock the listaStock to set
     */
    public void setListaStock(Lista listaStock) {
        this.listaStock = listaStock;
    }

        /**
     * @return the capacidadActual
     */
    public int getCapacidadActual() {
        return capacidadActual;
    }

    /**
     * @param capacidadActual the capacidadActual to set
     */
    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }
   
    public boolean hayCapacidad() {
        return this.getCapacidadActual() < this.getCapacidadMaxima();
    }
    
    
    public boolean existeCaja(int nroCaja) {
        Lista productos = this.getListaProductos();
        NodoLista pNL = productos.getInicio();
        while(pNL != null ) {
            Producto p = (Producto) pNL.getDato();
            Cola colaCajas = p.getCajas();
            NodoLista cNL = colaCajas.getInicio();
            if(p.tengoCajas()){
                while(cNL != null) {
                    Caja c = (Caja) cNL.getDato();
                    if(c.getNroCaja() == nroCaja) {
                        return true;
                    }
                    cNL = cNL.getSig();
                }
            }
            pNL = pNL.getSig();
        }
        
        return false;
    }
    
    public boolean existeProducto(int codigoProd) {
        Lista productos = this.getListaProductos();
        if(productos.esVacia()){
            return false;
        }
        NodoLista pNL = productos.getInicio();
        while(pNL != null) {
            Producto p = (Producto) pNL.getDato();
            if(p.getCodigo() == codigoProd) {
                return true;
            }
            pNL = pNL.getSig();
        }
        return false;
    }
    
    public void aumentarEspacio() {
        this.capacidadActual--;
    }
    
    public void disminuirEspacio() {
        this.capacidadActual++;
    }
    public void listarProductosConSuStock () {
        NodoLista nodoProducto = this.getListaProductos().getInicio();
        while (nodoProducto != null) {
            Producto producto = (Producto) nodoProducto.getDato();
            System.out.print (producto);
            System.out.println("");
            producto.getCajas().mostrarCola();
            nodoProducto = nodoProducto.getSig();

        }
    }  
}
