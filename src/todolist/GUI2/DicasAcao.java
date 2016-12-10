package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import todolist.Dados;



public class DicasAcao extends JDialog {
    Dados dados;
    public DicasAcao(Dados dados) {
        this.dados=dados;
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLUE);
        setSize(new Dimension(400, 70));
        setLocation(200,200);
        setTitle("Selecionar ação");
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(true);
//        botaoPassar = new JButton();
//        botaoPassar.setText("Passar");
//        botaoPassar.setAlignmentX(Component.CENTER_ALIGNMENT); 
//        botaoPassar.setVisible(false);
    }
    protected void createAndDisplay(){
        JPanel frame = new JPanel(new GridLayout(0, 2));
        
        
        JLabel label1 = new JLabel("Image and Text",JLabel.CENTER);
        frame.add(label1);
        frame.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);
    }
}
