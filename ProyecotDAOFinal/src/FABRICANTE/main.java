/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FABRICANTE;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osboxes
 */
public class main {
      public static void main(String[] args) {
        FabricanteInterface DaoObject = FabricanteGalery.getFabricanteDao();
        DaoObject.loadJDBC();
        DaoObject.connect();
        System.out.println(DaoObject.getConn());

        // Create a JFrame to display the menu
        JFrame frame = new JFrame("Fabricantes Menu");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        // Create a JPanel to hold the menu options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the menu options
        JButton displayButton = new JButton("Display Fabricantes");
        JButton addButton = new JButton("Add Fabricante");
        JButton updateButton = new JButton("Update Fabricante");
        JButton deleteButton = new JButton("Delete Fabricante");

        // Add the menu options to the panel
        panel.add(displayButton);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        // Add the panel to the frame
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(panel, gbc);
        frame.setVisible(true);

       
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("DIRECCION");
        model.addColumn("CP");
        model.addColumn("PAIS");
        model.addColumn("EMAIL");
        model.addColumn("TELEFONO");
        model.addColumn("PAGINA_WEB");
        
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame tableFrame = new JFrame("FABRICANTES");
                tableFrame.setSize(800, 600);
                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                tableFrame.add(scrollPane);
                tableFrame.setVisible(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaoObject.addFabricante(DaoObject.getConn());
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaoObject.deleteFabricante(DaoObject.getConn());
            }
        });
        //add update button action listener
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaoObject.updateFabricante(DaoObject.getConn());
            }
        });
    }
}
