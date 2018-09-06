package br.com.furb.rmi.berkeley.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

public class RelogioServerInterfaceImpl extends UnicastRemoteObject implements RelogioServerInterface {

	private static final long serialVersionUID = 1L;

	protected RelogioServerInterfaceImpl() throws RemoteException {
		
	}

	public LocalTime getHora() throws RemoteException {
		return LocalTime.now();
	}
	
}