/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricanteDAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author osboxes
 */
public class FabricanteBean implements FabricanteInterface{
       private int ID;
    private String nombre;
    private String direccion;
    private int cp ;
    private String pais;
    private String email;
    private String telefono;
    private String pagina_web;
    private java.sql.Connection conexionA=null;
    
    public FabricanteBean() {
        
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
    public String getEmail(){
        return email;
    }
    public String getTelefono(){
        return telefono;
    } 
    public String getPagina_web(){
        return pagina_web;
    }
    //METODO PARA ESTABLECER LA CONEXIÓN
private java.sql.Connection getConexionFabricante(){
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
conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;
        
        try{
            sentencia= conexionA.createStatement();
            sentencia.execute("UPDATE FABRICANTE SET NOMBRE='"+nombre+
                    "'WHERE ID='"+this.ID+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de nombre sobre FABRICANTE");
            return;
        }
this.nombre=nombre;
}
public void  setDireccion(String direccion){
        
       conexionA=getConexionFabricante();
       java.sql.Statement sentencia = null;
        try{
            sentencia= conexionA.createStatement(); //se crea la sentencia
        
                     sentencia.execute("UPDATE FABRICANTE SET DIRECCION'"+direccion+
                    "'WHERE ID='"+this.ID+"'");
 //modifico el nombre, con el nombre que nos dan de aquel cuyo expdiente coincida con el objeto actual
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de  ciclo sobre FABRICANTE");
            return;
        }
       
        this.direccion=direccion;
}
public void  setCP(int cp){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE FABRICANTE SET CP='"+cp+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre FABRICANTE");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.cp=cp;
    }
public void  setPais(String pais){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE FABRICANTE SET PAIS='"+pais+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre FABRICANTE");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.pais=pais;
    }
public void  setEmail(String email){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE FABRICANTE SET EMAIL='"+email+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre FABRICANTE");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.email=email;
    }
public void  setTelefono(String telefono){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE FABRICANTE SET TELEFONO='"+telefono+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre FABRICANTE");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.telefono=telefono;
    }
public void  setPagina_web(String pagina_web){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE FABRICANTE SET PAGINA_WEB='"+pagina_web+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre FABRICANTE");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.pagina_web=pagina_web;
    }
//METODOS FIND
        
 public FabricanteInterface getFabricantePorID(int ID){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;
        FabricanteBean fabricante= null;   

  try{
            sentencia= conexionA.createStatement(); //se crea la sentencia
        
             fabricante=new FabricanteBean();
            //se le da valor ejecutandola
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery(	
                "SELECT * FROM FABRICANTE"+   	 
                    "WHERE ID='"+ID+"'");
  
           while(resultado.next()){						
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                       
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Empresa por ID sobre FABRICANTE");
            return null;
        }
        return fabricante;

     }
    public java.util.Collection getFabricantePorNombre(String nombre){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;
       
       FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector(); 	
            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE NOMBRE='"+ nombre+"'");
            
            while(resultado.next()){
                fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de nombre por ciclo sobre FABRICANTE");
            return null;
        }
        return coleccion;    // Devuelve una colección de alumnos.
    }

    
    public java.util.Collection getFabricantePorDireccion(String direccion){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;   
        FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE DIRECCION='"+direccion+"'");
  
 
           while(resultado.next()){
                 fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de FABRICANTE por nombre sobre FABRICANTE");
            return null;
        }
        return coleccion;
    }

    public java.util.Collection getFabricantePorCP(int cp){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;   
        FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE CP='"+cp+"'");
  
 
           while(resultado.next()){
                fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de FABRICANTE por nombre sobre FABRICANTE");
            return null;
        }
        return coleccion;
    }
    public java.util.Collection getFabricantePorPais(String pais){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;   
        FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE PAIS='"+pais+"'");
  
 
           while(resultado.next()){
                fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de FABRICANTE por nombre sobre FABRICANTE");
            return null;
        }
        return coleccion;
    }
    public java.util.Collection getFabricantePorEmail(String email){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;   
        FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE EMAIL='"+email+"'");
  
 
           while(resultado.next()){
                 fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de FABRICANTE por nombre sobre FABRICANTE");
            return null;
        }
        return coleccion;
    }  
    public java.util.Collection getFabricantePorTelefono(String telefono){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;   
        FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE TELEFONO='"+telefono+"'");
  
 
           while(resultado.next()){
                 fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de FABRICANTE por nombre sobre FABRICANTE");
            return null;
        }
        return coleccion;
    }
    public java.util.Collection getFabricantePorPagina_web(String pagina_web){
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia = null;   
        FabricanteBean fabricante= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM FABRICANTE"+     
                    "WHERE PAGINA_WEB='"+pagina_web+"'");
  
 
           while(resultado.next()){
                 fabricante =new FabricanteBean();
                fabricante.ID=resultado.getInt("ID");
                fabricante.nombre=resultado.getString("NOMBRE");
                fabricante.direccion=resultado.getString("DIRECCION");
                fabricante.cp=resultado.getInt("CP");
                fabricante.pais=resultado.getString("PAIS");
                fabricante.email=resultado.getString("EMAIL");
                fabricante.telefono=resultado.getString("TELEFONO");
                fabricante.pagina_web=resultado.getString("PAGINA_WEB");
                coleccion.add(fabricante);
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de FABRICANTE por nombre sobre FABRICANTE");
            return null;
        }
        return coleccion;
    }
//METODO DE BORRADO
  public void delete() {
        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 

            sentencia.execute("DELETE FROM FABRICANTE  WHERE ID='"+this.ID+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error  DELETE   sobre FABRICANTE");
            return;
        };
          this.cp=0;
          this.email=null;
          this.telefono=null;
          this.pais=null;
          this.direccion=null;
          this.ID=0;
          this.pagina_web=null;
          this.conexionA=null;
          this.nombre=null;
         
        }

//METODO INSERT
public FabricanteInterface getNuevoFabricante(String nombre,String direccion, int cp,String pais,String email,String telefono,String pagina_web){

        conexionA=getConexionFabricante();
        java.sql.Statement sentencia=null;
        
        
        try{
            sentencia=conexionA.createStatement();
            sentencia.execute(
                    "INSERT INTO FABRICANTE(nombre,direccion,cp,pais,email,telefono,pagina_web) VALUES ('"+nombre+"','"+ 
                    direccion+"','"+cp+"','"+pais+"','"+email+"','"+telefono+"','"+pagina_web+"')");
            
 //                   "INSERT INTO ciclo(codciclo,denciclo,grado) VALUES ('"+codciclo+"','"+
 //                   descripcion+"','"+grado+" ')"); 
                    
            }catch(SQLException e){  
                System.out.println("Error SQL al insertar FABRICANTE"+ e.getMessage());
                        return null;
            }
        //Instanciamos alumno nuevo y le damos los valores a sus atributos
        FabricanteBean fabricante= new FabricanteBean(); 
        
        
        fabricante.nombre=nombre;
        fabricante.direccion=direccion;
        fabricante.cp=cp;
        fabricante.email=email;
        fabricante.pais=pais;
        fabricante.telefono=telefono;
        fabricante.pagina_web=pagina_web;
//devuelvo el objeto alumno
        return fabricante;
  }
}
