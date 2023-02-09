import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoBean {
    private String nombre;
    private String apellido;
    private String dni;
    private String fecna;
    private String email;
    private int empresaid;
    private int tiendaid;
    private String direccion;
    private String telefono;
    private Connection conn;
    private Statement statement;
    
    public void loadJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e);
        }
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionEmpresaDB", "VsCode", "2458");
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
    }
    
    public void addEmpleado(String nombre, String apellido, String dni, String fecna, String email, int empresaid, int tiendaid, String direccion, String telefono) {
        try {
            statement = conn.createStatement();
            String sql = "INSERT INTO empleados (nombre, apellido, dni, fecna, email, empresaid, tiendaid, direccion, telefono) " +
                         "VALUES ('" + nombre + "','" + apellido + "','" + dni + "','" + fecna + "','" + email + "'," + empresaid + "," + tiendaid + ",'" + direccion + "','" + telefono + "')";
            statement.executeUpdate(sql);
            System.out.println("Empleado added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding empleado: " + e);
        }
    }
    
    public void updateEmpleado(int id, String nombre, String apellido, String dni, String fecna, String email, int empresaid, int tiendaid, String direccion, String telefono) {
        try {
            statement = conn.createStatement();
            String sql = "UPDATE empleados SET nombre='" + nombre + "', apellido='" + apellido + "', dni='" + dni + "', fecna='" + fecna + "', email='" + email + "', empresaid=" + empresaid + ", tiendaid=" + tiendaid + ", direccion='" + direccion + "', telefono='" + telefono + "' WHERE id=" + id;
            statement.executeUpdate(sql);
            System.out.println("Empleado updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating empleado: " + e);
        }
    }
    
    public void deleteEmpleado(int id) {
        try {
            statement = conn.createStatement();
            String sql = "DELETE FROM empleados WHERE id=" + id;
            statement.executeUpdate(sql);
            System.out.println("Empleado deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting empleado: " + e);
        }
    }
    public EmpleadoBean findEmpleadoById(int id) {
        EmpleadoBean empleado = null;
        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM empleados WHERE id = " + id + ";");
            while (result.next()) {
                empleado = new EmpleadoBean(
                    result.getString("nombre"),
                    result.getString("apellido"),
                    result.getString("dni"),
                    result.getString("fecna"),
                    result.getString("email"),
                    result.getInt("empresaid"),
                    result.getInt("tiendaid"),
                    result.getString("direccion"),
                    result.getString("telefono")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error searching for employee: " + e);
        }
        return empleado;
    }
    public void displayAllEmployees() {
        try {
            String query = "SELECT * FROM empleado";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("ID\tNombre\tApellido\tDNI\tFecna\tEmail\tEmpresaid\tTiendaid\tDireccion\tTelefono");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String fecna = rs.getString("fecna");
                String email = rs.getString("email");
                int empresaid = rs.getInt("empresaid");
                int tiendaid = rs.getInt("tiendaid");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                System.out.println(id + "\t" + nombre + "\t" + apellido + "\t" + dni + "\t" + fecna + "\t" + email + "\t" + empresaid + "\t" + tiendaid + "\t" + direccion + "\t" + telefono);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying employees: " + e);
        }
    }
    

    public EmpleadoBean() {
    }
    public EmpleadoBean(String nombre, String apellido, String dni, String fecna, String email, int empresaid, int tiendaid, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecna = fecna;
        this.email = email;
        this.empresaid = empresaid;
        this.tiendaid = tiendaid;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getFecna() {
        return fecna;
    }
    public void setFecna(String fecna) {
        this.fecna = fecna;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getEmpresaid() {
        return empresaid;
    }
    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }
    public int getTiendaid() {
        return tiendaid;
    }
    public void setTiendaid(int tiendaid) {
        this.tiendaid = tiendaid;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public Statement getStatement() {
        return statement;
    }
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
