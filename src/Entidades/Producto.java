/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import TADs.Cola;

/**
 *
 * @author usuario
 */
public class Producto implements Comparable<Producto> {


    private static int codigoSig = 1;
    private int codigo;
    private String nombre;
    private String descripcion;
    private Cola Espera;
    private Cola cajas;
    private Cola envios;

    public Producto(String nombre, String descripcion) {
        this.codigo = codigoSig;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.Espera = new Cola();
        this.cajas = new Cola();
        this.envios = new Cola();
        codigoSig++;
    }
    
    public Producto (String nombre) {
        this.nombre = nombre;
    }
    
    public Producto(int codigo){
        this.codigo = codigo;
    }
    
    
    @Override
    public int compareTo(Producto o) {
        if(this.codigo == o.codigo) {
            return 0;
        }
        return -1;
    }
   
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString(){
      return "Producto: cod. " + this.getCodigo() + " - " + this.getNombre() + " / " + this.getDescripcion();
    }    
    /**
     * @return the cajas
     */
    public Cola getCajas() {
        return cajas;
    }

    /**
     * @param cajas the cajas to set
     */
    public void setCajas(Cola cajas) {
        this.cajas = cajas;
    }
    
    public boolean tengoCajas() {
        return !this.getCajas().esVacia();
    }
    
    /**
     * @return the listaEspera
     */
    public Cola getEspera() {
        return Espera;
    }

    /**
     * @param listaEspera the listaEspera to set
     */
    public void setEspera(Cola listaEspera) {
        this.Espera = listaEspera;
    }
        /**
     * @return the envios
     */
    public Cola getEnvios() {
        return envios;
    }

    /**
     * @param envios the envios to set
     */
    public void setEnvios(Cola envios) {
        this.envios = envios;
    }


}
