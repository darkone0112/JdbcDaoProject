/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricanteDAO;

/**
 *
 * @author osboxes
 */
public class AplicacionFabricante {
     public static void main(String[] args) {
        // TODO code application logic here
        
        FabricanteInterface objetoDAO = FactoriaFabricante.getFabricanteDao();
        
 
       FabricanteInterface  empresa=objetoDAO.getNuevoFabricante("juan","direcion",20222,"as","asd","9652","www.wdasd.com" );
    }
}
