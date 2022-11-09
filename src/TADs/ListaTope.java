package TADs;

public class ListaTope<T extends Comparable<T>> implements IListaTope<T>{
    private NodoLista inicio;
    private NodoLista fin;
    private int cantidad;
    private int tope;
   
    
    //Constructor
    @Override
    public void ListaTope(int cantMax){
        this.inicio=null;
        this.fin=null;
        this.cantidad = 0;
        this.tope = cantMax;
    }
    //Inicio
    @Override
    public void setInicio(NodoLista nodo){
        inicio=nodo;
    }
    @Override
    public NodoLista getInicio(){
        return inicio;
    }

    //Fin
    @Override
    public void setFin(NodoLista nodo){
        fin=nodo;
    }
    @Override
    public NodoLista getFin(){
        return fin;
    }

    /*****Métodos Básico
     * @return s*****/

    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia(){
        return (this.inicio==null);
      }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public void agregarInicio(NodoLista nodo){
        if(cantidad < tope) {
            if(this.esVacia()) {
                this.setFin(nodo);
            } else {
                nodo.setSig(this.getInicio());
            }
            this.setInicio(nodo);
            cantidad++;
        }
        
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(NodoLista nodo){

        if(cantidad < tope) {
            if(this.esVacia()){
                this.setInicio(nodo);
            } else {
                this.getFin().setSig(nodo);
            }
                this.setFin(nodo);
                cantidad++;
        }
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public void borrarInicio(){
     
        if(!this.esVacia()) {
            this.setInicio(this.getInicio().getSig());
            cantidad--;
        }
    }

    //PRE:
    //POS: Borra el último nodo
    @Override
    public void borrarFin(){
        
        if(!this.esVacia()){
            if(this.getInicio() == this.getFin()) {
                this.borrarInicio();
            } else {
                NodoLista aux = this.getInicio();
                while(aux.getSig() != this.getFin()) {
                    aux = aux.getSig();
                } 
                this.setFin(aux);
                aux.setSig(null);
            }
            
        }
        
        if (!this.esVacia()){
            if (this.inicio==this.fin)
                this.borrarInicio();
            else{
                NodoLista aux = this.inicio;
                while (aux.getSig() != this.fin){
                    aux=aux.getSig();
                }
                this.fin=aux;
                this.fin.setSig(null);
            }
        }
    }
    
    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio!=null)
            borrarInicio();
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrar(){
        if (this.esVacia())
            System.out.println("Lista es vacía");
        else  {
            NodoLista aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getDato().toString());
                aux=aux.getSig();
            }
        }
    }


