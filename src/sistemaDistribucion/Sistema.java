
package sistemaDistribucion;

import TADs.Lista;
import Entidades.Cliente;
import Entidades.Envio;
import TADs.NodoLista;


public class Sistema {
    
    private Lista listaClientes;
    private Lista listaEnvios;
    private int capacidadMaxima;
    
    public  Sistema(int capacidadCajas){
        this.listaClientes = new Lista();
        this.listaEnvios = new Lista();
        this.capacidadMaxima = capacidadCajas;
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
}
