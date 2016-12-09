/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author G21
 */
public class AdicionarHora  extends JDialog {

    public AdicionarHora() {
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLUE);
        setSize(new Dimension(400,150));
        setLocation(200,200);
        setTitle("Adicionar Hora");
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
        JLabel nome = new JLabel("Hora de Estudo");
        nome.setForeground(Color.white);
        JLabel inicio = new JLabel("Inicio");
        inicio.setForeground(Color.white);
        JLabel fim = new JLabel("Fim");
        fim.setForeground(Color.white);
        JTextField fieldNome = new JTextField("");
        JTextField fieldInicio = new JTextField("dd/mm/aaaa hh:mm");
        JTextField fieldFim = new JTextField("dd/mm/aaaa hh:mm");
        JButton botao = new JButton("Inserir");
        botao.setBounds(100,100,10,10);
        frame.add(nome);
        frame.add(fieldNome);
        frame.add(inicio);
        frame.add(fieldInicio);
        frame.add(fim);
        frame.add(fieldFim);
        JPanel frameBotao = new JPanel();
        frameBotao.add(botao);
        
        
        frame.setBackground(Color.gray);
        frameBotao.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);
        add(frameBotao, BorderLayout.SOUTH);
    }
}
