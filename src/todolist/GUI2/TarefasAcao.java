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
/**
 *
 * @author G21
 */
public class TarefasAcao extends JDialog {
    Dados dados;
    public TarefasAcao(Dados dados) {
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
        
        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(100,100,10,10);
        
        JButton concluir = new JButton("Concluir");
        concluir.setBounds(100,100,10,10);
        
        frame.add(eliminar);
        frame.add(concluir);
        
        frame.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);
    }
}
