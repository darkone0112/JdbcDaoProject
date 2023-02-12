package inventario;

import javax.swing.JPanel;

public class InventarioPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public InventarioPanel() {
        add(new InventarioWindow());
    }
}
