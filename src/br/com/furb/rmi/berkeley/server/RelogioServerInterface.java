package br.com.furb.rmi.berkeley.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

public interface RelogioServerInterface extends Remote {
	
	LocalTime getHora() throws RemoteException;
	
	void atualizarHora(LocalTime hora) throws RemoteException;
}