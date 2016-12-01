/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jorgetrovisco
 */
public class BarraSuperior extends JPanel {
    JButton botao;
    AdicionarHora stuff;
    public BarraSuperior() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 30));
        createAndDisplay();
        registarListeners();
    }
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.setFont(new Font("",0,15));
        String s = "TODOList";
        g.drawString(s, 20, 20);
        
    }
    protected void createAndDisplay(){
        JPanel frame = new JPanel();
        botao = new JButton();
        botao.setText("+");
        frame.add(botao);
        frame.setBackground(Color.red);
        botao.setBounds(100,100,10,10);
        add(frame, BorderLayout.EAST);
    }
    
    protected void registarListeners(){
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stuff = new AdicionarHora();
                JOptionPane.showMessageDialog(stuff,"Adicionar Hora");
         }          
      });
    }
}
