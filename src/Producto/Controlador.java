/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edin1
 */
public class Controlador {

    

  public  void guardar(String codigo, String nombre, String descripcion, String cantidad, String precio) {
        Modelo.getDatos().add(new Modelo( codigo,  nombre,  descripcion,  cantidad,  precio));
        
    }
 public   void Actualizar(String codigo, String nombre, String descripcion, String cantidad, String precio, int id){
        Modelo.getDatos().set(id,new Modelo(codigo,  nombre,  descripcion,  cantidad,  precio));
    }
 public DefaultTableModel TablaProductos() {
        String[] Columnas = {"Codigo", "Nombre", "Descripción", "Cantidad", "Precio"};
        DefaultTableModel modelo = new DefaultTableModel(null, Columnas);
        for (Modelo sp : Modelo.getDatos()) {
            String[] filas = new String[5];
            filas[0] = sp.getCodigo();
            filas[1] = sp.getNombre();
            filas[2] = sp.getDescripcion();
            filas[3] = sp.getCantidad();
            filas[4] = sp.getPrecio();
            modelo.addRow(filas);
        }
        return modelo;
    }
   }
