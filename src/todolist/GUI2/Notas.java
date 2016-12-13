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
import java.awt.event.MouseListener;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;

/**
 *
 * @author Paulo
 */
//teste
public class Notas extends JPanel{
    Dados dados;
    public Notas(Dados dados) {
        
        setLayout(new BorderLayout());
        super.addMouseListener(new AcaoNota());
    }
    
    @Override
    public void paint(Graphics g){
        desenhaNotas(g);
        setBackground(Color.white);
    }
    
    protected void desenhaNotas(Graphics g){
        int x = 10, y = 10;
        int i;
        for(i = 0; i < 3; i++){
            g.setFont(new Font("",0,20));
            g.drawRect(10, y, 700, 75);
            
            g.drawString("Nota " + i, (35), (y+40));
            g.setFont(new Font("",0,15));
            g.drawLine(550, y, 550, y+75);
            g.drawString("12/12/2017", 600, y+25);
            g.drawString("18h00 - 20h30", 590, y+50);
            y+=100;
        }
        setPreferredSize(new Dimension(0, (i*100)));
    }

    class AcaoNota extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            JDialog mydialog = new NotasAcao(dados);
        }
    }
    
}
