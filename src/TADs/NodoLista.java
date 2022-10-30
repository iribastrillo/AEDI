/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TADs;

/**
 *
 * @author RC
 */
public class NodoLista<T extends Comparable<T>> {
    private T dato;
    private NodoLista sig;

    //Constructor
    public NodoLista(T n){
        this.dato=n;
        this.sig=null;
    }

    //Dato
    public void setDato(T d){
        this.dato=d;
    }
    public T getDato(){
        return this.dato;
    }

    //Siguiente
    public void setSig(NodoLista s){
        this.sig=s;
    }
    public NodoLista getSig(){
        return this.sig;
    }
}
