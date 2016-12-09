/*
    class EscolherCadeira
    Versão 1.2 - 02/12/2016

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
        this.dados = dados;
        this.nCadeiras = dados.getNCadeiras();
        cadeirasOpcao = new ArrayList<>();
        opcoesAno = new ArrayList<>();
        
        this.setModal(true);
        this.setAlwaysOnTop(true);
        this.setTitle("Escolha de Unidades Curriculares");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
        addComponentes();
        
        validate();
    }
    
    public void addComponentes() {
        int x = 940;
        int y = 575;
        int startx;
        int starty;
        int diferenca;
        botaoConcluir = new JButton("Concluir");
        
        setBackground(Color.gray);
        setLayout(new GridLayout());
        if (System.getProperty("os.name").contains("Windows")) {
            setResizable(false);
        } else {
            setMinimumSize(new Dimension(x, y));
            setMaximumSize(new Dimension(x, y));
        }
        
        //calcula a posição e coloca aí a janela
        startx = (int) (getToolkit().getScreenSize().getWidth()/2 - x/2 + 0.5);
        starty = (int) (getToolkit().getScreenSize().getHeight()/2 - y/2 + 0.5);
        setLocation(startx,starty);
        
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
        
        for (int i = 1; i <= 3; i++) {
            GridLayout gl = new GridLayout(25, 1, 0, 0);
            opcoesAno.add(new JPanel(gl));
            opcoesAno.get(i-1).add(new JLabel("Ano " + i,SwingConstants.CENTER));
        }
        opcoesAno.get(0).add(new JPanel());
        opcoesAno.get(1).add(new JPanel());
        opcoesAno.get(2).add(new JPanel());

        for (String nome: dados.getNomeCadeiras()) {
            cadeirasOpcao.add(new JCheckBox(nome));
        }

        for (JCheckBox cbox: cadeirasOpcao) {
            int ano = dados.findAnoCadeira(cbox.getText());
            opcoesAno.get(ano-1).add(cbox);
            
            if (dados.inscritoCadeira(cbox.getText())) {
                cbox.setSelected(true); //se estiver inscrito marca a checkbox
            }
            cbox.addItemListener(this);
        }
        
        diferenca = opcoesAno.get(1).getComponentCount()-opcoesAno.get(0).getComponentCount();
        for (int i = 0; i < diferenca; i++) {
            opcoesAno.get(0).add(new JPanel());
        }
        
        diferenca = opcoesAno.get(2).getComponentCount()-opcoesAno.get(0).getComponentCount();
        for (int i = 0; i < diferenca; i++) {
            opcoesAno.get(2).add(new JPanel());
        }
        opcoesAno.get(0).add(new JPanel());
        opcoesAno.get(1).add(new JPanel());
        opcoesAno.get(2).add(new JPanel());
        opcoesAno.get(0).add(new JPanel());
        opcoesAno.get(1).add(botaoConcluir);
        opcoesAno.get(2).add(new JPanel());
              
        for (JPanel label: opcoesAno) {
            this.add(label);
        }
        
        pack();
        setSize(x,y);
        setVisible(true);
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
