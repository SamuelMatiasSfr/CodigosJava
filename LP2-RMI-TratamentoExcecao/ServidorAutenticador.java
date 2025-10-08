//Projeto criado por IA

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.util.Arrays;
import java.util.List;

public class ServidorAutenticador extends UnicastRemoteObject implements Autenticador {

    private List<String> usuariosAutorizados = Arrays.asList("joao", "maria", "ana");

    protected ServidorAutenticador() throws RemoteException {
        super();
    }

    @Override
    public String autenticar(String nomeUsuario) throws RemoteException, UsuarioNaoAutorizadoException {
        if (usuariosAutorizados.contains(nomeUsuario.toLowerCase())) {
            return "Bem-vindo, " + nomeUsuario + "!";
        } else {
            throw new UsuarioNaoAutorizadoException(nomeUsuario);
        }
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ServidorAutenticador servidor = new ServidorAutenticador();
            Naming.rebind("rmi://localhost/Autenticador", servidor);
            System.out.println("Servidor Autenticador pronto.");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

