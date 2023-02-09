/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMPRESA;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author osboxes
 */
public interface EmpresaInterface {
    public void loadJDBC();
    public void connect();
    public ResultSet executeQuery(Connection conn, String query);
    public int getId();
    public void setId(int id);
    public String getNombre();
    public void setNombre(String nombre);
    public String getDireccion();
    public void setDireccion(String direccion);
    public int getCp();
    public void setCp(int cp);
    public String getPais();
    public void setPais(String pais);
    public String getEmail();
    public void setEmail(String email);
    public String getTelefono();
    public void setTelefono(String telefono);
    public void displayAllEmpresas(Connection conn, DefaultTableModel model); 
    public void addEmpresa(Connection conn) ;
    public void deleteEmpresa(Connection conn);
    public void updateStudio(Connection conn);
}
