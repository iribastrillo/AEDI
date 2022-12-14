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
    
    private int nroCaja;
    private int cantUnidades;

    public Caja(int nroCaja, int cantUnidades) {
        this.nroCaja = nroCaja;
        this.cantUnidades = cantUnidades;
    }

    public Caja(int nroCaja) {
        this.nroCaja = nroCaja;
    }
    @Override
    public int compareTo(Caja o) {
        if(this.getNroCaja() == o.getNroCaja()) {
            return 0;
        }
        return -1;    
    }
    
    @Override
    public String toString() {
        return "--------- Caja nro. " + this.getNroCaja() + ". " + this.getCantUnidades() + " un.";
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
