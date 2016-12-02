/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jorgetrovisco
 */
public class BarraLateral2  extends JPanel {
    ArrayList<String> lista = new ArrayList<>();
    public BarraLateral2() {
        lista.add("PW");
        lista.add("IP");
        lista.add("SD");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 500));
        //DesenhaUC();
    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.GRAY);
        DesenhaUC();
        
    }
    public int getWidth(String s, FontMetrics fm){
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            w += fm.charWidth(c);
        }
        return w;
    }
    public void DesenhaUC(){
        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        
        ArrayList<JButton> botoes = new ArrayList<>();

        for(String str : lista){
            botoes.add(new JButton(str));
            System.out.println(str);
        }
        
        for(JButton btn : botoes){
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            frame.add(Box.createVerticalStrut(10));
            frame.add(btn);
        }
        add(frame);
        this.setVisible(true);
    }
}
