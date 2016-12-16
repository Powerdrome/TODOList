/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import todolist.Dados;

/**
 *
 * @author Rui
 */
public class EscolherHoras extends JDialog{
    private Dados dados = null;
    private int nCadeiras = -1;
    private int nCadeiraActual = 0;
    private JButton button = null;
    private JLabel text = null;
    private JLabel TEORICA = new JLabel("Teórica");
    private JLabel TPRATICA = new JLabel("Teórico-Prática");
    private JLabel PRATICA = new JLabel("Prática");
    private JComboBox<String> dropdownT = null;
    private JComboBox<String> dropdownP = null;
    private JComboBox<String> dropdownTP = null;

    public EscolherHoras(Frame owner, Dados dados) {
        super(owner);
        
        int x = 940;
        int y = 575;
        int startx = -1;
        int starty = -1;
        this.dados = dados;
        this.nCadeiras = dados.getNCadeiras();

        this.setModal(true);
        this.setAlwaysOnTop(true);
        this.setTitle("Definição do horário");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        preparaJanela();
        
        //calcula a posição e coloca aí a janela
        startx = (int) (getToolkit().getScreenSize().getWidth()/2 - x/2 + 0.5);
        starty = (int) (getToolkit().getScreenSize().getHeight()/2 - y/2 + 0.5);
        setLocation(startx,starty);
        setVisible(true);
        setBackground(Color.gray);
        
        if (System.getProperty("os.name").contains("Windows")) {
            setResizable(false);
        } else {
            setMinimumSize(new Dimension(x, y));
            setMaximumSize(new Dimension(x, y));
        }
        
        validate();
    }
    
    public void preparaJanela() {
        int x = 940;
        int y = 575;
        String [] combos;
        String [] firstOpt = new String [3];
        String [] combosFinal;
        GridBagConstraints gbConstraints = new GridBagConstraints();

        setLayout(new GridBagLayout());
        //setLayout(new GridLayout(6,3));
        
        text = new JLabel(dados.getCadeiras().get(nCadeiraActual).getNome());
        gbConstraints.gridheight = 1;
        gbConstraints.gridwidth = 3;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 0;
        add(text,gbConstraints);
        //add(new JLabel());
        gbConstraints.gridy = 1;
        gbConstraints.gridwidth = 1;
        add(TEORICA,gbConstraints);
        combos = dados.getHorasAulasT(dados.getCadeiras().get(nCadeiraActual).getNome());
        //System.out.println(dados.getAulas());     debug: ver como as turmas foram inicializadas;
        if (combos == null || combos.length == 0) {
            System.out.println("Não foram encontradas turmas.");
            combos = new String[1];
            combos[0] = "Escolha uma turma teórica";
            dropdownT = new JComboBox<>(combos);
            dropdownT.setEnabled(false);
        } else {
            System.out.println("Recebido: \n" + combos);
            for(String s: combos) {
                System.out.println(s);
            }
            firstOpt[0] = "Escolha uma turma teórica";
            combosFinal = new String[1 + combos.length];
            combosFinal[0] = firstOpt[0];
            for(int i = 1; i < combosFinal.length; i++) {
                combosFinal[i] = combos[i-1];
            }
            dropdownT = new JComboBox<>(combosFinal);    
        }
        gbConstraints.gridx = 1;
        gbConstraints.gridwidth = 2;
        add(dropdownT, gbConstraints);
        
        gbConstraints.gridy = 2;
        gbConstraints.gridx = 0;
        gbConstraints.gridwidth = 1;
        add(PRATICA,gbConstraints);
        combos = dados.getHorasAulasP(dados.getCadeiras().get(nCadeiraActual).getNome());
        if (combos == null || combos.length == 0) {
            System.out.println("Não foram encontradas turmas.");
            combos = new String[1];
            combos[0] = "Escolha uma turma prática";
            dropdownP = new JComboBox<>(combos);
            dropdownP.setEnabled(false);
        } else {
            System.out.println("Recebido: \n" + combos);
            for(String s: combos) {
                System.out.println(s);
            }
            firstOpt[1] = "Escolha uma turma prática";
            combosFinal = new String[1 + combos.length];
            combosFinal[0] = firstOpt[1];
            for(int i = 1; i < combosFinal.length; i++) {
                combosFinal[i] = combos[i-1];
            }
            dropdownP = new JComboBox<>(combosFinal);
        }
        gbConstraints.gridx = 1;
        gbConstraints.gridwidth = 2;
        add(dropdownP, gbConstraints);
        
        gbConstraints.gridy = 3;
        gbConstraints.gridx = 0;
        gbConstraints.gridwidth = 1;
        add(TPRATICA,gbConstraints);
        combos = dados.getHorasAulasTP(dados.getCadeiras().get(nCadeiraActual).getNome());
        if (combos == null || combos.length == 0) {
            System.out.println("Não foram encontradas turmas.");
            combos = new String[1];
            combos[0] = "Escolha uma turma teórico-prática";
            dropdownTP = new JComboBox<>(combos);
            dropdownTP.setEnabled(false);
        } else {
            System.out.println("Recebido: \n" + combos);
            firstOpt[2] = "Escolha uma turma teórico-prática";
            combosFinal = new String[1 + combos.length];
            combosFinal[0] = firstOpt[2];
            for(int i = 1; i < combosFinal.length; i++) {
                combosFinal[i] = combos[i-1];
            }
            dropdownTP = new JComboBox<>(combosFinal);    
        }
        gbConstraints.gridx = 1;
        gbConstraints.gridwidth = 2;
        add(dropdownTP, gbConstraints);
        
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 4;
        add(new JLabel(),gbConstraints);
        
        gbConstraints.gridx = 2;
        gbConstraints.gridwidth = 1;
        if (nCadeiraActual < nCadeiras - 1) {
            button = new JButton("Próximo");
            button.addActionListener(new ProximoActionListener());
        } else {
            button = new JButton("Concluir");
            button.addActionListener(new ConcluirActionListener());
        }
        add(button,gbConstraints);
        
        pack();
        setSize(x,y);
    }

