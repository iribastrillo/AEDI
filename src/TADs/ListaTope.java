package TADs;

public class ListaTope<T extends Comparable<T>> implements ILista<T> {

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(NodoLista<T> inicio) {
        this.inicio = inicio;
    }

    private NodoLista<T> inicio;
    private NodoLista<T> fin;
    private int cantidad;
    private int tope;

    //Constructor   
    public ListaTope(int cantMax) {
        inicio = null;
        fin = null;
        cantidad = 0;
        tope = cantMax;
    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
    }

    @Override
    public void agregarInicio(NodoLista n) {

        if (cantidad < tope) {
            if (esVacia()) {
                this.setInicio(n);
                this.fin = inicio;
            } else {
                nuevo.setSiguiente(getInicio());
                setInicio(nuevo);
            }

            cantidad++;

        }

    }

    @Override
    public void agregarFinal(T n) {

        if (cantidad < tope) {

            Nodo<T> nuevo = new Nodo(n);

            if (this.esVacia()) {
                agregarInicio(n);
            } else {

                fin.setSiguiente(nuevo);
                fin = nuevo;
                cantidad++;
            }

        }

    }

    @Override
    public void borrarInicio() {

        if (!esVacia()) {
            Nodo<T> borrar = inicio;
            if (cantidad == 1) {
                vaciar();
            } else {
                setInicio(inicio.getSiguiente());
                borrar.setSiguiente(null); // desengancho el nodo a eliminar  
                cantidad--;

            }
        }

    }

    @Override
    public void borrarFin() {

        if (!this.esVacia()) {
            //Si tiene un solo elemento
            if (cantidad == 1) {
                vaciar();
            } else {
                Nodo<T> actual = getInicio();

                while (actual.getSiguiente() != fin) {
                    actual = actual.getSiguiente();
                }

                actual.setSiguiente(null);
                fin = actual;
                cantidad--;
            }
        }
    }

    @Override
    public void mostrar() {

        Nodo<T> mostrar = getInicio();

        while (mostrar != null) {

            System.out.println(mostrar.getDato().toString() );
            mostrar = mostrar.getSiguiente();
        }

        System.out.println("");

    }

    @Override
    public void vaciar() {
        setInicio(null);
        fin = null;
        cantidad = 0;
    }

    @Override
    public void borrarElemento(T n) {

        if (!this.esVacia()) {

            if (inicio.getDato().compareTo(n) == 0) {
                borrarInicio();
            } else {
                if (fin.getDato().compareTo(n) == 0) {
                    borrarFin();
                } else {

                    Nodo<T> aux = inicio;
                    while (aux.getSiguiente() != fin && aux.getSiguiente().getDato().compareTo(n) != 0) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() != null) {
                        Nodo<T> aBorrar = aux.getSiguiente();
                        aux.setSiguiente(aBorrar.getSiguiente());
                        aBorrar.setSiguiente(null);
                        cantidad--;
                    }

                }

            }

        }
    }

    @Override
    public Nodo<T> obtenerElemento(T n) {

        Nodo<T> ret = null;

        if (!this.esVacia()) {

            if (inicio.getDato().compareTo(n) == 0) {
                ret = inicio;
            } else {

                if (fin.getDato().compareTo(n) == 0) {
                    ret = fin;
                } else {

                    Nodo<T> actual = getInicio();

                    while (actual != fin && actual.getDato().compareTo(n) != 0) {
                        actual = actual.getSiguiente();
                    }

                    if (actual.getDato().compareTo(n) == 0) {
                        ret = actual;
                    }

                }

            }

        }

        return ret;
    }

    @Override
    public void agregarOrd(T n) {

        if (cantidad < tope) {

            if (esVacia() || n.compareTo(inicio.getDato()) < 0) {
                agregarInicio(n); 
            } else {

                if (n.compareTo(fin.getDato()) > 0) {
                    agregarFinal(n);
                } else {

                    Nodo<T> aux = inicio;

                    while (aux.getSiguiente() != fin && n.compareTo(aux.getSiguiente().getDato()) >0 ) {
                        aux = aux.getSiguiente();
                    }

                    Nodo<T> nuevo = new Nodo(n);
                    nuevo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nuevo);
                    cantidad++;
                }

            }

        }

    }

    @Override
    public void mostrarREC(Nodo<T> n) {

        if (n != null) {
            System.out.print(n.getDato().toString() + " - ");
            mostrarREC(n.getSiguiente());
        }
    }

    public NodoLista getInicio() {
        return inicio;
    }

    /**
     * @return the tope
     */
    public int getTope() {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(int tope) {
        this.tope = tope;
    }

}
