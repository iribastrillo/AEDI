/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Admin
 */
public class Envio implements Comparable<Envio> {

    private String rut;
    private int cantidad;
    private int codProd;
    private String matricula;

    public Envio (String rut, int cantidad, int codProd, String matricula) {
        this.cantidad = cantidad;
        this.rut = rut;
        this.codProd = codProd;
        this.matricula = matricula;
    }
  
    /**
     * @return the cod
     */
    public int getCod() {
        return codProd;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.codProd = cod;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @return the cliente
     */
    

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * @return the camion
     */
    
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
  
    @Override
    public int compareTo(Envio o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
