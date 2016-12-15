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
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.Nota;

/**
 *
 * @author Paulo
 */
//teste
public class Notas extends JPanel implements Observer{
    Dados dados;
    public Notas(Dados dados) {
        this.dados = dados;
        setLayout(new BorderLayout());
        super.addMouseListener(new AcaoNota());
        update(dados,null);
    }
    
   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        desenhaNotas(g);
        setBackground(Color.white);
    }
    
    
    protected void desenhaNotas(Graphics g){
        int x = 10, y = 10;
        int i = 0;
        
        try{
            if(dados.getNotas().isEmpty() || dados.getNotas() == null){
                return;
            }
        }catch(Exception e){
            System.out.println("Notas_Verificação: "+ e);
        }
        
        try{
            for(Nota n : dados.getNotas()){
                //titulo
                g.setFont(new Font("",0,20));
                g.drawRect(10, y, 700, 75);
                String tituloNota = n.getTitulo();
                g.drawString(tituloNota, (20), (y+18));
                
                //nota
                g.setFont(new Font("",0,10));
                String textoNota = n.getNota();
                g.drawString(textoNota, (15), (y+32));
                y+=100;
                i++;
            }
            setPreferredSize(new Dimension(0,(i*100)));
        }catch(Exception e){
            System.out.println("Notas_desenhaNotas: "+ e);
        }
        
        
/*
        //teste
        for(i = 0; i < 3; i++){
            g.setFont(new Font("",0,20));
            g.drawRect(10, y, 700, 75);
            
            //g.drawString("Nota " + i, (35), (y+40));
            g.drawString("Nota " + i, (20), (y+18));
            
            g.setFont(new Font("",0,10));
            //String notasss = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            //dividir em linhas com 110 elementos
            
            g.drawString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 15, (y+32)); //limite 110 por linha
            g.drawString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 15, (y+42));
            g.drawString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 15, (y+52));
            g.drawString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 15, (y+62));
            
            
            //g.drawLine(550, y, 550, y+75);
            //g.drawString("12/12/2017", 600, y+25);
            //g.drawString("", 590, y+50);
            y+=100;
        }
        setPreferredSize(new Dimension(0, (i*100)));
*/
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    class AcaoNota extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX(), y = e.getY();
            int xI = 10, yI = 10;
            
            for(Nota n : dados.getNotas()){
                if(x>xI && x<xI+700 && y>yI && y<yI+85){
                    //System.out.println("Este é o "+i+"º");
                    String titulo = n.getTitulo();
                    JDialog mydialog = new NotasAcao(dados, n);
                }
                yI+=100;
            }
        }
    }
    
}
