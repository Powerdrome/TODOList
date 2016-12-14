package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.Tarefa;
/**
 *
 * @author G21
 */
public class TarefasAcao extends JDialog {
    Dados dados;
    public TarefasAcao(Dados dados, Tarefa tr) {
        this.dados=dados;
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 70));
        setLocation(200,200);
        setTitle(tr.getNome());
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(true);
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
