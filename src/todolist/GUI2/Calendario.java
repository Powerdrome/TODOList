/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

        
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
/**
 *
 * @author jorgetrovisco
 */
public class Calendario extends JPanel  implements Observer{
    todolist.Dados dados;
    boolean show;
    public Calendario(todolist.Dados dados){
        this.dados = dados;
        this.dados.addObserver(this);
        show = true;
        setLayout(new BorderLayout());
        update(dados,null);
    }
    public void paint(Graphics g) {
//        g.setFont(new Font("",0,15));
//        FontMetrics fm = getFontMetrics(new Font("",0,15));
//        String s = "message";
//        int x = 5, y = 5;
//        int w = getWidth(s, fm);
//        int h = fm.getHeight();
//        g.drawRect(x, y, w, h);
//        g.drawString(s + h, x, y + h);
        if(show){
            DesenhaHoras(g);
            DesenhaDias(g);
            DesenhaLista(g);
        }
    }
    public int getWidth(String s, FontMetrics fm){
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            w += fm.charWidth(c);
        }
        return w;
    }
    public void DesenhaHoras(Graphics g){
        g.setFont(new Font("",0,15));
        FontMetrics fm = getFontMetrics(new Font("",0,15));
        int x=5, y=35;
        int hora=9, minuto=0;
        String horas;
        g.drawLine(5, 35, 500, 35);
        for(int i=0; i<15; i++){            
            horas = hora+"h";
            if(hora<10)
                horas = "0"+horas;
            int w = getWidth(horas, fm);
            int h = fm.getHeight();
            g.drawRect(x, y, 45, 30);
            g.drawString(horas, x+5, y + h);
            y += 30;
            hora++;
        }
        horas = "00h";
            int w = getWidth(horas, fm);
            int h = fm.getHeight();
            g.drawRect(x, y, 45, 30);
            g.drawString(horas, x+5, y + h);
    }
    public void DesenhaDias(Graphics g){
        g.setFont(new Font("",0,15));
        FontMetrics fm = getFontMetrics(new Font("",0,15));
        int x=50, y=5;
        String dia;
        Calendar cal = Calendar.getInstance();
        //System.out.println("Data Actual:" + cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("EEE dd/MM");
        //System.out.println("Primeiro dia da semana: "+df.format(cal.getTime()));
        for (int i = 0; i < 7; i++) {
            dia = df.format(cal.getTime());
            int w = getWidth(dia, fm);
            int h = fm.getHeight();
            g.drawRect(x, y, 100, 30);
            g.drawString(dia, x+5, y + h);
            cal.add(Calendar.DATE, 1);
            x +=100;
        }
    }
    public void DesenhaLista(Graphics g){
        g.setFont(new Font("",0,10));
        
        GregorianCalendar inicio = new GregorianCalendar(2016, 11, 1, 10, 30);
        GregorianCalendar fim = new GregorianCalendar(2016, 11, 1, 12, 0);
        
        int x = (((inicio.get(Calendar.DAY_OF_WEEK)-2)*100)+50);
        int y = ((((inicio.get(Calendar.HOUR_OF_DAY)-9)*30)+((inicio.get(Calendar.MINUTE))/2))+35);
        int horas =  fim.get(Calendar.HOUR_OF_DAY) - inicio.get(Calendar.HOUR_OF_DAY);
        int minutos = fim.get(Calendar.MINUTE) - inicio.get(Calendar.MINUTE);
        int tam = ((horas*30)+(minutos/2));
        
        g.setColor(Color.blue);
        g.fillRect(x, y, 100, tam);
        g.setColor(Color.white);
        g.drawString("Aula PA", x+5, y+10);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        if(dados.getEstado() == 1){
            show = true;
        }else{
            show = false;
        }
        revalidate();
        validate();
        repaint();
    }
}
