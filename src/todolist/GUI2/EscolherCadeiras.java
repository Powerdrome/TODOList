/*
    class EscolherCadeira
    Versão 1.1 - 02/12/2016

 */
package todolist.GUI2;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import todolist.Dados;

/**
 *
 * @author Rui
 */
public class EscolherCadeiras extends JDialog implements ItemListener{
    private Dados dados;
    private ArrayList<JCheckBox> cadeirasOpcao;
    private ArrayList<JPanel> opcoesAno;
    private JButton botaoConcluir;
    private int nCadeiras;

    public EscolherCadeiras(JFrame owner, Dados dados) {
        super(owner);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.setAlwaysOnTop(true);
        this.setTitle("Escolha de Unidades Curriculares");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.dados = dados;
        this.nCadeiras = dados.getNCadeiras();
        cadeirasOpcao = new ArrayList<>();
        opcoesAno = new ArrayList<>();
        
        addComponentes();
        
        validate();
    }
    
    public void addComponentes() {
        int x = 700;
        int y = 500;
        int i;
        JPanel empty =  new JPanel();
        botaoConcluir = new JButton("Concluir");
        
        setBackground(Color.gray);
        setLayout(new GridLayout());
        empty.setVisible(false);
        
        botaoConcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nCadeiras != 0) {
                    setModalityType(Dialog.ModalityType.MODELESS);
                    getOwner().setEnabled(true);
                    EscolherCadeiras.this.dispose();
                }
            }
        });
        
        for (i = 1; i <= 3; i++) {
            opcoesAno.add(new JPanel(new GridLayout(14,1)));
            opcoesAno.get(i-1).add(new JLabel("Ano " + i,SwingConstants.CENTER));
        }

        for (String nome: dados.getNomeCadeiras()) {
            cadeirasOpcao.add(new JCheckBox(nome));
        }
        
        i = 0;
        for (JCheckBox cbox: cadeirasOpcao) {
            opcoesAno.get(i/2).add(cbox);
            i++;
            
            
            if (dados.inscritoCadeira(cbox.getText())) {
                cbox.setSelected(true); //se estiver inscrito marca a checkbox
            }
            cbox.addItemListener(this);
        }
        opcoesAno.get(0).add(empty);
        opcoesAno.get(1).add(botaoConcluir);
        opcoesAno.get(2).add(empty);
              
        for(JPanel label: opcoesAno) {
            this.add(label);
        }
        
        pack();
        setSize(x,y);
        setVisible(true);
        if (System.getProperty("os.name").contains("Windows")) {
            setResizable(false);
        }
        else {
            setMinimumSize(new Dimension(x, y));
            setMaximumSize(new Dimension(x, y));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox source = (JCheckBox) e.getItemSelectable();
        
        if (e.getStateChange() == ItemEvent.SELECTED) {
            dados.addCadeira(source.getText());
            nCadeiras++;
        } else {
            dados.removeCadeira(source.getText());
            nCadeiras--;
        }
    }
}
