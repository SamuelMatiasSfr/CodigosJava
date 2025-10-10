import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatCliente {

    public ChatCliente() throws RemoteException {}

    public static void main(String[] args) {
        InterfaceChat chat;
        String mensagem = new String();
        String mensagemServidor = new String();

        try{
            chat = (InterfaceChat) Naming.lookup("rmi:///ChatServidor"); 
            Scanner scanner = new Scanner(System.in);

            while(!mensagem.equals("!exit")){
                System.out.println("Digite a mensagem: ");
                mensagem = scanner.nextLine();
                mensagemServidor = chat.enviarMensagem("Cliente: " + mensagem);
                System.out.println("\n" + mensagemServidor);

                if(mensagem.equals("!exit")){
                    break;
                }

            }
            scanner.close();

        }catch (Exception e) {
            System.err.println("Exceção cliente: " + e.toString());
            e.printStackTrace();
        }  

    }
    
}
