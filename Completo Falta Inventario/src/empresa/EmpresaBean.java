package empresa;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    private ResultSet resultSet;

    public void loadJDBC(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e);
        }
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "pirata");
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
    }
    public void addEmpresa() {
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField paisField = new JTextField();
        JTextField cpField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField telefonoField = new JTextField();


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Id:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Direccion:"));
        panel.add(direccionField);
        panel.add(new JLabel("Cp:"));
        panel.add(cpField);
        panel.add(new JLabel("Pais:"));
        panel.add(paisField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Telefono:"));
        panel.add(telefonoField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Empresa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = conn.createStatement();
            } catch (SQLException e) {
                System.out.println("Error adding Empresa: " + e);
            }
            setId(Integer.parseInt(idField.getText()));
            setNombre(nombreField.getText());
            setDireccion(direccionField.getText());
            setCp(Integer.parseInt(cpField.getText()));
            setPais(paisField.getText());
            setEmail(emailField.getText());
            setTelefono(telefonoField.getText());
            String query = "INSERT INTO EMPRESA (ID, NOMBRE, DIRECCION, CP,PAIS,EMAIL,TELEFONO) VALUES ('" + getId() + "', '" + getNombre() + "','" + getDireccion() + "','" + getCp() + "', '" + getPais() + "','" + getEmail() + "','" + getTelefono() +"')";
           try{
                statement.executeUpdate(query);
           }catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.out.println("Empresa added successfully.");
                JOptionPane.showMessageDialog(null, "Empresa agregado con éxito");
        }
    }
    public void deleteEmpresa(DefaultTableModel model, int selectedRow) {
          if (selectedRow == -1) {
            // No row is selected
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected company?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            int selectedEmployeeId = (Integer) model.getValueAt(selectedRow, 0);

            try {
                String sql = "DELETE FROM EMPRESA WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, selectedEmployeeId);
                statement.executeUpdate();
                model.removeRow(selectedRow);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting company: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
          }
    }
    public void updateEmpresa(DefaultTableModel model, int selectedRow) {
        JTextField idField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 0)));
        JTextField nombreField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 1)));
        JTextField direccionField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 2)));
        JTextField cpField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 3)));
        JTextField paisField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 4)));
        JTextField emailField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 5)));
        JTextField telefonoField = new JTextField(String.valueOf(model.getValueAt(selectedRow, 6)));


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Id:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Direccion:"));
        panel.add(direccionField);
        panel.add(new JLabel("Cp:"));
        panel.add(cpField);
        panel.add(new JLabel("Pais:"));
        panel.add(paisField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Telefono:"));
        panel.add(telefonoField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Actualizar Empresa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = conn.createStatement();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setId(Integer.parseInt(idField.getText()));
            setNombre(nombreField.getText());
            setDireccion(direccionField.getText());
            setCp(Integer.parseInt(cpField.getText()));
            setPais(paisField.getText());
            setEmail(emailField.getText());
            setTelefono(telefonoField.getText());
            String query = "UPDATE EMPRESA SET NOMBRE = '" + getNombre() + "', DIRECCION = '" + getDireccion() + "', CP = '" + getCp() + "',PAIS ='" + getPais() + "',EMAIL = '"+getEmail()+"', TELEFONO = '"+getTelefono()+"' WHERE  ID = '" + Integer.parseInt(idField.getText()) + "'";
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
            // TODO Auto-generated catch block
                e.printStackTrace();
            }
            model.setValueAt(getId(), selectedRow, 0);
            model.setValueAt(getNombre(), selectedRow, 1);
            model.setValueAt(getDireccion(), selectedRow, 2);
            model.setValueAt(getCp(), selectedRow, 3);
            model.setValueAt(getPais(), selectedRow, 4);
            model.setValueAt(getEmail(), selectedRow, 5);
            model.setValueAt(getTelefono(), selectedRow, 6);
        }
    }
    public void findEmpresaById(DefaultTableModel model) {
        JTextField textIdField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new javax.swing.JLabel("Id que quiere buscar"));
        panel.add(textIdField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Buscar Empresa", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION) {
            try {
                statement = conn.createStatement();
                String query = "SELECT * from EMPRESA where ID = "+ Integer.parseInt(textIdField.getText())+ ";";

                ResultSet rs = statement.executeQuery(query);
                model.setRowCount(0);
                System.out.println(rs);
                while (rs.next()) {
                    model.addRow(new Object[]{
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
        } catch(SQLException e) {
            System.out.println("Error buscando empresa:" + e);
        }

        }
    }
    public void displayAllEmpresas(DefaultTableModel model) {
        try {
            String query = "SELECT * FROM EMPRESA";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            model.setRowCount(0);
            System.out.println(rs);
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
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
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
    public java.sql.Statement getStatement() {
        return statement;
    }
    public void setStatement(Connection conn) {
        this.statement = statement;
    }
    public ResultSet getResultSet() {
        return resultSet;
    }
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
