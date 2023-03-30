package Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador {

    void ValidacionVacio(int IdEstudiante, String Nombre, String Apellido, int Edad, double Promedio, boolean BanderaGuardar, Connection cn) {
        if (BanderaGuardar) {
            Guardar( Nombre, Apellido, Edad, Promedio, cn);
            Vista.Limpiar();
        } else {
            Actualizar(IdEstudiante, Nombre, Apellido, Edad, Promedio, cn);
            BanderaGuardar = true;

            Vista.Limpiar();
        }
    }

    void GuardarActualizar(int IdEstudiante, String Nombre, String Apellido, int Edad, double Promedio, boolean BanderaGuardar, Connection cn) {
        ValidacionVacio(IdEstudiante, Nombre, Apellido, Edad, Promedio, BanderaGuardar, cn);
    }

    void Guardar(String Nombre, String Apellido, int Edad, double Promedio, Connection cn) {
        try {
            String Consulta = "INSERT INTO estudiantes(Nombre,Apellido,Edad,Promedio) VALUES(?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(Consulta);
            pst.setString(1, Nombre);
            pst.setString(2, Apellido);
            pst.setInt(3, Edad);
            pst.setDouble(4, Promedio);
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Guardado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Guardar");
            e.printStackTrace();
        }
    }

    static DefaultTableModel tabla(Connection cn, String Busqueda) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String consulta = "SELECT * from estudiantes where Nombre LIKE'%" + Busqueda + "%' or Apellido LIKE'%" + Busqueda + "%'";
            ArrayList<Modelo> Datos = new ArrayList<>();
            Statement pr = cn.createStatement();
            ResultSet rs = pr.executeQuery(consulta);
            while (rs.next()) {
                Datos.add(new Modelo(rs.getInt("IdEstudiantes"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Edad"), rs.getDouble("Promedio")));
            }
            rs.close();
            pr.close();
            String[] Titulo = {"No", "IdEstudiantes", "Nombre","Apellido", "Edad","Promedio"};
            modelo.setColumnIdentifiers(Titulo);
            for (int x = 0; x < Datos.size(); x++) {
                String[] datos = new String[6];
                datos[0] = String.valueOf(x + 1);
                datos[1] = String.valueOf(Datos.get(x).getIdEstudiante());
                datos[2] = Datos.get(x).getNombre();
                datos[3] = Datos.get(x).getApellido();
                datos[4] = String.valueOf(Datos.get(x).getEdad());
                datos[5] = String.valueOf(Datos.get(x).getPromedio());
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Cargando Tabla");
        }
        return modelo;
    }

    void Actualizar(int IdEstudiante, String Nombre, String Apellido, int Edad, double Promedio, Connection cn) {
        try {
            String Consulta = "update estudiantes set Nombre='" + Nombre + "',Apellido='" + Apellido + "',Edad='" + Edad + "',Promedio='" + Promedio + "' where IdEstudiante='" + IdEstudiante + "'";
            PreparedStatement pr = cn.prepareStatement(Consulta);
            pr.executeUpdate();
            pr.close();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList obtener(Connection cn, String Busqueda) {
        ArrayList<Modelo> Datos = new ArrayList();
        try {
            String consulta = "SELECT * from estudiantes where IdEstudiantes='" + Busqueda + "'";
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(consulta);
            if (rs.next()) {
               Datos.add(new Modelo(rs.getInt("IdEstudiantes"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Edad"), rs.getDouble("Promedio")));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Datos;
    }

}
