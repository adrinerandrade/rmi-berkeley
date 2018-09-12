package br.com.furb.rmi.berkeley.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

public class Client {

    public static void main(String[] args) {
        try {
            RelogioServerInterface sdrmi = new RelogioServerInterfaceImpl(LocalTime.of(10, 0));
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("RelogioServerInterfaceImpl", sdrmi);
            System.out.println("Servidor Relogio" + sdrmi + " registrado e pronto para aceitar solicitações.");
            System.out.println("Hora inicial client: " + sdrmi.getHora());
        } catch (Exception ex) {
            System.out.println("Houve um erro: " + ex.getMessage());
        }
    }
}
