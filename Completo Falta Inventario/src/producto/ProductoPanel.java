/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import javax.swing.JPanel;

/**
 *
 * @author osboxes
 */
public class ProductoPanel extends JPanel {
   private static final long serialVersionUID = 1L;

    public ProductoPanel() {
        add(new ProductoWindow());
    } 
}