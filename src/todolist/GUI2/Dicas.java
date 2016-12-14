package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.UnidadeCurricular;


public class Dicas extends JPanel implements Observer {
    
    todolist.Dados dados;
    
    
    Dicas(Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        setLayout(new BorderLayout());
        
        super.addMouseListener(new UCSListener());
        update(dados,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        desenhaDicas(g);
        
        
        setBackground(Color.white);
    }
    
    
    
    
    protected void desenhaDicas(Graphics g){
        g.setFont(new Font("",0,20));
        g.drawRect(10, 10, 700, 75);
        g.drawString("Dica x", (20+15), (20+30));
        g.setFont(new Font("",0,15));
        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE - DICAS");
    }
    
    class UCSListener extends MouseAdapter{
    
    
        Boolean mouseOvering = false;
        
        @Override
        public void mouseEntered(MouseEvent e) {
       this.mouseOvering = true;
    }
        
        @Override
        public void mouseExited(MouseEvent e) {
       this.mouseOvering = false;
    }
        
        @Override
        public void mousePressed(MouseEvent e) {
        
            int x = e.getX();
            int y = e.getY();
            
            int y0=5;
            int yM=30;
            
            if(this.mouseOvering) {
                JDialog mydialog = new DicasAcao(dados);
                
                
            }
            
        
        }
    }
    
    
}
