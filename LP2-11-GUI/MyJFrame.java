import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class MyJFrame extends JFrame{
        
    private JLabel label;
    private JButton button;
    private JTextField text;

    public MyJFrame(String titulo){
        super(titulo);
        setLayout(new FlowLayout());

        label = new JLabel("Celsius");
        button = new JButton("Convert");
        text = new JTextField("Digite os graus");

        add(label);
        add(text);
        add(button);

        TextHandler handler = new TextHandler();
        text.addActionListener(handler);
        button.addActionListener(handler);
    }

    private class TextHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == text){
                JOptionPane.showMessageDialog(MyJFrame.this, "Caixa de texto: " + e.getActionCommand());
            }else{
                JOptionPane.showMessageDialog(MyJFrame.this, "Botão: " + e.getActionCommand());
            }
        }
    }    

}
