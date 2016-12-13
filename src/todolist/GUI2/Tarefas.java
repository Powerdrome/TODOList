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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;

/**
 *
 * @author jorgetrovisco
 */
public class Tarefas extends JPanel {
    Dados dados;
    Tarefas(Dados dados) {
        this.dados = dados;
        setLayout(new BorderLayout());
        //setSize(new Dimension(4000, 7000));
        super.addMouseListener(new AcaoTarefa());
    }
    
    @Override
    public void paint(Graphics g) {
        desenhaTarefas(g);
        setBackground(Color.white);
    }
    
    protected void desenhaTarefas(Graphics g){
        int x = 10;
        int y = 10;
        int i = 0;
        for(; i<3; i++){
        g.setFont(new Font("",0,20));
        g.drawRect(10, y, 700, 75);
        String string = "Tarefa " + i;
        g.drawString(string, (35), (y+40));
        g.setFont(new Font("",0,15));
        g.drawLine(550, y, 550, y+75);
        g.drawString("24/11/2017", 600, y+25);
        g.drawString("18h00 - 20h30", 590, y+50);
        y+= 100;
        }
        setPreferredSize(new Dimension(0, (i*100)));
        
        
    }
    
    class AcaoTarefa extends MouseAdapter{
    
    
        @Override
        public void mousePressed(MouseEvent e) {
        
            int x = e.getX(), y = e.getY();
            int xI = 10, yI = 10;
            
            for(int i=0; i<3; i++){
                if(x>xI && x<xI+700 && y>yI && y<yI+85){
                    //System.out.println("Este é o "+i+"º");
                    String titulo = "Titulo "+ i;
                    JDialog mydialog = new TarefasAcao(dados, titulo);
                }
                yI+=100;
            } 
        }
    }
}
