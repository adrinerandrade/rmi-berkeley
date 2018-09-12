package br.com.furb.rmi.berkeley.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

/**
 * @author Michel Tank
 * @author Adriner Andrade
 */
public interface RelogioServerInterface extends Remote {
	
	LocalTime getHora() throws RemoteException;
	
	void atualizarHora(LocalTime hora) throws RemoteException;
}