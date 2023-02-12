/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osboxes
 */
public interface EmpleadoInterface {
    public void loadJDBC();
    public void connect();
    public void addEmpleado();
    public void updateEmpleado(DefaultTableModel model, int selectedRow);
    public void deleteEmpleado(DefaultTableModel model, int selectedRow);
    public void findEmpleadoById(DefaultTableModel model);
    public void displayAllEmployees(DefaultTableModel model);
    public String getNombre();
    public void setNombre(String nombre);
    public String getApellido();
    public void setApellido(String apellido);
    public String getDni();
    public void setDni(String dni);
    public String getFecna();
    public void setFecna(String fecna);
    public String getEmail();
    public void setEmail(String email);
    public int getEmpresaid();
    public void setEmpresaid(int empresaid);
    public int getTiendaid();
    public void setTiendaid(int tiendaid);
    public String getTelefono();
    public void setTelefono(String telefono);
    public Connection getConn();
    public void setConn(Connection conn);
    public Statement getStatement();
    public void setStatement(Statement statement);
    public ResultSet getResultSet();
    public void setResultSet(ResultSet resultSet);
    public int getId();
    public void setId(int id);
}