/*****Otros Métodos (iterativos
     * @param nodo)*****/

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    @Override
    public void agregarOrd(NodoLista nodo){
        //lista vacía o primer elemento es mayor o igual => agrego al ppio
        if (this.esVacia() || this.inicio.getDato().compareTo(nodo.getDato())== -1 ){
            this.agregarInicio(nodo);
            return;
        }
        NodoLista aux=this.inicio;
        while (aux!=this.fin && aux.getSig().getDato().compareTo(nodo.getDato())>=0){
            aux=aux.getSig();
        }
        if (aux!=fin){
            nodo.setSig(aux.getSig());
            aux.setSig(nodo);
        } else {
            this.agregarFinal(nodo);
        }
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    @Override
    public void borrarElemento(NodoLista nodo){
        if (this.esVacia()){
            return;
        }
        if (this.inicio.getDato().equals(nodo.getDato())){
            this.borrarInicio();
            return;
        }
        if (this.fin.getDato()==nodo.getDato()){
            this.borrarFin();
            return;
        }
        
        NodoLista aux=this.inicio;
       
        while (aux.getSig()!=null && aux.getSig().getDato().compareTo(nodo.getDato()) != 0)
            aux=aux.getSig();
        //lo encontré o llegué al final de la lista
        if (aux.getSig()!=null){
            NodoLista borrar=aux.getSig();
            aux.setSig(borrar.getSig());
            borrar.setSig(null);
        }
    }
    
    
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    @Override
    public int cantElementos(){
        int cont=0;
        if (!this.esVacia()){
            NodoLista aux=this.inicio;
            while (aux!=null){
                 aux=aux.getSig();
                 cont ++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    @Override
    public NodoLista obtenerElemento(NodoLista nodo){
        NodoLista aux=this.inicio;
        while (aux!=null && aux.getDato().compareTo(nodo.getDato()) != 0)
            aux=aux.getSig();
        //encontré dato o llegué al final
        return aux;
    }

    
    /*****  Métodos RECURSIVOS
     * @param nodo *****/

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    @Override
    public void mostrarREC(NodoLista nodo){
        if(nodo!=null){
            System.out.println(nodo.getDato());
            mostrarREC(nodo.getSig());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    @Override
    public void mostrarInversoREC(NodoLista nodo){
        if (nodo!=null){   
            mostrarInversoREC(nodo.getSig());
            System.out.println(nodo.getDato());
        }
    }
    
    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    @Override
    public boolean existeDatoREC(NodoLista nodo, T n){
        if (nodo != null){
            if (nodo.getDato().equals(n)){
                return true;
            }
            else{
                return existeDatoREC(nodo.getSig(),n);
            }    
        }
        else {
             return false;
        }     
    }



    @Override
    public boolean pertenece(T x) {
 
        if (this.esVacia()){
            return false;
        }
        else {
            
            NodoLista aux = this.inicio;
            while (aux!=null){
                if (aux.getDato().equals(x)){
                    return true;
                }
                aux=aux.getSig();
            }
        }
        return false;
    }

    @Override
    public boolean perteneceR(NodoLista nodo,T x) {
 
        if (nodo==null){
            return false;
        }
        if (this.esVacia()){
            return false;
        }
        else {
            if (nodo.getDato().equals(x)){
                return true;
            }
            else
            {
                return perteneceR(nodo.getSig(),x);
            }
        }
    }

    @Override
    public void borrar (T x) {
        if( this.esVacia()) {

            return;
        }
       
        if (this.inicio.getDato().equals(x)){
            if (this.inicio==this.fin){
                this.fin = this.inicio = null;
            } else {
                this.inicio=this.inicio.getSig();
            }            
            return;
        }
            
        NodoLista aux =  this.inicio;      
        while (aux.getSig()!=null){
            if (aux.getSig().getDato()==x){
                if (aux.getSig()==this.fin){
                  this.fin = aux;  
                } 
                aux.setSig(aux.getSig().getSig());
                return;
            }
            aux = aux.getSig();
        }
    }  

    @Override
    public void borrarR (NodoLista nodo, T x) {
        if( this.esVacia()){
            return;
        }

        if (this.inicio==nodo && nodo.getDato().equals(x)){
            if (this.inicio.equals(this.fin)){
               this.fin = this.inicio = null;
            } else {
               this.inicio=this.inicio.getSig();
            }
            return;
        }
    
        if (nodo.getSig()==null){
            return;
        }
        
        if (nodo.getSig().getDato().equals(x)){
           if (nodo.getSig()==this.fin){
               this.fin = nodo;  
            } 
            nodo.setSig(nodo.getSig().getSig());
            return;
        }
        borrarR(nodo.getSig(),x);
        
    }  
    
    @Override
    public int largo () {
        int cantidad = 0;
        if (!this.esVacia()){
            NodoLista aux = this.inicio;
            while (aux!=null){
                cantidad = cantidad +1;
                aux = aux.getSig();
            }
        }
        return cantidad;
    }

    @Override
    public int largoR (NodoLista nodo) {
        if (nodo==null){
            return 0;
        }
        else {
            return 1 + largoR(nodo.getSig());
        }
    }
    
    @Override
    public void snoc (T x){
        NodoLista nuevo = new NodoLista(x);
        if (this.esVacia()){
            this.inicio=this.fin=nuevo;
        }
        NodoLista aux = this.inicio;
        while (aux!=fin){
            aux = aux.getSig();
        }
        aux.setSig(nuevo);
        this.fin=nuevo;
    }
    
    @Override
    public void snocR (NodoLista indice,T x){
        if (this.esVacia()){
           NodoLista nuevo = new NodoLista(x);
           this.inicio=this.fin=nuevo;
           return;
        }
        if (indice!=this.fin){
            snocR(indice.getSig(),x);
        } else {
            NodoLista nuevo = new NodoLista(x);
            this.fin.setSig(nuevo);
            this.fin=nuevo;
        }
    }
    
    @Override
    public ListaTope invertir(){

        ListaTope listaInvertida = new ListaTope();
        
        if (this.esVacia()){
            return listaInvertida;
            
        }   
        
        listaInvertida.setInicio(new NodoLista(this.fin.getDato()));
        NodoLista nodoListaInv = listaInvertida.getInicio();
        
        NodoLista nodoIndice = this.fin;
           
        while (nodoIndice!=this.inicio){
            
             NodoLista aux = this.inicio;
            while (aux.getSig()!=nodoIndice){
                aux= aux.getSig();
            }
            
            nodoIndice = aux;
            
            NodoLista nuevo = new NodoLista(aux.getDato()) ;
            nodoListaInv.setSig(nuevo);
            nodoListaInv = nuevo;
            listaInvertida.setFin(nuevo);

        }            
        
        return listaInvertida;
    }    

    @Override
    public boolean estaOrdenada (){

        if (this.esVacia()){
            return true;
        }
        NodoLista aux = this.inicio;
        
        while (aux.getSig() != fin) {
            if (aux.getDato().compareTo(aux.getSig().getDato())==1){
                return false;
            }
            aux = aux.getSig();
        }
        return true;
        
    }
       

}