/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author usuario
 */
public class Camion implements Comparable<Camion> {
    private String matricula;
    private int toneladasMaxSoportadas;
    
    public Camion(String matricula, int toneladas) {
        this.matricula = matricula;
        this.toneladasMaxSoportadas = toneladas;
    }
    
    public Camion(String matricula) {
        this.matricula = matricula;
    }
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

    /**
     * @return the toneladasMaxSoportadas
     */
    public int getToneladasMaxSoportadas() {
        return toneladasMaxSoportadas;
    }

    /**
     * @param toneladasMaxSoportadas the toneladasMaxSoportadas to set
     */
    public void setToneladasMaxSoportadas(int toneladasMaxSoportadas) {
        this.toneladasMaxSoportadas = toneladasMaxSoportadas;
    }


    @Override
    public int compareTo(Camion o) {
        return this.matricula.compareTo(o.matricula);
    }
    
    public boolean equals(Object o) {
        Camion camion = (Camion) o;
        return this.matricula.compareTo(camion.matricula) == 0;
    }
    
    public String toString() {
        return this.matricula + " - " + this.toneladasMaxSoportadas + "kg";
    }
}
