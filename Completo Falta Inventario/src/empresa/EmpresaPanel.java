/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import javax.swing.JPanel;

/*
 *
 * @author osboxes
 */
public class EmpresaPanel extends JPanel{
    private static final long serialVersionUID = 1L;
    
    public EmpresaPanel() {
        add(new EmpresaWindow());
    }
}
