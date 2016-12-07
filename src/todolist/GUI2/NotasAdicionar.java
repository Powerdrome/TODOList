/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import todolist.Dados;

/**
 *
 * @author Paulo
 */
public class NotasAdicionar extends JPanel implements Observer{
    todolist.Dados dados;
    JButton btnCancelar;

    public NotasAdicionar(Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        
        setLayout(new BorderLayout());
        createAndDisplay();
        this.setPreferredSize(new Dimension(100, 100));
        createAndDisplay();
        registarListeners();
    }
    
        protected void createAndDisplay(){
        JPanel frame = new JPanel(new GridLayout(0,2));
        //JLabel 
        JTextField tarefa = new JTextField("Nota");        
        JTextField nota = new JTextField("escreva nota");
        
        JButton btnAdicionar = new JButton("Adicionar");
        btnCancelar = new JButton("Cancelar");
        frame.add(tarefa);
        frame.add(nota);        
        frame.add(btnCancelar);
        frame.add(btnAdicionar);
        add(frame);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        desenhaNotas(g);
        //setBackground(Color.white);
    }
    
    protected void desenhaNotas(Graphics g){
        g.setFont(new Font("",0,20));
        g.drawRect(10, 10, 700, 75);
    }
    
    protected void registarListeners(){
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(4); //mudar??
         }          
      });
    }

    @Override
    public void update(Observable o, Object arg) {
        //update
    }
    
}
