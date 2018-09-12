package br.com.furb.rmi.berkeley.server;

import java.time.LocalTime;

/**
 * @author Michel Tank
 * @author Adriner Andrade
 */
public class RelogioServidor {

    private LocalTime time;

    public RelogioServidor(LocalTime time) {
        this.time = time;
    }

    public LocalTime getHora() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}
