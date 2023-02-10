/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRODUCTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author osboxes
 */
public class ProductoBean implements ProductoInterface{
    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Integer id_fabricante;
    private java.sql.Connection conexion=null;

    public ProductoBean() {
    }
    public void setId(int id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return nombre; // no es obligatorio poner this
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre; // no es obligatorio poner this
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public Double getPrecio(){
        return precio;
    }
    public void setId_fabricante(int id_fabricante){
        this.id_fabricante = id_fabricante;
    }
    public Integer getId_Fabricante(){
        return id_fabricante;
    }

    //METODO PARA ESTABLECER LA CONEXIÓN
    private java.sql.Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("No se encuentra la clase del Driver");
            return null;
        }
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/PF","root", "");
            
            
        } catch (SQLException e){
            System.out.println("No se puede obtener la conexión");
            return null;
        }
        return conexion;
    }
    
    //METODOS update
    public void  updateNombre(String nombre, Integer id){
        conexion=getConexion();
        java.sql.Statement sentencia = null;

        try{
            sentencia= conexion.createStatement();
            sentencia.execute("UPDATE PRODUCTO SET NOMBRE='" + nombre + "'WHERE ID = '" + id + "'");
            System.out.println("\n******** Se ha modificado el nombre del producto ********");
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error en UPDATE de nombre sobre Producto");
            return;
        }
        this.nombre=nombre;
    }
    
    
    public void  updateId_fabricante(Integer id_fabricante, Integer id){

        conexion=getConexion();
        java.sql.Statement sentencia = null;
         try{
            sentencia= conexion.createStatement(); //se crea la sentencia

            sentencia.execute("UPDATE PRODUCTO SET FABRICANTEID = '" + id_fabricante + "'WHERE ID ='" + id + "'");
            System.out.println("\n******** Se ha modificado el id_fabricante del producto ********");
            sentencia.close();
            conexion.close();
         }catch (SQLException e){
             System.out.println("Error en UPDATE de  id del fabricante sobre producto");
             return;
         }

         this.id_fabricante = id_fabricante;
    }

    public void  updatePrecio(Double precio, Integer id){
            conexion=getConexion();
            java.sql.Statement sentencia=null;
             try{
                sentencia= conexion.createStatement(); 

                sentencia.execute("UPDATE PRODUCTO SET PRECIO ='" + precio + "'WHERE ID = '" + id + "'");
                System.out.println("\n******** Se ha modificado el precio del producto ********");
                 sentencia.close();
                conexion.close();
            }catch (SQLException e){
                System.out.println("Error en UPDATE de precio sobre produco");
                return;
            }catch (Exception e){
                System.out.println(e.getClass());
                return;
            }

            this.precio = precio;
        }
    public void  updateDescripcion(String descripcion, Integer id){
            conexion=getConexion();
            java.sql.Statement sentencia=null;
             try{
                sentencia= conexion.createStatement(); 

                sentencia.execute("UPDATE PRODUCTO SET DESCRIPCION ='" + descripcion + "'WHERE ID = '" + id + "'");
                System.out.println("\n******** Se ha modificado la descripcion del producto ********");
                 sentencia.close();
                conexion.close();
            }catch (SQLException e){
                System.out.println("Error en UPDATE de precio sobre produco");
                return;
            }catch (Exception e){
                System.out.println(e.getClass());
                return;
            }

            this.descripcion = descripcion;
        }

    //METODOS FIND
    
    public ProductoBean getProductoPorId(Integer id){
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        ProductoBean producto= null;   

        try{
            sentencia= conexion.createStatement(); //se crea la sentencia
        
            producto = new ProductoBean();
            
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRODUCTO WHERE ID ='"+id+"'");
            
            System.out.println("\n**********BUSQUEDA POR ID DE PRODUCTO**********");
            
            while(resultado.next()){						
                producto.id=resultado.getInt("ID");
                producto.nombre=resultado.getString("NOMBRE");
                producto.descripcion=resultado.getString("DESCRIPCION");
                producto.precio=resultado.getDouble("PRECIO");
                producto.id_fabricante=resultado.getInt("FABRICANTEID");
                System.out.println("ID: " + producto.id + " NOMBRE: "+ producto.nombre + " PRECIO: " + producto.precio + " ID_FABRICANTE: "+ producto.id_fabricante);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Producto por id sobre Producto");
            return null;
        }
        return producto;
    }       
    

        

    //METODO DE BORRADO
    public void delete(Integer id) {
            conexion=getConexion();
            java.sql.Statement sentencia=null;
             try{
                sentencia= conexion.createStatement(); 

                sentencia.execute("DELETE FROM PRODUCTO  WHERE ID = '"+ id +"'");
                System.out.println("\n******** Se ha borrado el producto ********");
                sentencia.close();
                conexion.close();
            }catch (SQLException e){
                System.out.println("Error  DELETE   sobre Producto");
                return;
            };

    }

    //METODO INSERT
    public ProductoBean getNuevoProducto(Integer id,String nombre,String descripcion, Double precio, Integer id_fabicante){

            conexion=getConexion();
            java.sql.Statement sentencia=null;


            try{
                sentencia=conexion.createStatement();
                sentencia.execute(
                        "INSERT INTO PRODUCTO(ID,NOMBRE,DESCRIPCION,PRECIO,FABRICANTEID) VALUES ('"+id+"','"+ 
                        nombre+"','"+descripcion+"','"+precio+"','"+ id_fabicante +"')");
                System.out.println("\n******** Se ha insertado el producto ********");
                }catch(SQLException e){  
                    System.out.println("Error SQL al insertar Producto"+ e.getMessage());
                            return null;
                }
            //Instanciamos alumno nuevo y le damos los valores a sus atributos
            ProductoBean product= new ProductoBean(); 

            product.id = id;
            product.precio = precio;
            product.nombre=nombre;
            product.id_fabricante = id_fabricante;
    //devuelvo el objeto alumno
            return product;
      }
}
