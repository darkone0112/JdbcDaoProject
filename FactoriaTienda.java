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
public class FactoriaTienda {
    public static TiendaInterface getTiendaDAO(){
        return new TiendaBean();
    }
}
