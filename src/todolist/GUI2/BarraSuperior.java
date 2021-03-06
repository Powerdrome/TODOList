/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import todolist.Dados;

/**
 *
 * @author G21
 */
public class BarraSuperior extends JPanel implements Observer{
    JButton hora_estudo, nova_tarefa, nova_nota, botaoDica,tarefas,notas;
    JLabel label;
    private Image ImgMais;
    Dados dados;

    public BarraSuperior(Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 30));
        createAndDisplay();
        registarListeners();
        addMouseListener(new Voltar_a_Calendario());
        
        validate();
        
        update(dados,null);
    }

    class Voltar_a_Calendario extends MouseAdapter{

        @Override
        public void mousePressed(MouseEvent e) {
             int x = e.getX();
             int y = e.getY();
             
             if((x>=20 && x<=86) && (y>=7 && y<=18) ){
                 dados.setEstado(1);
             }
             
             System.out.println(x+":"+y);
        }
        
    
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.setFont(new Font("",0,15));
        String s = "TODOList";
        g.drawString(s, 20, 20);
        
        
        
    }
    
    
    protected void createAndDisplay(){
        JPanel frame = new JPanel(new BorderLayout());
        JPanel texto = new JPanel(new FlowLayout());
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
        hora_estudo.setVisible(false);
        
        nova_tarefa = new JButton("Nova Tarefa");
        nova_tarefa.setIcon(IcoMais);
        nova_tarefa.setEnabled(true);
        nova_tarefa.setVisible(false);
        
        nova_nota = new JButton("Nova Nota");
        nova_nota.setIcon(IcoMais); 
        nova_nota.setEnabled(true);
        nova_nota.setVisible(false);
        
        botaoDica = new JButton("Dicas");    
        botaoDica.setEnabled(true);
        botaoDica.setVisible(false);
        
        tarefas = new JButton("Tarefas");
        tarefas.setEnabled(true);
        tarefas.setVisible(false);
        
        notas = new JButton("Notas");
        notas.setEnabled(true);
        notas.setVisible(false);
        
        label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setAlignmentX(RIGHT_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN,16));
        label.setLocation(135, 11);
        label.setBackground(Color.red);
        
        texto.add(label);
        texto.setBackground(Color.red);
        
        
        box.add(texto);
        box.add(tarefas);
        box.add(Box.createRigidArea(new Dimension(3,0)));
        box.add(notas);
        box.add(Box.createRigidArea(new Dimension(3,0)));
        box.add(hora_estudo);
        box.add(Box.createRigidArea(new Dimension(3,0))); 
        box.add(botaoDica);
        box.add(Box.createRigidArea(new Dimension(3,0))); 
        box.add(nova_tarefa);
        box.add(Box.createRigidArea(new Dimension(3,0))); 
        box.add(nova_nota);
        
        
        frame.add(box);
        
        
        frame.setBackground(Color.red);
        
        super.add(frame, BorderLayout.EAST);
        
    }
    
    protected void registarListeners(){
        
        notas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(4);
            }
        });
        
        tarefas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              dados.setEstado(2);
            }
        });
        nova_tarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dados.setTarefaActual(null);
                System.out.println("Tarefa a null ->");
                System.out.println(dados.getTarefaActual());
                dados.setEstado(3);
                dados.actualiza();
            }
        });
        
        hora_estudo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog mydialog = new AdicionarHora(dados);

         }          
      });
      
        nova_nota.addActionListener(new ActionListener() {
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
        String texto="";
        if(dados.getEstado()==2){
            texto = "Tarefas > "+ dados.getUc().getNome();
            label.setText(texto);
        }
        if(dados.getEstado()==4){
            texto = "Notas > "+ dados.getUc().getNome();
            label.setText(texto);
        }
        if(dados.getEstado()==6){
            texto = "Dicas > "+ dados.getUc().getNome();
            label.setText(texto);
        }
        if(dados.getEstado()==1){
            label.setText("");
        }
        
        System.out.println("Estado " + dados.getEstado());
        switch(dados.getEstado()){
            case 1:
                hora_estudo.setVisible(true);
                tarefas.setVisible(false);
                notas.setVisible(false);
                nova_tarefa.setVisible(false);
                nova_nota.setVisible(false);
                botaoDica.setVisible(false);
                break;
            case 2:
                hora_estudo.setVisible(false);
                tarefas.setVisible(false);
                notas.setVisible(true);
                nova_tarefa.setVisible(true);
                nova_nota.setVisible(false);
                botaoDica.setVisible(true);
                break;
            case 3:
                hora_estudo.setVisible(false);
                tarefas.setVisible(true);
                notas.setVisible(true);
                nova_tarefa.setVisible(false);
                nova_nota.setVisible(false);
                botaoDica.setVisible(false);
                break;
            case 4:
                hora_estudo.setVisible(false);
                tarefas.setVisible(true);
                notas.setVisible(false);
                nova_tarefa.setVisible(false);
                nova_nota.setVisible(true);
                botaoDica.setVisible(true);
                break;
        
            case 5:
                hora_estudo.setVisible(false);
                tarefas.setVisible(false);
                notas.setVisible(false);
                nova_tarefa.setVisible(false);
                nova_nota.setVisible(false);
                botaoDica.setVisible(false);
                
            case 6:
                hora_estudo.setVisible(false);
                tarefas.setVisible(true);
                notas.setVisible(true);
                nova_tarefa.setVisible(false);
                nova_nota.setVisible(false);
                botaoDica.setVisible(false);
        }
        
        
        
        repaint();
    }
}