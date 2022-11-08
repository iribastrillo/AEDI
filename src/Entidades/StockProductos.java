/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author usuario
 */
public class StockProductos implements Comparable<StockProductos> {

    private String matriculaCamion;
    private String codProducto;
    private int nroCaja;
    private int cantUnidades;
    
    public StockProductos(){
        
    }
    
    public StockProductos(String matricula, String codigo, int caja, int unidades) {
        this.matriculaCamion = matricula;
        this.codProducto = codigo;
        this.nroCaja = caja;
        this.cantUnidades = unidades;
    }

    @Override
    public int compareTo(StockProductos o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * @return the matriculaCamion
     */
    public String getMatriculaCamion() {
        return matriculaCamion;
    }

    /**
     * @param matriculaCamion the matriculaCamion to set
     */
    public void setMatriculaCamion(String matriculaCamion) {
        this.matriculaCamion = matriculaCamion;
    }

    /**
     * @return the codProducto
     */
    public String getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(String codProducto) {
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
    
    @Override
    public boolean equals(Object o) {
        StockProductos stPro = (StockProductos) o;
        return this.nroCaja == stPro.nroCaja;
    }
    
    public String toString() {
        return this.getCodProducto() + " - " + this.getMatriculaCamion() + " - " + this.getNroCaja() + " - " + this.getCantUnidades();
    }

}
