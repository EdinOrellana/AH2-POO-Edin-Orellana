/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edin1
 */
public class Controlador {

    

  public  void guardar(String codigo, String nombre, String nit, String correo, String genero) {
        Modelo.datos.add(new Modelo( codigo,  nombre,  nit,  correo,  genero));
        
    }
 public   void Actualizar(String codigo, String nombre, String nit, String correo, String genero, int id){
        Modelo.datos.set(id,new Modelo( codigo,  nombre,  nit,  correo,  genero));
    }
 public DefaultTableModel TablaClientes() {
        String[] Columnas = {"Codigo", "Nombre", "NIT", "correo", "Genero"};
        DefaultTableModel modelo = new DefaultTableModel(null, Columnas);
        for (Modelo sp : Modelo.datos) {
            String[] filas = new String[5];
            filas[0] = sp.getCodigo();
            filas[1] = sp.getNombre();
            filas[2] = sp.getNit();
            filas[3] = sp.getCorreo();
            filas[4] = sp.getGenero();
            modelo.addRow(filas);
        }
        return modelo;
    }
   }