    private class ConcluirActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean checkInput = true;
            if (dropdownT.isEnabled()) {
                if (dropdownT.getSelectedIndex() == 0) {
                    checkInput = false;
                }
            }
            
            if (dropdownP.isEnabled()) {
                if (dropdownP.getSelectedIndex() == 0) {
                    checkInput = false;
                }
            }
            
            if (dropdownTP.isEnabled()) {
                if (dropdownTP.getSelectedIndex() == 0) {
                    checkInput = false;
                }
            }
            
            if (checkInput) {
                if(dropdownT.isEnabled()) {
                    dados.addHoraAulas(nCadeiraActual,dados.getHoraAulas(
                            (String)dropdownT.getSelectedItem(),
                            dados.getCadeiras().get(nCadeiraActual).getNome()));
                }
                if(dropdownP.isEnabled()) {
                    dados.addHoraAulas(nCadeiraActual,dados.getHoraAulas(
                            (String)dropdownP.getSelectedItem(),
                            dados.getCadeiras().get(nCadeiraActual).getNome()));
                }
                if(dropdownTP.isEnabled()) {
                    dados.addHoraAulas(nCadeiraActual,dados.getHoraAulas(
                            (String)dropdownTP.getSelectedItem(),
                            dados.getCadeiras().get(nCadeiraActual).getNome()));
                }
                setModalityType(Dialog.ModalityType.MODELESS);
                getOwner().setEnabled(true);
                EscolherHoras.this.dispose();
            }
        }
    }
    private class ProximoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean checkInput = true;
            if (dropdownT.isEnabled()) {
                if (dropdownT.getSelectedIndex() == 0) {
                    checkInput = false;
                }
            }
            
            if (dropdownP.isEnabled()) {
                if (dropdownP.getSelectedIndex() == 0) {
                    checkInput = false;
                }
            }
            
            if (dropdownTP.isEnabled()) {
                if (dropdownTP.getSelectedIndex() == 0) {
                    checkInput = false;
                }
            }
            

            if (checkInput) {
                if(dropdownT.isEnabled()) {
                    dados.addHoraAulas(nCadeiraActual,dados.getHoraAulas(
                            (String)dropdownT.getSelectedItem(),
                            dados.getCadeiras().get(nCadeiraActual).getNome()));
                }
                if(dropdownP.isEnabled()) {
                    dados.addHoraAulas(nCadeiraActual,dados.getHoraAulas(
                            (String)dropdownP.getSelectedItem(),
                            dados.getCadeiras().get(nCadeiraActual).getNome()));
                }
                if(dropdownTP.isEnabled()) {
                    dados.addHoraAulas(nCadeiraActual,dados.getHoraAulas(
                            (String)dropdownTP.getSelectedItem(),
                            dados.getCadeiras().get(nCadeiraActual).getNome()));
                }
                nCadeiraActual++;
                remove(text);
                remove(TEORICA);
                remove(dropdownT);
                remove(PRATICA);
                remove(dropdownP);
                remove(TPRATICA);
                remove(dropdownTP);
                remove(button);
                preparaJanela();
            }
        }
    }
}

