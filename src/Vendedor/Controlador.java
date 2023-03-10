/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edin1
 */
public class Controlador {

    

  public  void guardar(String codigo, String nombre, String caja, String ventas, String genero, String password) {
        Modelo.datos.add(new Modelo(codigo, nombre, caja, ventas, genero, password));
        
    }
 public   void Actualizar(String codigo, String nombre, String caja, String ventas, String genero, String password, int id){
        Modelo.datos.set(id,new Modelo(codigo, nombre, caja, ventas, genero, password));
    }
 public DefaultTableModel TablaVentas() {
        String[] Columnas = {"Codigo", "Nombre", "Caja", "ventas", "Genero"};
        DefaultTableModel modelo = new DefaultTableModel(null, Columnas);
        for (Modelo sp : Modelo.datos) {
            String[] filas = new String[5];
            filas[0] = sp.getCodigo();
            filas[1] = sp.getNombre();
            filas[2] = sp.getCaja();
            filas[3] = sp.getVentas();
            filas[4] = sp.getGenero();
            modelo.addRow(filas);
        }
        return modelo;
    }
   }
