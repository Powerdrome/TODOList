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
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author jorgetrovisco
 */
public class BarraLateral  extends JPanel {
    ArrayList<String> lista = new ArrayList<>();
    public BarraLateral() {
        lista.add("PW");
        lista.add("IP");
        lista.add("SD");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 500));
    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.GRAY);
        DesenhaUC(g);
        
    }
    public int getWidth(String s, FontMetrics fm){
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            w += fm.charWidth(c);
        }
        return w;
    }
    public void DesenhaUC(Graphics g){
        g.setFont(new Font("",0,15));
        FontMetrics fm = getFontMetrics(new Font("",0,15));
        int x=5, y=5;
        for(String str : lista){
            int w = getWidth(str, fm);
            int h = fm.getHeight();
            g.drawRect(x, y, 90, 30);
            g.drawString(str, x+5, y + h);
            y += 35;
        }
    }
}
