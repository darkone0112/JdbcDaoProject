/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpresaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author osboxes
 */
public class EmpresaBean implements EmpresaInterface{
      private int ID;
    private String nombre;
    private String direccion;
    private int cp ;
    private String pais;
    private String email;
    private String telefono;
    private java.sql.Connection conexionA=null;
    
    public EmpresaBean() {
        
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
    //METODO PARA ESTABLECER LA CONEXIÓN
private java.sql.Connection getConexionEmpresa(){
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
conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;
        
        try{
            sentencia= conexionA.createStatement();
sentencia.execute("UPDATE EMPRESA SET NOMBRE='"+nombre+
                    "'WHERE ID='"+this.ID+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de nombre sobre ALUMNO");
            return;
        }
this.nombre=nombre;
}
public void  setDireccion(String direccion){
        
       conexionA=getConexionEmpresa();
       java.sql.Statement sentencia = null;
        try{
            sentencia= conexionA.createStatement(); //se crea la sentencia
        
                     sentencia.execute("UPDATE EMPRESA SET DIRECCION'"+direccion+
                    "'WHERE ID='"+this.ID+"'");
 //modifico el nombre, con el nombre que nos dan de aquel cuyo expdiente coincida con el objeto actual
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de  ciclo sobre ALUMNO");
            return;
        }
       
        this.direccion=direccion;
}
public void  setCP(int cp){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE EMPRESA SET CP='"+cp+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre ALUMNO");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.cp=cp;
    }
public void  setPais(String pais){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE EMPRESA SET PAIS='"+pais+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre ALUMNO");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.pais=pais;
    }
public void  setEmail(String email){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE EMPRESA SET EMAIL='"+email+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre ALUMNO");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.email=email;
    }
public void  setTelefono(String telefono){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 
        
            sentencia.execute("UPDATE EMPRESA SET TELEFONO='"+telefono+
                    "'WHERE ID='"+this.ID+"'");
             sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de dni sobre ALUMNO");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.telefono=telefono;
    }
//METODOS FIND
        
 public EmpresaInterface getEmpresaPorID(int ID){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;
        EmpresaBean empresa= null;   

  try{
            sentencia= conexionA.createStatement(); //se crea la sentencia
        
             empresa=new EmpresaBean();
            //se le da valor ejecutandola
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery(	
                "SELECT * FROM EMPRESA"+   	 
                    "WHERE ID='"+ID+"'");
  
           while(resultado.next()){						
                empresa.ID=resultado.getInt("ID");
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("EMAIL");
                empresa.telefono=resultado.getString("TELEFONO");
                
                       
           }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Empresa por ID sobre EMPRESA");
            return null;
        }
        return empresa;

     }
    public java.util.Collection getEmpresaPorNombre(String nombre){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;
       
       EmpresaBean empresa= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector(); 	
            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM EMPRESA"+     
                    "WHERE NOMBRE='"+ nombre+"'");
            
            while(resultado.next()){
                empresa =new EmpresaBean();
                empresa.ID=resultado.getInt("ID"); 
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("emial");
                empresa.telefono=resultado.getString("TELEFONO");
                coleccion.add(empresa);
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

    
    public java.util.Collection getEmpresaPorDireccion(String direccion){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;   
        EmpresaBean empresa= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM EMPRESA"+     
                    "WHERE DIRECCION='"+direccion+"'");
  
 
           while(resultado.next()){
                empresa =new EmpresaBean();
                empresa.ID=resultado.getInt("ID"); 
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("emial");
                empresa.telefono=resultado.getString("TELEFONO");
                coleccion.add(empresa);
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

        public java.util.Collection getEmpresaPorCP(int cp){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;   
        EmpresaBean empresa= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM EMPRESA"+     
                    "WHERE CP='"+cp+"'");
  
 
           while(resultado.next()){
                empresa =new EmpresaBean();
                empresa.ID=resultado.getInt("ID"); 
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("emial");
                empresa.telefono=resultado.getString("TELEFONO");
                coleccion.add(empresa);
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
            public java.util.Collection getEmpresaPorPais(String pais){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;   
        EmpresaBean empresa= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM EMPRESA"+     
                    "WHERE PAIS='"+pais+"'");
  
 
           while(resultado.next()){
                empresa =new EmpresaBean();
                empresa.ID=resultado.getInt("ID"); 
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("emial");
                empresa.telefono=resultado.getString("TELEFONO");
                coleccion.add(empresa);
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
                public java.util.Collection getEmpresaPorEmail(String email){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;   
        EmpresaBean empresa= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM EMPRESA"+     
                    "WHERE EMAIL='"+email+"'");
  
 
           while(resultado.next()){
                empresa =new EmpresaBean();
                empresa.ID=resultado.getInt("ID"); 
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("emial");
                empresa.telefono=resultado.getString("TELEFONO");
                coleccion.add(empresa);
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
        public java.util.Collection getEmpresaPorTelefono(String telefono){
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia = null;   
        EmpresaBean empresa= null;  
        java.util.Collection coleccion =null;
        
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         

            java.sql.ResultSet resultado;
            
            resultado = sentencia.executeQuery( 
                    "SELECT * FROM EMPRESA"+     
                    "WHERE TELEFONO='"+telefono+"'");
  
 
           while(resultado.next()){
                empresa =new EmpresaBean();
                empresa.ID=resultado.getInt("ID"); 
                empresa.nombre=resultado.getString("NOMBRE");
                empresa.direccion=resultado.getString("DIRECCION");
                empresa.cp=resultado.getInt("CP");
                empresa.pais=resultado.getString("PAIS");
                empresa.email=resultado.getString("emial");
                empresa.telefono=resultado.getString("TELEFONO");
                coleccion.add(empresa);
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
//METODO DE BORRADO
  public void delete() {
        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexionA.createStatement(); 

            sentencia.execute("DELETE FROM EMPRESA  WHERE ID='"+this.ID+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error  DELETE   sobre Empresa");
            return;
        };
          this.cp=0;
          this.email=null;
          this.telefono=null;
          this.pais=null;
          this.direccion=null;
          this.ID=0;
          this.conexionA=null;
          this.nombre=null;
         
        }

//METODO INSERT
public EmpresaInterface getNuevoEmpresa(String nombre,String direccion, int cp,String pais,String email,String telefono){

        conexionA=getConexionEmpresa();
        java.sql.Statement sentencia=null;
        
        
        try{
            sentencia=conexionA.createStatement();
            sentencia.execute(
                    "INSERT INTO EMPRESA(nombre,direccion,cp,pais,email,telefono) VALUES ('"+nombre+"','"+ 
                    direccion+"','"+cp+"','"+pais+"','"+email+"','"+telefono+"')");
            
 //                   "INSERT INTO ciclo(codciclo,denciclo,grado) VALUES ('"+codciclo+"','"+
 //                   descripcion+"','"+grado+" ')"); 
                    
            }catch(SQLException e){  
                System.out.println("Error SQL al insertar Empresa"+ e.getMessage());
                        return null;
            }
        //Instanciamos alumno nuevo y le damos los valores a sus atributos
        EmpresaBean empresa= new EmpresaBean(); 
        
        
        empresa.nombre=nombre;
        empresa.direccion=direccion;
        empresa.cp=cp;
        empresa.email=email;
        empresa.pais=pais;
        empresa.telefono=telefono;
//devuelvo el objeto alumno
        return empresa;
  }


    

}
