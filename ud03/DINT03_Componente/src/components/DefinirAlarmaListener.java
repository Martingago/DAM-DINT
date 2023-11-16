package components;

import java.util.EventListener;


public interface DefinirAlarmaListener extends EventListener {
    
    public void capturarAlarma(DefinirAlarmaEvent ev);
    
}
