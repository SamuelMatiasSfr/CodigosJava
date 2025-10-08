//Projeto criado por IA

public class UsuarioNaoAutorizadoException extends Exception {

    public UsuarioNaoAutorizadoException(String nome) {
        super("Usuário não autorizado: " + nome);
    }

}