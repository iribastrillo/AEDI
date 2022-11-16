
package Entidades;

public class Cliente implements Comparable<Cliente>{
 
    private String nombre;
    private String rut;
    private int tel;
    private String direccion;

    public  Cliente(String nombre,String rut,int tel,String direccion){
        this.nombre = nombre;
        this.rut = rut;
        this.tel = tel;
        this.direccion= direccion;
    }
    
    public Cliente (String rut) {
        this.rut = rut;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.getNombre().compareTo(o.getNombre());
    }
    
    @Override
    public String toString(){
      return "Nombre: " + this.getNombre();
    }    
    
    @Override
    public boolean equals(Object o) {
        Cliente cliente = (Cliente) o;
        return this.rut.compareTo(cliente.rut) == 0;
    }

}
