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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.UnidadeCurricular;

/**
 *
 * @author jorgetrovisco
 */
public class BarraLateral  extends JPanel {
    //ArrayList<String> lista = new ArrayList<>();
    todolist.Dados dados;
    
    public BarraLateral(Dados dados) {
        /*lista.add("PW");
        lista.add("IP");
        lista.add("SD");
        */
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 500));
        this.dados = dados;
        
        addMouseListener(new UCSListener());
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
        
        for(UnidadeCurricular uc : dados.getCadeiras()){
            int w = getWidth(uc.getNome(), fm);
            int h = fm.getHeight();
            g.drawRect(x, y, 90, 30);
            g.drawString(uc.getNome(), x+5, y + h);
            y += 30;
        }
    }
    
    class UCSListener extends MouseAdapter{
    
    
        @Override
        public void mousePressed(MouseEvent e) {
        
            int x = e.getX();
            int y = e.getY();
            
            int y0=5;
            int yM=30;
            
            if(y<=dados.getCadeiras().size()*30 && x<=90){
                for(UnidadeCurricular uc : dados.getCadeiras()){
                    if(y>=y0 && y<=yM){
                       JOptionPane.showMessageDialog(null, uc.getNome());
                    }
                    y0+=30;
                    yM+=30;
                }
            }
            
        
        }
    }
}
