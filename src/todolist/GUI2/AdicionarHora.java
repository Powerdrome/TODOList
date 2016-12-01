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
import javax.swing.JFrame;

/**
 *
 * @author jorgetrovisco
 */
public class AdicionarHora  extends JFrame {

    public AdicionarHora() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 300));
        getContentPane().setBackground(Color.BLUE);
    }
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.setFont(new Font("",0,15));
        String s = "Adicionar Hora";
        g.drawString(s, 20, 20);
    }
    
}
