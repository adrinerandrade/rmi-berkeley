package br.com.furb.rmi.berkeley.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

public class RelogioServerInterfaceImpl extends UnicastRemoteObject implements RelogioServerInterface {

	private static final long serialVersionUID = 1L;

	private LocalTime horaLocal;

	public RelogioServerInterfaceImpl(LocalTime horaLocal) throws RemoteException {
		this.horaLocal = horaLocal;
	}

	@Override
	public LocalTime getHora() throws RemoteException {
		return horaLocal;
	}

	@Override
	public void atualizarHora(LocalTime hora) throws RemoteException {
		this.horaLocal = hora;
		System.out.println(String.format("Hora client atualizada: %s", horaLocal));
	}

}