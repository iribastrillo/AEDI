/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TADs;

/**
 *
 * @author usuario
 */
public interface ICola {
    public void encolar(NodoLista nodo);
    public void desencolar();
    public boolean esVacia();
    public boolean esLlena();
    public int elementos();
    public NodoLista frente();
    public void mostrarCola();
    public void mostrarREC(NodoLista nodo);
}
