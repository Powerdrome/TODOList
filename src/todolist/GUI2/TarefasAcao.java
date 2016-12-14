package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JButton eliminar;
    JButton concluir;
    Tarefa t;
    public TarefasAcao(Dados dados, Tarefa tr) {
        this.dados=dados;
        this.t = tr;
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 70));
        setLocation(200, 200);
        setTitle(tr.getNome());
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        registarListeners();
        setVisible(true);
    }
    protected void createAndDisplay(){
        JPanel frame = new JPanel(new GridLayout(0, 2));
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(100,100,10,10);
        
        concluir = new JButton("Concluir");
        concluir.setBounds(100,100,10,10);
        
        frame.add(eliminar);
        frame.add(concluir);
        
        frame.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);
    }
    
    protected void registarListeners(){
        
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.Concluido();
                setVisible(false);
                dados.actualiza();
            }
        });
        
        concluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.Concluido();
                setVisible(false);
                dados.actualiza();
            }
        });
    }
}
