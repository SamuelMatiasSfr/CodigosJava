import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class GerenciadorContas{
    
    ArrayList<Conta> contas;
    ArrayList<ContaEspecial> contasEspeciais;
    ArrayList<ContaPoupanca> contasPoupanca;

    public void carregaDados() throws FileNotFoundException, IOException{
        FileReader arquivo = new FileReader("contas.csv");
        BufferedReader buffer = new BufferedReader(arquivo);
        String linha = buffer.readLine();

        int cont = 0;
        while(linha != null){
            String result[] = linha.split(",");
            
            if(cont > 0){
                if(result.length == 3){
                    Conta conta = new Conta(0, " ", 0);
                    conta.setId(result[i]);
                }
            }
            linha = buffer.readLine();
            cont++;
        }
        buffer.close();
        
    }

    public void mostraQuantContas(){
        System.out.println(contas.size() + " Conta");
        System.out.println(contas.size() + " ContaEspecial");
        System.out.println(contas.size() + " ContaPoupanca");
    }

    public void mostraContasEspeciais(){
        System.out.println("id, nome, saldo, limite");
        for(ContaEspecial conta : contasEspeciais){
            System.out.println(conta);
        }
    }

    public void mostraContasPoupanca(){
        System.out.println("id, nome, saldo, calculoRendimento");
        for(ContaPoupanca conta : contasPoupanca){
            System.out.println(conta.mostraDadosMaisCalculo());
        }
    }

}