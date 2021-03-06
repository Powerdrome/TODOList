package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.Dica;


public class Dicas extends JPanel implements Observer {
    
    todolist.Dados dados;
    ArrayList<Dica> dicas;
    
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
        int x = 10;
        int y = 10;
        int i = 0;
        try{
        dicas = dados.getDicas();
        if(dicas.isEmpty() || dicas == null)
            return;
        }catch(Exception e){
            System.out.println("Dicas_Verificação: "+ e);
        }
        try{
        for(Dica t : dicas) {
            g.setFont(new Font("",0,20));
            g.drawRect(10, y, 700, 75);
            String string = t.getTitulo();
            g.drawString(string, (35), (y+40));
            g.setFont(new Font("",0,15));
            
            y+= 100;
            i++;
        }
        setPreferredSize(new Dimension(0, (i*100)));
        }catch(Exception e){
            System.out.println("Dicas_desenhaDicas: "+ e);
        }
        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE - DICAS");
        repaint();
    }
    
    class UCSListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
        
            int x = e.getX(), y = e.getY();
            int xI = 10, yI = 10;
            
            for(Dica t : dicas){
                if(x>xI && x<xI+700 && y>yI && y<yI+85){
                    //System.out.println("Este é o "+i+"º");
                    String titulo = t.getTitulo();
                    new DicasAcao(titulo, t.getDica());
                }
                 yI+=100;
            } 
        }
    }
}
    
    

