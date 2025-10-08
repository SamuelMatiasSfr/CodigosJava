//Projeto criado por IA

import java.rmi.Naming;
import java.util.Scanner;

public class ClienteAutenticador {
    public static void main(String[] args) {
        try {
            Autenticador autenticador = (Autenticador) Naming.lookup("rmi://localhost/Autenticador");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite seu nome de usuário: ");
            String nome = scanner.nextLine();

            try {
                String resposta = autenticador.autenticar(nome);
                System.out.println(resposta);
            } catch (UsuarioNaoAutorizadoException e) {
                System.err.println("Erro: " + e.getMessage());
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
