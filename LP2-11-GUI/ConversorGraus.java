import javax.swing.JOptionPane;

public class ConversorGraus {

    public ConversorGraus(){


        int celsius = 0;

        String entrada = JOptionPane.showInputDialog(null, "Celsius", "Celsius Converter", JOptionPane.QUESTION_MESSAGE);
        celsius = Integer.parseInt(entrada);
        
    }

    public int convert(int celsius){
        int fahreinheit = (celsius * (9/5)) + 32;
        return fahreinheit;
    }

    public static void main(String[] args) {
        ConversorGraus conversor = new ConversorGraus();
    }

}
