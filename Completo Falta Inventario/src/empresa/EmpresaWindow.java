/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpresaWindow extends JPanel {
    private static final long serialVersionUID = 1L;
    EmpresaInterface empleadoBean = EmpresaGalery.getEmpresaDao();

    public EmpresaWindow() {
        empleadoBean.loadJDBC();
        empleadoBean.connect();
        setLayout(new FlowLayout());
        /* anotherClass = new AnotherClass(); */
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("direcion");
        model.addColumn("cp");
        model.addColumn("pais");
        model.addColumn("email");
        model.addColumn("telefono");
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JButton button1 = new JButton("Agregar Empresa");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               empleadoBean.addEmpresa();
               empleadoBean.displayAllEmpresas(model);
            }
        });
        add(button1);
        
        JButton button2 = new JButton("Modificar Empresa");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    empleadoBean.updateEmpresa(model, selectedRow);
                }
            }
        });
        add(button2);
        
        JButton button3 = new JButton("Buscar Empresa");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleadoBean.findEmpresaById(model);
            }
        });
        add(button3);
        
        JButton button4 = new JButton("Eliminar Empresa");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleadoBean.deleteEmpresa(model, table.getSelectedRow());
            }
        });
        add(button4);
        
        JButton button5 = new JButton("Mostrar Todos");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setPreferredSize(new Dimension(980, 600));
                add(scrollPane);
                empleadoBean.displayAllEmpresas(model);
                revalidate();
                repaint();
            }
        });
        add(button5);
    }
}