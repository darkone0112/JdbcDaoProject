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
public interface EmpresaInterface {
    public int getId();
    public String getNombre();
    public String getDireccion();   
    public int getCP();
    public String getPais();
    public String getEmail();
    public String getTelefono();
// metodos SET
    public void  setNombre(String nombre);  
    public void  setDireccion(String direccion);            
    public void  setCP(int cp);
    public void  setPais(String pais);
    public void  setEmail(String email);
    public void  setTelefono(String telefono);
    //    public void  setNUMEXPDTE(String NUMEXPDTE);//ojo no se puede modificar la clave primaria con la clave primaria habrá que hacer un insert(*)
// métodos FIND
    public EmpresaInterface getEmpresaPorID(int ID);
    public java.util.Collection getEmpresaPorNombre(String nombre);
    public java.util.Collection getEmpresaPorDireccion(String direccion);
    public java.util.Collection getEmpresaPorCP(int cp);
    public java.util.Collection getEmpresaPorPais(String pais);
    public java.util.Collection getEmpresaPorEmail(String email);
    public java.util.Collection getEmpresaPorTelefono(String telefono);
  // METODO BORRADO
    public void delete();
   
 //necesitamos definir un método para crear un nuevo alumno, que lo vamos a llamar desde los constructores de alumnoBean(*)
    public EmpresaInterface getNuevoEmpresa(String nombre,String direccion, int cp,String pais,String email,String telefono );
}
