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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author G21
 */
public class BarraSuperior extends JPanel {
    JButton botao, novo;
    private Image ImgMais;
//    AdicionarHora stuff;
    public BarraSuperior() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 30));
        createAndDisplay();
        registarListeners();
        
        repaint();
        validate();
        revalidate();
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
        JPanel frame = new JPanel(new GridLayout(0,2));
        try{
            ImgMais = ImageIO.read(Resources.getResourceFile("imagens/plus.png"));
        }catch(IOException e){}
        int x = 12, y = 12;
        ImgMais = ImgMais.getScaledInstance(x, y, 100);
        ImageIcon IcoMais = new ImageIcon(ImgMais);
        
        botao = new JButton("Hora Estudo");
        botao.setIcon(IcoMais);
        botao.setMargin(new Insets(0, 0, 0, 0));
        botao.setEnabled(true);
        
        novo = new JButton("Novo");
        novo.setIcon(IcoMais);
        novo.setMargin(new Insets(0, 0, 0, 0));
        novo.setEnabled(true);
        
        frame.add(botao);
        frame.add(novo);
        
        frame.setBackground(Color.red);
        
        super.add(frame, BorderLayout.EAST);
    }
    
    protected void registarListeners(){
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                stuff = new AdicionarHora();
//                JOptionPane.showMessageDialog(stuff,"Adicionar Hora");
                JDialog mydialog = new AdicionarHora();

         }          
      });
      novo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                stuff = new AdicionarHora();
//                JOptionPane.showMessageDialog(stuff,"Adicionar Hora");
                //JDialog mydialog = new AdicionarHora();

         }          
      });
    }
}