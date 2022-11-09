package TADs;

public interface IListaTope<T extends Comparable<T>>  {
 
    
    public void ListaTope(int cantMax);

    //Inicio
    public void setInicio(NodoLista i);
    public NodoLista getInicio();

    //Fin
    public void setFin(NodoLista f);
    public NodoLista getFin();

    /*****Métodos Básicos*****/

    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia();

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(NodoLista nodo);

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(NodoLista nodo);

    //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio();

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin();

 //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar();
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar();

/*****Otros Métodos (iterativos)*****/

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(NodoLista nodo);
        //lista vacía o primer elemento es mayor o igual => agrego al ppio
        //último elemento es menor o igual => agrego al final

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(NodoLista nodo);
    
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();

    //PRE: //POS:
    public NodoLista obtenerElemento(NodoLista nodo);

    
    /*****  Métodos RECURSIVOS  *****/

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoLista nodo);

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoLista nodo);

    
    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
        public boolean existeDatoREC(NodoLista nodo, T n);

       public boolean pertenece(T x);

    public void borrar (T x) ;
    
    public int largo ();

    public void snoc (T x);
    
    public void snocR (NodoLista indice,T x);
    
    public ListaTope invertir();
    
    public boolean estaOrdenada ();  
    
    public int largoR (NodoLista nodo);
    
    public void borrarR (NodoLista nodo, T x);

    public boolean perteneceR(NodoLista nodo,T x) ;    
    
}
