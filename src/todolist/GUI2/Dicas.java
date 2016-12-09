package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import todolist.Dados;


public class Dicas extends JPanel {

    Dicas(Dados dados) {
        setLayout(new BorderLayout());
    }
    
    @Override
    public void paint(Graphics g) {
        desenhaDicas(g);
        setBackground(Color.white);
    }
    
    protected void desenhaDicas(Graphics g){
        g.setFont(new Font("",0,20));
        g.drawRect(10, 10, 700, 75);
        g.drawString("Dica x", (20+15), (20+30));
        g.setFont(new Font("",0,15));
        g.drawLine(550, 10, 550, 85);
        g.drawString("25/01/2525", 600, 35);
        g.drawString("18h00 - 20h30", 590, 60);
    }

}
