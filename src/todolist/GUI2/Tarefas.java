package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.Tarefa;

/**
 *
 * @author G21
 */
public class Tarefas extends JPanel implements Observer{
    Dados dados;
    
    Tarefas(Dados dados) {
        this.dados = dados;
        setLayout(new BorderLayout());
        //setSize(new Dimension(4000, 7000));
        super.addMouseListener(new AcaoTarefa());
        update(dados,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        desenhaTarefas(g);
        setBackground(Color.white);
    }
    
    protected void desenhaTarefas(Graphics g){
        int x = 10;
        int y = 10;
        int i = 0;
        try{
            if(dados.getTarefas().isEmpty() || dados.getTarefas() == null){
                g.setFont(new Font("",0,20));
                //g.drawRect(10, y, 700, 75);
                g.setColor(new Color(150,150,140));
                g.drawString("Não existem tarefas associadas a esta unidade curricular", (20), (y+18));
                g.drawString("Carregue no botão '+' para introduzir uma tarefa", (20), (y+48));
                return;
            }
        }catch(Exception e){
            System.out.println("Tarefas_Verificação: "+ e);
        }
        try{
        for(Tarefa t : dados.getTarefas()) {
            g.setFont(new Font("",0,20));
            g.drawRect(10, y, 700, 75);
            String string = t.getNome();
            g.drawString(string, (35), (y+40));
            g.setFont(new Font("",0,15));
            g.drawLine(550, y, 550, y+75);
            String data = getFormated(t.getInicio(), "dd/MM/yyyy");
            g.drawString(data, 600, y+25);
            String horaI = getFormated(t.getInicio(), "HH:mm");
            String horaF = getFormated(t.getFim(), "HH:mm");
            g.drawString(horaI + " - " + horaF, 590, y+50);
            y+= 100;
            i++;
        }
        setPreferredSize(new Dimension(0, (i*100)));
        }catch(Exception e){
            System.out.println("Tarefas_desenhaTarefas: "+ e);
        }
        
    }
    
    private String getFormated(GregorianCalendar gC, String formato){     
        DateFormat oDateFormat = new SimpleDateFormat(formato);
        Date newDate = gC.getTime();
        String formated = oDateFormat.format(gC.getTime());
        return formated;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
    class AcaoTarefa extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
        
            int x = e.getX(), y = e.getY();
            int xI = 10, yI = 10;
            
            for(Tarefa t : dados.getTarefas()){
                if(x>xI && x<xI+700 && y>yI && y<yI+85){
                    //System.out.println("Este é o "+i+"º");
                    String titulo = t.getNome();
                    JDialog mydialog = new TarefasAcao(dados, t);
                }
                yI+=100;
            } 
        }
    }
}
