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
    JButton botao, novo, botaoNota, botaoDica;
    private Image ImgMais;
    todolist.Dados dados;
//    AdicionarHora stuff;
    public BarraSuperior(Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 30));
        createAndDisplay();
        registarListeners();
        
        novo.addActionListener(new StartListener());
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
    
    class StartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dados.setEstado(3);
        }
    
    }
    protected void createAndDisplay(){
        JPanel frame = new JPanel(new GridLayout(0,4));
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
        
        novo = new JButton("Nova Tarefa");
        novo.setIcon(IcoMais);
        novo.setMargin(new Insets(0, 0, 0, 0));
        novo.setEnabled(true);
        
        botaoNota = new JButton("Nova Nota");
        botaoNota.setIcon(IcoMais);
        botaoNota.setMargin(new Insets(0, 0, 0,0));
        botaoNota.setEnabled(true);
        
        botaoDica = new JButton("Dicas");
        botaoDica.setMargin(new Insets(0, 0, 0, 0));
        botaoDica.setEnabled(true);
        
        
        frame.add(botao);
        frame.add(novo);
        frame.add(botaoNota);
        frame.add(botaoDica);
        
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

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}