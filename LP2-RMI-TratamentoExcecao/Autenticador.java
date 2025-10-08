//Projeto criado por IA

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticador extends Remote {
    
    String autenticar(String nomeUsuario) throws RemoteException, UsuarioNaoAutorizadoException;

}