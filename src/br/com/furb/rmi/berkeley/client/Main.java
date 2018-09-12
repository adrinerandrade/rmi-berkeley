package br.com.furb.rmi.berkeley.client;

import br.com.furb.rmi.berkeley.server.RelogioServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final Set<String> hosts = Set.of(
            "localhost"
    );

    public static void main(String[] args) {
        RelogioServidor relogioServidor = new RelogioServidor(LocalTime.now());
        List<Diferenca> diferencas = executarRemotamente(relogio -> {
            int diferenca = getHora(relogio).toSecondOfDay() - relogioServidor.getHora().toSecondOfDay();
            return new Diferenca(relogio, diferenca);
        });

        int soma = diferencas.stream().mapToInt(Diferenca::getDiferenca).sum();
        int media = soma / (hosts.size() + 1);

        diferencas.stream()
                .forEach(diferenca -> {
                    int diferencaParaMedia = (-diferenca.getDiferenca()) + media;
                    RelogioServerInterface relogio = diferenca.getRelogio();
                    setHora(relogio, getHora(relogio).plusSeconds(diferencaParaMedia));
                });
    }

    private static <T> List<T> executarRemotamente(Function<RelogioServerInterface, T> action) {
        return hosts.stream()
                .map(Main::obterImplementacao)
                .map(action)
                .collect(Collectors.toList());
    }

    private static RelogioServerInterface obterImplementacao(String registro) {
        try {
            Registry registry = LocateRegistry.getRegistry(registro);
            return (RelogioServerInterface) registry.lookup("RelogioServerInterfaceImpl");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static LocalTime getHora(RelogioServerInterface relogio) {
        try {
            return relogio.getHora();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setHora(RelogioServerInterface relogio, LocalTime time) {
        try {
            relogio.atualizarHora(time);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}