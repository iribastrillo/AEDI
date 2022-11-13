/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author usuario
 */
public class PedidoEspera implements Comparable<PedidoEspera> {

    private String matriculaCamion;
    private String rutCliente;
    private int codProducto;
    private int cantUnidades;
    
    public PedidoEspera(String matricula, String rut, int codigoProd, int unidades) {
        this.matriculaCamion = matricula;
        this.rutCliente = rut;
        this.codProducto = codigoProd;
        this.cantUnidades = unidades;
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
     * @return the rutCliente
     */
    public String getRutCliente() {
        return rutCliente;
    }

    /**
     * @param rutCliente the rutCliente to set
     */
    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
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
    public int compareTo(PedidoEspera o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
    @Override
    public String toString() {
        return "Matricula: " + this.getMatriculaCamion() + " - Rut: " + this.getRutCliente() + " - Cod. Prod: " + this.getCodProducto() + " - Cantidad: " + this.getCantUnidades();
    }

}
