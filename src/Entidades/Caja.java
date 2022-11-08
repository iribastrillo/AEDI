/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author usuario
 */
public class Caja implements Comparable<Caja> {
    
    private int codProducto;
    private int nroCaja;
    private int cantUnidades;

    public Caja(int codProducto, int nroCaja, int cantUnidades) {
        this.codProducto = codProducto;
        this.nroCaja = nroCaja;
        this.cantUnidades = cantUnidades;
    }

    public Caja(int nroCaja) {
        this.nroCaja = nroCaja;
    }
    @Override
    public int compareTo(Caja o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the codProducto
     */
    public int getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    /**
     * @return the nroCaja
     */
    public int getNroCaja() {
        return nroCaja;
    }

    /**
     * @param nroCaja the nroCaja to set
     */
    public void setNroCaja(int nroCaja) {
        this.nroCaja = nroCaja;
    }

    /**
     * @return the cantUnidades
     */
    public int getCantUnidades() {
        return cantUnidades;
    }

    /**
     * @param cantUnidades the cantUnidades to set
     */
    public void setCantUnidades(int cantUnidades) {
        this.cantUnidades = cantUnidades;
    }
    
    public boolean equals(Caja c) {
        return c.getNroCaja() == this.getNroCaja();
    }
            
}
