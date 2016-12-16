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
import java.util.Arrays;
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
                g.setFont(new Font("",0,20));
                //g.drawRect(10, y, 700, 75);
                g.setColor(new Color(150,150,140));
                g.drawString("Não existem notas associadas a esta unidade curricular", (20), (y+18));
                g.drawString("Carregue no botão '+' para introduzir uma nota", (20), (y+48));
                
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
                //g.drawString(textoNota, (15), (y+32));
                
                String aux;
                if(textoNota.length()<110){
                    aux = textoNota.substring(0, textoNota.length());                
                    g.drawString(aux, (15), (y+32));
                }else{
                    aux = textoNota.substring(0, 109);
                    g.drawString(aux,(15),(y+32));
                }
                if(textoNota.length()>110){
                    if(textoNota.length()>219){
                        aux = textoNota.substring(109, 219);
                        g.drawString(aux, (15), (y+42));
                    }else{
                        aux = textoNota.substring(109, textoNota.length());
                        g.drawString(aux, (15), (y+42));
                    }
                }
                if(textoNota.length()>220){
                    if(textoNota.length()>329){
                        aux = textoNota.substring(219, 329);
                        g.drawString(aux, (15), (y+52));
                    }else{
                        aux = textoNota.substring(219, textoNota.length());
                        g.drawString(aux, (15), (y+52));                        
                    }
                }
                if(textoNota.length()>330){
                    if(textoNota.length()>438){
                        aux = textoNota.substring(329, 439);
                        g.drawString(aux, (15), (y+62));
                    }else{
                        aux = textoNota.substring(329, textoNota.length());
                        g.drawString(aux, (15), (y+62));
                    }
                }
                if(textoNota.length()>440){
                    if(textoNota.length()>548){
                        aux = textoNota.substring(439, 549);
                        g.drawString(aux, (15), (y+72));
                    }else{
                        aux = textoNota.substring(439, textoNota.length());
                        g.drawString(aux, (15), (y+72));
                    }
                }

                y+=100;
                i++;
            }
            setPreferredSize(new Dimension(0,(i*100)));
        }catch(Exception e){
            System.out.println("Notas_desenhaNotas: "+ e);
        }
               

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
                   
                    String titulo = n.getTitulo();
                    JDialog mydialog = new NotasAcao(dados, n);
                }
                yI+=100;
            }
        }
    }
    
}
