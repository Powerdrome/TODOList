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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;

/**
 *
 * @author G21
 */
public class BarraSuperior extends JPanel implements Observer{
    JButton hora_estudo, nova_tarefa, botaoNota, botaoDica;
    private Image ImgMais;
    Dados dados;
//    AdicionarHora stuff;
    public BarraSuperior(Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 30));
        createAndDisplay();
        registarListeners();
        
        
        validate();
        
        update(dados,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.setFont(new Font("",0,15));
        String s = "TODOList";
        g.drawString(s, 20, 20);
    }
    
    
    protected void createAndDisplay(){
        JPanel frame = new JPanel(new BorderLayout());
        Box box = Box.createHorizontalBox();
        
        try{
            ImgMais = ImageIO.read(Resources.getResourceFile("imagens/plus.png"));
        }catch(IOException e){}
        
        int x = 12, y = 12;
        ImgMais = ImgMais.getScaledInstance(x, y, 100);
        ImageIcon IcoMais = new ImageIcon(ImgMais);
        
        hora_estudo = new JButton("Hora Estudo");
        hora_estudo.setIcon(IcoMais);
        
        hora_estudo.setEnabled(true);
        
        nova_tarefa = new JButton("Nova Tarefa");
        nova_tarefa.setIcon(IcoMais);
        
        nova_tarefa.setEnabled(true);
        
        botaoNota = new JButton("Nova Nota");
        botaoNota.setIcon(IcoMais);
        
        botaoNota.setEnabled(true);
        
        botaoDica = new JButton("Dicas");
        
        botaoDica.setEnabled(true);
        
        box.add(hora_estudo);
        box.add(Box.createRigidArea(new Dimension(3,0))); 
        box.add(nova_tarefa);
        box.add(Box.createRigidArea(new Dimension(3,0))); 
        box.add(botaoNota);
        box.add(Box.createRigidArea(new Dimension(3,0))); 
        box.add(botaoDica);
        
        frame.add(box);
        
        
        frame.setBackground(Color.red);
        
        super.add(frame, BorderLayout.EAST);
    }
    
    protected void registarListeners(){
        
        nova_tarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(3);
            }
        });
        
        hora_estudo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog mydialog = new AdicionarHora();

         }          
      });
      
        botaoNota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(5);
            }
        });
      
      botaoDica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(6);
            }
        });      
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}