/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author usuario
 */
public class Producto implements Comparable<Producto> {

    
    private static int codigo = 1;
    private int codigoProd;
    private String nombre;
    private String descripcion;

    public Producto(String nombre, String descripcion) {
        this.codigoProd = codigo;
        codigo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
    @Override
    public int compareTo(Producto o) {
        return this.nombre.compareTo(o.nombre);
    }
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigoProd;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the producto to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        Producto producto = (Producto) o;
        return this.nombre.compareTo(producto.nombre) == 0;
    }
    
    public String toString(){
      return "Producto: " + this.getCodigo() + " - " + this.getNombre() + " / " + this.getDescripcion();
    }    
    
}
