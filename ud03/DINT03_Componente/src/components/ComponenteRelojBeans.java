package components;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ComponenteRelojBeans extends JLabel implements Serializable {

    private boolean formato24h;
    private boolean enableAlarm;
    private int hourAlarm;
    private int minutesAlarm;
    private Timer timer;

    public ComponenteRelojBeans() {
      actualizarHora(); //Se establece el texto inicial antes de iniciar el contador
        setEnableAlarm(true);
        setFormato24h(false);
      timer = new Timer(1000, e -> actualizarHora());
      timer.start();
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

    private void actualizarHora() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato24h ? "HH:mm:ss" : "hh:mm:ss a");
        setText(time.format(formatter));
    }



}