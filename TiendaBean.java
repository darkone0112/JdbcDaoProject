/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author osboxes
 */
public class TiendaBean implements TiendaInterface{
    private int ID;
    private String nombre;
    private String direccion;
    private int cp ;
    private String pais;
    private String provincia;
    private String email;
    private String telefono;
    private int empresaid;
    private java.sql.Connection conexionA=null;
    
    public TiendaBean() {
        
    }

    public int getId(){
        return this.ID;
    }
    public String getNombre(){
        return nombre; // no es obligatorio poner this
    }
    public String getDireccion(){
        return direccion;
    }
    public int getCP(){
        return cp;
    }
    public String getPais(){
        return pais;
    }
    public String getProvincia(){
        return provincia;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefono(){
        return telefono;
    } 
    public int getEmpresaid(){
        return empresaid;
    }
    //METODO PARA ESTABLECER LA CONEXIÓN
private java.sql.Connection getConexionTienda(){
        //Cargar el driver
        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver"); //Obtener el driver
             Class.forName("com.mysql.jdbc.Driver"); //Obtener el driver
        }catch (ClassNotFoundException e){
            System.out.println("No se encuentra la clase del Driver");
            return null; //devuelve null si va mal
        }
        
        Connection conexion= null;
        try {          
//    conexionA=DriverManager.getConnection("jdbc:oracle:thin:@192.168.33.228:1521:orcl","blanca","blanca");
       conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoFinal","root", "");
        } catch (SQLException e){
            System.out.println("No se puede obtener la conexión");
            return null;
        }
        return conexion;
    }
//METODOS SET
public void  setNombre(String nombre){
conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;
        
        try{
            sentencia= conexionA.createStatement();
sentencia.execute("UPDATE TIENDA SET NOMBRE='"+nombre+
                    "'WHERE ID='"+this.ID+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de nombre sobre Tienda");
            return;
        }
this.nombre=nombre;
}
public void  setDireccion(String direccion){
        
       conexionA=getConexionTienda();
       java.sql.Statement sentencia = null;
        try{
            sentencia= conexionA.createStatement(); //se crea la sentencia
        
                     sentencia.execute("UPDATE TIENDA SET DIRECCION'"+direccion+
                    "'WHERE ID='"+this.ID+"'");
 //modifico el nombre, con el nombre que nos dan de aquel cuyo expdiente coincida con el objeto actual
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de  ciclo sobre TIENDA");
            return;
        }
       
        this.direccion=direccion;
}
public void  setCP(int cp){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE TIENDA SET CP='"+cp+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre TIENDA");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.cp=cp;
    }
public void  setPais(String pais){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE TIENDA SET PAIS='"+pais+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre TIENDA");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.pais=pais;
    }
public void  setProvincia(String provincia){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE TIENDA SET PROVINCIA='"+provincia+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre TIENDA");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.provincia=provincia;
}
public void  setEmail(String email){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE TIENDA SET EMAIL='"+email+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre TIENDA");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.email=email;
    }
public void  setTelefono(String telefono){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE TIENDA SET TELEFONO='"+telefono+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre TIENDA");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.telefono=telefono;
    }
public void  setEmpresaId(int empresaid){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE TIENDA SET EMPRESAID='"+empresaid+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre TIENDA");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.empresaid=empresaid;
    }
//METODOS FIND
        
 public TiendaInterface getTiendaPorID(int ID){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;
        TiendaBean tienda= null;   

  try{
            sentencia= conexionA.createStatement(); //se crea la sentencia
        
             tienda=new TiendaBean();
            //se le da valor ejecutandola
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery(	
                "SELECT * FROM TIENDA"+   	 
                    "WHERE ID='"+ID+"'");
  
           while(resultado.next()){						
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                       
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Empresa por ID sobre EMPRESA");
            return null;
        }
        return tienda;

     }
    public java.util.Collection getTiendaPorNombre(String nombre){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;
       
       TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector(); 	
            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE NOMBRE='"+ nombre+"'");
            
            while(resultado.next()){
                tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Alumno por ciclo sobre ALUMNO");
            return null;
        }
        return coleccion;    // Devuelve una colección de alumnos.
    }

    
    public java.util.Collection getTiendaPorDireccion(String direccion){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE DIRECCION='"+direccion+"'");
  
 
           while(resultado.next()){
tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
                
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Alumno por nombre sobre ALUMNO");
            return null;
        }
        return coleccion;
    }

    public java.util.Collection getTiendaPorCP(int cp){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE CP='"+cp+"'");
  
 
           while(resultado.next()){
tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Alumno por nombre sobre ALUMNO");
            return null;
        }
        return coleccion;
    }
    public java.util.Collection getTiendaPorPais(String pais){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE PAIS='"+pais+"'");
  
 
           while(resultado.next()){
                tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Alumno por nombre sobre ALUMNO");
            return null;
        }
        return coleccion;
    }
    public java.util.Collection getTiendaPorProvincia(String email){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE EMAIL='"+provincia+"'");
  
 
           while(resultado.next()){
                tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Alumno por nombre sobre ALUMNO");
            return null;
        }
        return coleccion;
    } 
    public java.util.Collection getTiendaPorEmail(String email){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE EMAIL='"+email+"'");
  
 
           while(resultado.next()){
                tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Alumno por nombre sobre ALUMNO");
            return null;
        }
        return coleccion;
    }  
    public java.util.Collection getTiendaPorTelefono(String telefono){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE TELEFONO='"+telefono+"'");
  
 
           while(resultado.next()){
                tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de tienda por nombre sobre Tienda");
            return null;
        }
        return coleccion;
    }
    public java.util.Collection getTiendaPorEmpresaId(int empresaid){
        conexionA=getConexionTienda();
        java.sql.Statement sentencia = null;   
        TiendaBean tienda= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM TIENDA"+     
                    "WHERE EMPRESAID='"+empresaid+"'");
  
 
           while(resultado.next()){
                tienda =new TiendaBean();
                tienda.ID=resultado.getInt("ID");
                tienda.nombre=resultado.getString("NOMBRE");
                tienda.direccion=resultado.getString("DIRECCION");
                tienda.cp=resultado.getInt("CP");
                tienda.pais=resultado.getString("PAIS");
                tienda.provincia=resultado.getString("PROVINCIA");
                tienda.email=resultado.getString("EMAIL");
                tienda.telefono=resultado.getString("TELEFONO");
                tienda.empresaid=resultado.getInt("EMPRESAID");
                coleccion.add(tienda);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de TIENDA por nombre sobre TIENDA");
            return null;
        }
        return coleccion;
    }
//METODO DE BORRADO
  public void delete() {
        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 

            sentencia.execute("DELETE FROM TIENDA  WHERE ID='"+this.ID+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error  DELETE   sobre TIENDA");
            return;
        };
          this.cp=0;
          this.email=null;
          this.telefono=null;
          this.pais=null;
          this.provincia=null;
          this.direccion=null;
          this.ID=0;
          this.empresaid=0;
          this.conexionA=null;
          this.nombre=null;
         
        }

//METODO INSERT
public TiendaInterface getNuevoTienda(String nombre,String direccion, int cp,String pais,String provincia,String email,String telefono,int empresaid){

        conexionA=getConexionTienda();
        java.sql.Statement sentencia=null;
        
        
        try{
            sentencia=conexionA.createStatement();
            sentencia.execute(
                    "INSERT INTO TIENDA(nombre,direccion,cp,pais,provincia,email,telefono,empresaid) VALUES ('"+nombre+"','"+ 
                    direccion+"','"+cp+"','"+pais+"','"+provincia+"','"+email+"','"+telefono+"','"+empresaid+"')");
            
 //                   "INSERT INTO ciclo(codciclo,denciclo,grado) VALUES ('"+codciclo+"','"+
 //                   descripcion+"','"+grado+" ')"); 
                    
            }catch(SQLException e){  
                System.out.println("Error SQL al insertar TIENDA"+ e.getMessage());
                        return null;
            }
        //Instanciamos alumno nuevo y le damos los valores a sus atributos
        TiendaBean tienda= new TiendaBean(); 
        
        
        tienda.nombre=nombre;
        tienda.direccion=direccion;
        tienda.cp=cp;
        tienda.email=email;
        tienda.pais=pais;
        tienda.provincia=provincia;
        tienda.telefono=telefono;
        tienda.empresaid=empresaid;
//devuelvo el objeto alumno
        return tienda;
  }

}
