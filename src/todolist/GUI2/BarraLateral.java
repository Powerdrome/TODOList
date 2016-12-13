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
import static java.lang.Character.isUpperCase;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.UnidadeCurricular;

/**
 *
 * @author jorgetrovisco
 */
public class BarraLateral extends JPanel implements Observer{
    //ArrayList<String> lista = new ArrayList<>();
    todolist.Dados dados;
    
    public BarraLateral(Dados dados) {

        this.dados = dados;
        this.dados.addObserver(this);
        super.setLayout(new BorderLayout());
        super.setPreferredSize(new Dimension(100, 500));
        
        
        super.addMouseListener(new UCSListener());
        update(dados,null);
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
            g.drawString(getIniciais(uc.getNome()), x+5, y + h);
            y += 30;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE");
    }
    
    public String getIniciais(String uc){
        String initials = "";
        for (int i = 0; i < uc.length(); i++) {
            char letter = uc.charAt(i);
            if (isUpperCase(letter)) {
                initials += uc.charAt(i);
            }
        }
        return initials;
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
                       dados.setEstado(2);
                       System.out.println(dados.getEstado());
                    }
                    y0+=30;
                    yM+=30;
                }
            }
            
        
        }
    }
}
