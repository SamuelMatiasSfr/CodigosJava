import javax.swing.JFrame;

public class TestaMyJFrame {
    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame("Minha nova janela");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(350, 210);
        myJFrame.setVisible(true);
    }
}
