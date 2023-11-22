package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ComponenteRelojBeans extends JLabel implements Serializable, ActionListener {

    private boolean formato24h;
    private boolean enableAlarm;
    private int hourAlarm;
    private int minutesAlarm;

    //atributos de funcionamiento:
    private LocalTime timeNow; //momento actual
    private Timer timer; //realiza una acción cada x milisegundos

    private DefinirAlarmaListener receptor;

    public ComponenteRelojBeans() {
        setEnableAlarm(true);
        setFormato24h(false);
        actualizarHora(); //Se establece el texto inicial antes de iniciar el contador
        timer = new Timer(1000, this);
        timer.start();
    }

    public void addDefinirAlarmaListener(DefinirAlarmaListener receptor) {
        this.receptor = receptor;
    }

    public void removeDefinirAlarmaListener(DefinirAlarmaListener receptor) {
        this.receptor = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualiza el momento actual, y comprueba la alarma
        actualizarHora();
        checkAlarma();
    }

    /**
     * Funcion que obtiene la hora actual del sistema y actualiza el texto del
     * componente
     */
    private void actualizarHora() {
        timeNow = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato24h ? "HH:mm:ss" : "hh:mm:ss a");
        setText(timeNow.format(formatter));
    }

    /**
     * Función que comprueba que existe una alarma y verifica si el momento actual se corresponde
     * con la alarma que se ha marcado
     */
    private void checkAlarma() {
        if (enableAlarm && timeNow.getHour() == hourAlarm && timeNow.getMinute() == minutesAlarm) {
            
            if (receptor != null) {
                receptor.capturarAlarma(new DefinirAlarmaEvent(this));
                removeDefinirAlarmaListener(receptor); //establecemos el receptor como null para que no salgan mas avisos
            }
        }
    }
    

    //Getters y setters
    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        this.formato24h = formato24h;
    }

    public boolean isEnableAlarm() {
        return enableAlarm;
    }

    public void setEnableAlarm(boolean enableAlarm) {
        this.enableAlarm = enableAlarm;
    }

    public int getHourAlarm() {
        return hourAlarm;
    }

    public void setHourAlarm(int hourAlarm) {
        this.hourAlarm = hourAlarm;
    }

    public int getMinutesAlarm() {
        return minutesAlarm;
    }

    public void setMinutesAlarm(int minutesAlarm) {
        this.minutesAlarm = minutesAlarm;
    }

}
