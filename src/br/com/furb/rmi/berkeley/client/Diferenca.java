package br.com.furb.rmi.berkeley.client;

import br.com.furb.rmi.berkeley.server.RelogioServerInterface;

public class Diferenca {

    private RelogioServerInterface relogio;
    private int diferenca;

    public Diferenca(RelogioServerInterface relogio, int diferenca) {
        this.relogio = relogio;
        this.diferenca = diferenca;
    }

    public RelogioServerInterface getRelogio() {
        return relogio;
    }

    public int getDiferenca() {
        return diferenca;
    }

}
