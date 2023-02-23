/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author edin1
 */
public abstract class Productoelectronico {

    double precio;
    String marca;
    String modelo;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}

class Telefonomovil extends Productoelectronico {

    private int capacidadAlmacenamiento;
    private int duracionBateria;

    public int getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public int getDuracionBateria() {
        return duracionBateria;
    }

    public void setDuracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
    }
    
    class Tableta extends Productoelectronico{
        private double tamaño;
        private String resolocionPantalla;

        /**
         * @return the tamaño
         */
        public double getTamaño() {
            return tamaño;
        }

        /**
         * @param tamaño the tamaño to set
         */
        public void setTamaño(double tamaño) {
            this.tamaño = tamaño;
        }

        /**
         * @return the resolocionPantalla
         */
        public String getResolocionPantalla() {
            return resolocionPantalla;
        }

        /**
         * @param resolocionPantalla the resolocionPantalla to set
         */
        public void setResolocionPantalla(String resolocionPantalla) {
            this.resolocionPantalla = resolocionPantalla;
        }
        
    }

}
