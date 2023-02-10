import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmpleadoWindow extends JPanel {
    private static final long serialVersionUID = 1L;
    EmpleadoBean empleadoBean = new EmpleadoBean();
    

    public EmpleadoWindow() {
        setLayout(new FlowLayout());
        /* anotherClass = new AnotherClass(); */
        
        JButton button1 = new JButton("Agregar Empleado");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               empleadoBean.addEmpleado();
            }
        });
        add(button1);
        
        JButton button2 = new JButton("Modificar Empleado");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* anotherClass.method2(); */
            }
        });
        add(button2);
        
        JButton button3 = new JButton("Buscar Empleado");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* anotherClass.method3(); */
            }
        });
        add(button3);
        
        JButton button4 = new JButton("Eliminar Empleado");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* anotherClass.method4(); */
            }
        });
        add(button4);
        
        JButton button5 = new JButton("Mostrar Todos");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* anotherClass.method5(); */
            }
        });
        add(button5);
    }
}
