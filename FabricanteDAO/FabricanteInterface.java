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
public interface FabricanteInterface {
        public int getId();
    public String getNombre();
    public String getDireccion();   
    public int getCP();
    public String getPais();
    public String getEmail();
    public String getTelefono();
    public String getPagina_web();
// metodos SET
    public void  setNombre(String nombre);  
    public void  setDireccion(String direccion);            
    public void  setCP(int cp);
    public void  setPais(String pais);
    public void  setEmail(String email);
    public void  setTelefono(String telefono);
    public void  setPagina_web(String pagina_web);
    //    public void  setNUMEXPDTE(String NUMEXPDTE);//ojo no se puede modificar la clave primaria con la clave primaria habrá que hacer un insert(*)
// métodos FIND
    public FabricanteInterface getFabricantePorID(int ID);
    public java.util.Collection getFabricantePorNombre(String nombre);
    public java.util.Collection getFabricantePorDireccion(String direccion);
    public java.util.Collection getFabricantePorCP(int cp);
    public java.util.Collection getFabricantePorPais(String pais);
    public java.util.Collection getFabricantePorEmail(String email);
    public java.util.Collection getFabricantePorTelefono(String telefono);
    public java.util.Collection getFabricantePorPagina_web(String pagina_web);
  // METODO BORRADO
    public void delete();
   
 //necesitamos definir un método para crear un nuevo alumno, que lo vamos a llamar desde los constructores de alumnoBean(*)
    public FabricanteInterface getNuevoFabricante(String nombre,String direccion, int cp,String pais,String email,String telefono,String pagina_web );
}
