import java.util.Random;
import javax.swing.JOptionPane;

public class JogoAdivinhaNumero {

    public JogoAdivinhaNumero() {
        int palpite = 0, sorteado, tentativas = 0;

        //Scanner entrada = new Scanner(System.in);

        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;
        JOptionPane.showMessageDialog(null, "Número entre 1 e 1000 sorteado!");

        do {
            JOptionPane.showMessageDialog(null, "Número de tentativas: " + tentativas);

            String entrada = JOptionPane.showInputDialog(null, "Digite seu palpite:", "Jogo Adivinha Número", JOptionPane.QUESTION_MESSAGE);

            palpite = Integer.parseInt(entrada);
            tentativas++;

            dica(palpite, sorteado, tentativas);
        } while (palpite != sorteado);

    }

    public void dica(int palpite, int numero, int tentativas) {
        if (palpite > numero) {
            JOptionPane.showMessageDialog(null, "Seu palpite é maior que o número sorteado.");
        } else {
            if (palpite < numero) {
                JOptionPane.showMessageDialog(null, "Seu palpite é menor que o número sorteado.");
            } else {
                JOptionPane.showMessageDialog(null, "Parabéns, você acertou! O número era " + numero);
                JOptionPane.showMessageDialog(null, "Você tentou " + tentativas + " vezes antes de acertar!");
            }
        }
    }

    public static void main(String[] args) {
        JogoAdivinhaNumero jogo = new JogoAdivinhaNumero();
    }

}