package br.com.furb.rmi.berkeley.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		try {
			RelogioServerInterface sdrmi = new RelogioServerInterfaceImpl();
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("RelogioServerInterfaceImpl", sdrmi);
			System.out.println("Servidor Relogio" + sdrmi + " registrado e pronto para aceitar solicitações.");
		} catch (Exception ex) {
			System.out.println("Houve um erro: " + ex.getMessage());
		}
    }
}
