package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import todolist.Dados;



public class DicasAcao extends JDialog {
    Dados dados;
    public DicasAcao(String titulo, String dica) {
        
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLUE);
        setSize(new Dimension(400, 200));
        
        setLocation(200,200);
        setResizable(false);
        setTitle(titulo);
        createAndDisplay(dica);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(true);
//        botaoPassar = new JButton();
//        botaoPassar.setText("Passar");
//        botaoPassar.setAlignmentX(Component.CENTER_ALIGNMENT); 
//        botaoPassar.setVisible(false);
    }
    protected void createAndDisplay(String dica){
        JPanel frame = new JPanel(new GridLayout(0, 1));
        
        JTextArea txtArea = new JTextArea("Hello, World\nOla", 400, 200);
        txtArea.setEditable(false);
        //JLabel label1 = new JLabel(dica, JLabel.CENTER);
        
        frame.add(txtArea);
        frame.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);
    }
}
