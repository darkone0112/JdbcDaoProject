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
public interface TiendaInterface {
    public int getId();
    public String getNombre();
    public String getDireccion();   
    public int getCP();
    public String getPais();
    public String getProvincia();
    public String getEmail();
    public String getTelefono();
    public int getEmpresaid();
// metodos SET
    public void  setNombre(String nombre);  
    public void  setDireccion(String direccion);            
    public void  setCP(int cp);
    public void  setPais(String pais);
    public void  setProvincia(String provincia);
    public void  setEmail(String email);
    public void  setTelefono(String telefono);
    public void  setEmpresaId(int empresaid);
    //    public void  setNUMEXPDTE(String NUMEXPDTE);//ojo no se puede modificar la clave primaria con la clave primaria habrá que hacer un insert(*)
// métodos FIND
    public TiendaInterface getTiendaPorID(int ID);
    public java.util.Collection getTiendaPorNombre(String nombre);
    public java.util.Collection getTiendaPorDireccion(String direccion);
    public java.util.Collection getTiendaPorCP(int cp);
    public java.util.Collection getTiendaPorPais(String pais);
    public java.util.Collection getTiendaPorProvincia(String provincia);
    public java.util.Collection getTiendaPorEmail(String email);
    public java.util.Collection getTiendaPorTelefono(String telefono);
    public java.util.Collection getTiendaPorEmpresaId(int empresaid);
// METODO BORRADO
    public void delete();
   
 //necesitamos definir un método para crear un nuevo alumno, que lo vamos a llamar desde los constructores de alumnoBean(*)
    public TiendaInterface getNuevoTienda(String nombre,String direccion, int cp,String pais,String provincia,String email,String telefono,int empresaid );


}
