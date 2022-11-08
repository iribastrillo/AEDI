
package sistemaDistribucion;

import Entidades.Camion;
import TADs.Lista;
import Entidades.Cliente;
import Entidades.Envio;
import TADs.Cola;
import TADs.NodoLista;


public class Sistema {
    
    private Lista listaClientes;
    private Lista listaEnvios;
    private Lista listaCamiones;
    private int capacidadMaxima;
    private Lista listaProductos;
    private Lista stockProductos;
    
    public  Sistema(int capacidadCajas){
        this.listaClientes = new Lista();
        this.listaEnvios = new Lista();
        this.capacidadMaxima = capacidadCajas;
        this.listaCamiones = new Lista();
        this.listaProductos = new Lista();
        this.stockProductos = new Lista();
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
     * @return the stockProductos
     */
    public Lista getStockProductos() {
        return stockProductos;
    }

    /**
     * @param stockProductos the stockProductos to set
     */
    public void setStockProductos(Lista stockProductos) {
        this.stockProductos = stockProductos;
    }
}
