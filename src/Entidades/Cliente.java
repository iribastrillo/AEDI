
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
        return Integer.valueOf(rut);
    }
    public String toString(){
      return "Nombre:" + this.getNombre();
    }    
}
