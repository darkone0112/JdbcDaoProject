/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osboxes
 */
public interface EmpresaInterface {
    public void loadJDBC();
    public void connect();
    public void addEmpresa();
    public void deleteEmpresa(DefaultTableModel model, int selectedRow);
    public void updateEmpresa(DefaultTableModel model, int selectedRow);
    public void findEmpresaById(DefaultTableModel model);
    public void displayAllEmpresas(DefaultTableModel model);
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
    public Connection getConn();
    public void setConn(Connection conn);
    public java.sql.Statement getStatement();
    public void setStatement(Connection conn);
    public ResultSet getResultSet();
    public void setResultSet(ResultSet resultSet);
}
