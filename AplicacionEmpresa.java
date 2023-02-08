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
public class AplicacionEmpresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EmpresaInterface objetoDAO = FactoriaEmpresa.getEmpresaDao();
        
 
       EmpresaInterface  empresa=objetoDAO.getNuevoEmpresa("juan","direcion",20222,"as","asd","9652" );
    }
    
}
