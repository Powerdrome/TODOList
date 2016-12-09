/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
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
        super.addMouseListener(new AcaoTarefa());
    }
    
    @Override
    public void paint(Graphics g) {
        desenhaTarefas(g);
        setBackground(Color.white);
    }
    
    protected void desenhaTarefas(Graphics g){
        g.setFont(new Font("",0,20));
        g.drawRect(10, 10, 700, 75);
        g.drawString("Tarefa x", (20+15), (20+30));
        g.setFont(new Font("",0,15));
        g.drawLine(550, 10, 550, 85);
        g.drawString("24/11/2017", 600, 35);
        g.drawString("18h00 - 20h30", 590, 60);
    }
    
    class AcaoTarefa extends MouseAdapter{
    
    
        @Override
        public void mousePressed(MouseEvent e) {
        
//            int x = e.getX();
//            int y = e.getY();
//            
//            int y0=5;
//            int yM=30;
//            
//            if(y<=dados.getCadeiras().size()*30 && x<=90){
//                for(UnidadeCurricular uc : dados.getCadeiras()){
//                    if(y>=y0 && y<=yM){
                        JDialog mydialog = new TarefasAcao(dados);
//                    }
//                    y0+=30;
//                    yM+=30;
//                }
//            }
//            
//        
        }
    }
    
    
    
    
}
