/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiante;

/**
 *
 * @author edin1
 */
public class Modelo {

    /**
     * @return the IdEstudiante
     */
    public int getIdEstudiante() {
        return IdEstudiante;
    }

    /**
     * @param IdEstudiante the IdEstudiante to set
     */
    public void setIdEstudiante(int IdEstudiante) {
        this.IdEstudiante = IdEstudiante;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Edad
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * @param Edad the Edad to set
     */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    /**
     * @return the Promedio
     */
    public double getPromedio() {
        return Promedio;
    }

    /**
     * @param Promedio the Promedio to set
     */
    public void setPromedio(double Promedio) {
        this.Promedio = Promedio;
    }

    public Modelo(int IdEstudiante, String Nombre, String Apellido, int Edad, double Promedio) {
        this.IdEstudiante = IdEstudiante;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Promedio = Promedio;
    }

    private int IdEstudiante;
    private String Nombre, Apellido;
    private int Edad;
    private double Promedio;

}
