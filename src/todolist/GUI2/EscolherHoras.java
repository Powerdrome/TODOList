/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        
        //preparaJanela();
        
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
    
//    public void preparaJanela() {
//        int x = 940;
//        int y = 575;
//        String [] combos;
//        ArrayList<String> turmas = null;
//        GridBagConstraints gbConstraints = new GridBagConstraints();
//
//        setLayout(new GridLayout(8, 3));
//        
////        if (getComponentCount() != 0) {
////            for (Component c: getComponents()) {
////                remove(c);
////            }
////        }
//
//        text = new JLabel(dados.getCadeiras().get(nCadeiraActual).getNome());
//        gbConstraints.gridwidth = 3;
//        this.add(text,gbConstraints);
//        
//        gbConstraints.gridwidth = 1;
//        this.add(TEORICA,gbConstraints);
//        //preparar array de strings com as horas das aulas teóricas
//        if (combos == null) {
//            combos = new String[1];
//            combos[0] = "Escolha uma turma teórica";
//            dropdownT = new JComboBox<>(combos);
//            dropdownT.setEnabled(false);
//        } else {
//            dropdownT = new JComboBox<>(combos);    
//        }
//        gbConstraints.gridwidth = 2;
//        this.add(dropdownT, gbConstraints);
//        
//        gbConstraints.gridwidth = 1;
//        this.add(PRATICA,gbConstraints);
//        //preparar array de strings com as horas das aulas práticas
//        if (combos == null) {
//            combos = new String[1];
//            combos[0] = "Escolha uma turma prática";
//            dropdownP = new JComboBox<>(combos);
//            dropdownP.setEnabled(false);
//        } else {
//            dropdownP = new JComboBox<>(combos);    
//        }
//        gbConstraints.gridwidth = 2;
//        this.add(dropdownP, gbConstraints);
//        
//        gbConstraints.gridwidth = 1;
//        this.add(TPRATICA,gbConstraints);
//        //preparar array de strings com as horas das aulas teórico-práticas
//        if (combos == null) {
//            combos = new String[1];
//            combos[0] = "Escolha uma turma teórico-prática";
//            dropdownTP = new JComboBox<>(combos);
//            dropdownTP.setEnabled(false);
//        } else {
//            dropdownTP = new JComboBox<>(combos);    
//        }
//        gbConstraints.gridwidth = 2;
//        this.add(dropdownTP, gbConstraints);
//        
//        this.add(new JLabel(),gbConstraints);
//        
//        gbConstraints.gridwidth = 1;
//        if (nCadeiraActual < nCadeiras) {
//            button = new JButton("Próximo");
//            button.addActionListener(new ProximoActionListener());
//        } else {
//            button = new JButton("Concluir");
//            button.addActionListener(new ConcluirActionListener());
//        }
//        this.add(button,gbConstraints);
//        
//        pack();
//        setSize(x,y);
//    }

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
            
            //grava hora na UC em questão
            //dados.getCadeiras().get(nCadeiraAtual).addAulas(*******)
            
            if (checkInput) {
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
            
            //grava hora na UC em questão
            //dados.getCadeiras().get(nCadeiraAtual).addAulas(*******)
            
            if (checkInput) {
                nCadeiraActual++;
                //preparaJanela();
            }
        }
    }
}

