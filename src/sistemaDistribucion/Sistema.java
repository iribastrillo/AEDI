
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
    private Lista listaCamiones;
    private int capacidadMaxima;
    private int capacidadActual;
    private Lista listaProductos;
    private Lista listaStock;
    
    public  Sistema(int capacidadCajas){
        this.listaClientes = new Lista();
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
        NodoLista productoInicialNL = this.listaProductos.getInicio();
        if(productoInicialNL == null) {
            return false;
        }
        
        while(productoInicialNL != null) {
            Producto productoActual = (Producto) productoInicialNL.getDato();
            NodoLista envioInicialNL = productoActual.getEnvios().getInicio();
            while(envioInicialNL != null) {
                Envio envioActual = (Envio) envioInicialNL.getDato();
                if(envioActual.getRut().compareTo(cliente.getRut()) == 0) {
                    return true;
                }
                envioInicialNL = envioInicialNL.getSig();
            }
            productoInicialNL = productoInicialNL.getSig();
        }
        return false;
    }
    
    public boolean tieneEspera(Cliente cliente) {
        NodoLista productoInicialNL = this.listaProductos.getInicio();
        if(productoInicialNL == null) {
            return false;
        }
        
        while(productoInicialNL != null) {
            Producto productoActual = (Producto) productoInicialNL.getDato();
            NodoLista esperaInicialNL = productoActual.getEspera().getInicio();
            while(esperaInicialNL != null) {
                Envio esperaActual = (Envio) esperaInicialNL.getDato();
                if(esperaActual.getRut().compareTo(cliente.getRut()) == 0) {
                    return true;
                }
                esperaInicialNL = esperaInicialNL.getSig();
            }
            productoInicialNL = productoInicialNL.getSig();
        }
        return false;
    }
    
    
    public boolean tieneEntregas(Camion camion) {

        NodoLista productoInicialNL = this.listaProductos.getInicio();
        if(productoInicialNL == null) {
            return false;
        }
        
        while(productoInicialNL != null) {
            Producto productoActual = (Producto) productoInicialNL.getDato();
            NodoLista envioInicialNL = productoActual.getEnvios().getInicio();
            while(envioInicialNL != null) {
                Envio envioActual = (Envio) envioInicialNL.getDato();
                if(envioActual.getMatricula().compareTo(camion.getMatricula()) == 0) {
                    return true;
                }
                envioInicialNL = envioInicialNL.getSig();
            }
            productoInicialNL = productoInicialNL.getSig();
        }
        return false;
    }

    public boolean tieneEspera(Camion camion) {

        NodoLista productoInicialNL = this.listaProductos.getInicio();
        if(productoInicialNL == null) {
            return false;
        }
        
        while(productoInicialNL != null) {
            Producto productoActual = (Producto) productoInicialNL.getDato();
            NodoLista esperaInicialNL = productoActual.getEspera().getInicio();
            while(esperaInicialNL != null) {
                Envio envioActual = (Envio) esperaInicialNL.getDato();
                if(envioActual.getMatricula().compareTo(camion.getMatricula()) == 0) {
                    return true;
                }
                esperaInicialNL = esperaInicialNL.getSig();
            }
            productoInicialNL = productoInicialNL.getSig();
        }
        return false;
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
    
    public void listarOrdenesPendientes (int codProd) {
        NodoLista nodoProducto = this.getListaProductos().getInicio();
        while (nodoProducto != null) {
            Producto producto = (Producto) nodoProducto.getDato();
            if (producto.getCodigo() == codProd) {
                System.out.print (producto);
                System.out.println("");
                producto.getEspera().mostrarCola();
            }
            nodoProducto = nodoProducto.getSig();
        }
    }
    
    public void matriz() {
        int filas = this.getListaProductos().cantElementos();
        int columnas = this.getListaClientes().cantElementos();
        
        Lista listaProductos = this.getListaProductos();
        Lista listaClientes = this.getListaClientes();
        
        this.imprimirCabecera();
        

        NodoLista prodAux = listaProductos.getInicio();
        int i = 0;

        while(prodAux != null){
        
            Producto p = (Producto) prodAux.getDato();
            System.out.print("Cod. Prod.: "+ p.getCodigo() + "\t");
            
            NodoLista cliAux = listaClientes.getInicio();
            int j = 0;

            while(cliAux != null) {
                Cliente clienteActual = (Cliente) cliAux.getDato();
                
                Producto producto = (Producto)prodAux.getDato();
                Cola listaEnvios = producto.getEnvios();
                NodoLista envAux = listaEnvios.getInicio();
                int contEnvios = 0;
                while(envAux != null) {
                    Envio envioActual = (Envio)envAux.getDato();
                    if(envioActual.getRut().equals(clienteActual.getRut())) {
                        contEnvios = contEnvios + envioActual.getCantidad();
                    }
                    envAux = envAux.getSig();
                }
                System.out.print(contEnvios + "\t");

                j++;
                cliAux = cliAux.getSig();
            }
            i++;
            prodAux = prodAux.getSig();
            System.out.println("");
        }
        
    }

    public void imprimirCabecera() {
        NodoLista cliAux = this.getListaClientes().getInicio();
        System.out.print("           " + "\t");
        while(cliAux != null) {
            Cliente c = (Cliente)cliAux.getDato();
            System.out.print(c.getRut() + "\t");
            cliAux = cliAux.getSig();
        }
        System.out.println("");
    }
    
    
    
}
