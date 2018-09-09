package br.com.furb.rmi.berkeley.client;

import java.time.LocalTime;

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
