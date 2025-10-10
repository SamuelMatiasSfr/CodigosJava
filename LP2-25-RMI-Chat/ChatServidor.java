import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChatServidor extends UnicastRemoteObject implements InterfaceChat{
    
    Scanner scanner;

    public ChatServidor() throws RemoteException {
        scanner = new Scanner(System.in);
    }

    public String enviarMensagem(String mensagemCliente) throws RemoteException{
        System.out.println("\n" + mensagemCliente);
        System.out.println("Digite a mensagem: ");
        String mensagem = scanner.nextLine();
        return "Servidor: " + mensagem;
    }



    public static void main(String[] args) {
        InterfaceChat chat;
        try{
            chat = new ChatServidor();
            LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///ChatServidor", chat);
        } catch (Exception e) {
            System.err.println("Exceção servidor: " + e.toString());
			e.printStackTrace();
		}	
    }
    
}