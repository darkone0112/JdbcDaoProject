/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMPRESA;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osboxes
 */
public class EmpresaBean implements EmpresaInterface{
    private int id;
    private String nombre;
    private String direccion;
    private int cp;
    private String pais;
    private String email;
    private String telefono;
    private java.sql.Connection conn;
    private java.sql.Statement statement;
    
    public void loadJDBC(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e);
        }
    }
    
    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PF", "root", "");
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
    }
    public EmpresaBean(){
    }
    public EmpresaBean(int id, String nombre,String direccion,int cp, String pais, String email,String telefono){
        this.id= id;
        this.nombre= nombre;
        this.direccion= direccion;
        this.cp= cp;
        this.pais= pais;
        this.email= email;
        this.telefono = telefono;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDireccion(){
        return nombre;
    }
    public void setDireccion(String direccion){
        this.nombre=direccion;
    }
    public int getCp(){
        return cp;
    }
    public void setCp(int cp){
        this.cp=cp;
    }
    public String getPais(){
        return pais;
    }
    public void setPais(String pais){
        this.pais=pais;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet executeQuery(Connection conn, String query) {
        
        statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    public void displayAllEmpresas(Connection conn, DefaultTableModel model) {
        try {
            String query = "SELECT * FROM EMPRESA";
            ResultSet rs = executeQuery(conn, query);
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"),
                    rs.getString("DIRECCION"),
                    rs.getInt("CP"),
                    rs.getString("PAIS"),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFONO"),
                });
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e);
        }
    }
    public void addEmpresa(Connection conn) {
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField paisField = new JTextField();
        JTextField cpField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField telefonoField = new JTextField();
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("id:"));
        panel.add(idField);
        panel.add(new JLabel("nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("direccion:"));
        panel.add(direccionField);
        panel.add(new JLabel("cp:"));
        panel.add(cpField);
        panel.add(new JLabel("pais:"));
        panel.add(paisField);
        panel.add(new JLabel("email:"));
        panel.add(emailField);
        panel.add(new JLabel("telefono:"));
        panel.add(telefonoField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Empresa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = conn.createStatement();
                setId(Integer.parseInt(idField.getText()));
                setNombre(nombreField.getText());
                setDireccion(direccionField.getText());
                setCp(Integer.parseInt(cpField.getText()));
                setPais(paisField.getText());
                setEmail(emailField.getText());
                setTelefono(telefonoField.getText());
                String query = "INSERT INTO EMPRESA (ID, NOMBRE, DIRECCION, CP,PAIS,EMAIL,TELEFONO) VALUES ('" + getId() + "', '" + getNombre() + "','" + getDireccion() + "','" + getCp() + "', '" + getPais() + "','" + getEmail() + "','" + getTelefono() +"')";
                statement.executeUpdate(query);
                System.out.println("Empresa added successfully.");
                System.out.println("hola"+getId()+getNombre()+getDireccion()+getCp()+getPais()+getEmail()+getTelefono());
            } catch (SQLException e) {
                System.out.println("Error adding videogame: " + e);
            }
        
        }
    }
    public void deleteEmpresa(Connection conn) {
        JTextField idField = new JTextField();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("id:"));
        panel.add(idField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Empresa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = conn.createStatement();
                setId(Integer.parseInt(idField.getText()));
                String query = "DELETE FROM EMPRESA WHERE ID = '" + getId() + "'";
                statement.executeUpdate(query);
                System.out.println("Empresa deleted successfully.");
            } catch (SQLException e) {
                System.out.println("Error deleting studio: " + e);
            }
        }
    }
    public void updateEmpresa(Connection conn) {
     JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField paisField = new JTextField();
        JTextField cpField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField telefonoField = new JTextField();
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("id:"));
        panel.add(idField);
        panel.add(new JLabel("nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("direccion:"));
        panel.add(direccionField);
        panel.add(new JLabel("pais:"));
        panel.add(paisField);
        panel.add(new JLabel("cp:"));
        panel.add(cpField);
        panel.add(new JLabel("email:"));
        panel.add(emailField);
        panel.add(new JLabel("telefono:"));
        panel.add(telefonoField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Empresa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement =  conn.createStatement();
                setId(Integer.parseInt(idField.getText()));
                setNombre(nombreField.getText());
                setDireccion(direccionField.getText());
                setCp(Integer.parseInt(cpField.getText()));
                setPais(paisField.getText());
                setEmail(emailField.getText());
                setTelefono(telefonoField.getText());
                String query = "UPDATE EMPRESA SET NOMBRE = '" + getNombre() + "', DIRECCION = '" + getDireccion() + "', CP = '" + getCp() + "',PAIS ='" + getPais() + "',EMAIL = '"+getEmail()+"', TELEFONO = '"+getTelefono()+"' WHERE  ID = '" + getId() + "'";
                statement.executeUpdate(query);
                System.out.println("EMPRESA updated successfully.");  
            } catch (SQLException e) {
                System.out.println("Error updating studio: " + e);
            }
        }
    }   
}
