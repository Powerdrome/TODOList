/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jorgetrovisco
 */
public class Tarefas extends JPanel{
    public Tarefas() {
        setLayout(new BorderLayout());
    }
    public void paint(Graphics g) {
        desenhaTarefas(g);
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
    
}
