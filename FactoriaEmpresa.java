/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpresaDAO;

/**
 *
 * @author osboxes
 */
public class FactoriaEmpresa {
    public static EmpresaInterface getEmpresaDao(){
        return new EmpresaBean();
    }

   
}
