/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import javax.swing.JPanel;

public class TiendaPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public TiendaPanel() {
        add(new TiendaWindow());
    }
}