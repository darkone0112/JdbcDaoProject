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
public class main {
    public static void main(String[] args) {
        ProductoInterface objetoDAO = ProductoGalery.getProductoDao();
        
       
        ProductoInterface  producto1 = objetoDAO.getNuevoProducto(30,"locotron","mariconnnnnnnnnnnn", 41.00 , 1 );
        ProductoInterface  producto2 = objetoDAO.getProductoPorId(20);
   
    }
    
}
