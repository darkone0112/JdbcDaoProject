/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FABRICANTE;

import EMPRESA.EmpresaBean;
import EMPRESA.EmpresaInterface;

/**
 *
 * @author osboxes
 */
public class FabricanteGalery {
    static FabricanteInterface getFabricanteDao() {
           return new FabricanteBean();
    }
    
    
}
