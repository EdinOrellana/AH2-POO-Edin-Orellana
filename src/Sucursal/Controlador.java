/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;



import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edin1
 */
public class Controlador {

    

  public  void guardar(String codigo, String nombre, String direccion, String correo, String telefono) {
        Modelo.getDatos().add(new Modelo( codigo,  nombre,  direccion,  correo,  telefono));
        
    }
 public   void Actualizar(String codigo, String nombre, String direccion, String correo, String telefono, int id){
        Modelo.getDatos().set(id,new Modelo( codigo,  nombre,  direccion,  correo,  telefono));
    }
 public DefaultTableModel TablaSucursales() {
        String[] Columnas = {"Codigo", "Nombre", "Direccion", "correo", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(null, Columnas);
        for (Modelo sp : Modelo.getDatos()) {
            String[] filas = new String[5];
            filas[0] = sp.getCodigo();
            filas[1] = sp.getNombre();
            filas[2] = sp.getDireccion();
            filas[3] = sp.getCorreo();
            filas[4] = sp.getTelefono();
            modelo.addRow(filas);
        }
        return modelo;
    }
   }
