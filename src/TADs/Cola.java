/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TADs;

/**
 *
 * @author usuario
 */
public class Cola implements ICola {

    private NodoLista inicio;
    private NodoLista fin;
    private int cantidad;
    
    public Cola () {
        cantidad = 0;
    }
    /**
     * @return the inicio
     */
    public NodoLista getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(NodoLista inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public NodoLista getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(NodoLista fin) {
        this.fin = fin;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public void encolar(NodoLista nodo) {
            if(this.esVacia()) {
                this.setInicio(nodo);
                this.setFin(nodo);
                this.setCantidad(1);
            }else {
                fin.setSig(nodo);
                fin = nodo;
                cantidad++;
            }          
    }

    @Override
    public void desencolar() {
        if(!esVacia()) {
            NodoLista borrar = inicio;
            if(cantidad == 1) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.getSig();
                borrar.setSig(null);
            }
            cantidad --;
        }

    }

    @Override
    public boolean esVacia() {
        return this.getCantidad() == 0;
    }

    @Override
    public boolean esLlena() {
        return false;
    }

    @Override
    public int elementos() {
        return this.elementos();
    }

    @Override
    public NodoLista frente() {
        if(!this.esVacia()){
            return this.getInicio();
        }
        return null;
    }

    @Override
    public void mostrarCola() {
        NodoLista mostrar = getInicio();
        while(mostrar != null) {
            System.out.println(mostrar.getDato());
            mostrar = mostrar.getSig();
        }
            
    }

    @Override
    public void mostrarREC(NodoLista nodo) {
        if(nodo!=null){
            System.out.println(nodo.getDato());
            mostrarREC(nodo.getSig());
        }
    }
}
