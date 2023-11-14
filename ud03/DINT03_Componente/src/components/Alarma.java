package components;

public class Alarma implements DefinirAlarmaListener {
    @Override
    public void capturarAlarma(DefinirAlarmaEvent ev) {
        System.out.println("RIIIIIING RIIIIIIIIIIIIING");
    }
}
