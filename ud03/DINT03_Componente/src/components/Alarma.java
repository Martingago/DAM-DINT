package components;

import javax.swing.JOptionPane;

public class Alarma implements DefinirAlarmaListener {
    @Override
    public void capturarAlarma(DefinirAlarmaEvent ev) {
    JOptionPane.showMessageDialog(null, "RIIIIIIIING RIIIIIIIIIIIIIIIIIIIING", "Alarma",
    JOptionPane.INFORMATION_MESSAGE);
        
    }
}
