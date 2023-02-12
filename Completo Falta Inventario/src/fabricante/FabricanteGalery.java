/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricante;

/**
 *
 * @author osboxes
 */
public class FabricanteGalery {
        public static FabricanteInterface getFabricanteDao() {
           return new FabricanteBean();
    }
}
