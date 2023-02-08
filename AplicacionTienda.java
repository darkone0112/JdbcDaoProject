/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

/**
 *
 * @author osboxes
 */
public class AplicacionTienda {
    public static void main(String[] args) {
        // TODO code application logic here
        
        TiendaInterface objetoDAO = FactoriaTienda.getTiendaDAO();
        
        TiendaInterface tienda=objetoDAO.getNuevoTienda("dasqwe", "asdqwe", 12321, "qweqrsd", "asdasdfe", "sease@gamcal.co", "123245", 2);
    }
}
