/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRODUCTO;

/**
 *
 * @author osboxes
 */
public interface ProductoInterface {  
    public Integer getId();
    public String getNombre();
    public String getDescripcion();
    public Double getPrecio();   
    public Integer getId_Fabricante();
    public void setId(int id);
    public void setDescripcion(String descripcion);
    public void setNombre(String nombre);
    public void setPrecio(double precio);
    public void setId_fabricante(int id_fabricante);
    
    public void updateNombre(String nombre,Integer id);
    public void updateDescripcion(String descripcion,Integer id);
    public void updateId_fabricante(Integer id_fabricante, Integer id);
    public void updatePrecio(Double precio, Integer id);            

   
    public ProductoInterface getProductoPorId(Integer id);
    
    public void delete(Integer id);
   
    public ProductoInterface getNuevoProducto(Integer id,String nombre,String descripcion,Double precio, Integer id_fabricante);
    
}
