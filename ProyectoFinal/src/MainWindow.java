import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import empresa.EmpresaWindow;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    public MainWindow() {
        setTitle("Main Class");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem menuItem1 = new JMenuItem("Empleados");
        menuItem1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              EmpleadoWindow empleadoWindow = new EmpleadoWindow();
              add(empleadoWindow, BorderLayout.CENTER);
              validate();
          }
      });
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("Empresas");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpresaWindow empresaWindow = new EmpresaWindow();
                add(empresaWindow, BorderLayout.CENTER);
                validate();
            }
        });
        menu.add(menuItem2);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}
