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
public class FactoriaFabricante {
    public static FabricanteInterface getFabricanteDao(){
        return new FabricanteBean();
    }
}
