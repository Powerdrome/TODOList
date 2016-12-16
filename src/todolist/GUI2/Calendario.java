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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import todolist.HoraAula;
import todolist.HoraEstudo;
import todolist.UnidadeCurricular;
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
        if(show){
            DesenhaHoras(g);
            DesenhaDias(g);
            DesenhaLista(g);
            DesenhaHorasEstudo(g);
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
        int x, y, horas, minutos, tam;
        GregorianCalendar inicio, fim;
        String nome;
        for(UnidadeCurricular uc : dados.getCadeiras())
            for(HoraAula ha : uc.getAulas()){
                nome = uc.getNome();
                inicio = ha.getInicio();
                fim = ha.getFim();
            
        
                //inicio = new GregorianCalendar(2016, 11, 1, 10, 30);
                //fim = new GregorianCalendar(2016, 11, 1, 12, 0);
        
                x = (((inicio.get(Calendar.DAY_OF_WEEK)-2)*100)+50);
                y = ((((inicio.get(Calendar.HOUR_OF_DAY)-9)*30)
                        +((inicio.get(Calendar.MINUTE))/2))+35);
                
                horas =  fim.get(Calendar.HOUR_OF_DAY) 
                        - inicio.get(Calendar.HOUR_OF_DAY);
                
                minutos = fim.get(Calendar.MINUTE) 
                        - inicio.get(Calendar.MINUTE);
                if(minutos<0){
                    horas--;
                    minutos += 60;
                }
                
                
                tam = ((horas*30)+(minutos/2));
                
                System.out.println("<------------------>");
                System.out.println("Cadeira: "+ nome + " x: " + x + " y: " + y + "\nhoras: " + horas
                    + " minutos: " + minutos + " tam: " + tam);
                
                System.out.println("Inicio " + getFormated(inicio, "dd/MM/yyyy HH:mm"));
                System.out.println("Fim " + getFormated(fim, "dd/MM/yyyy HH:mm"));
                System.out.println("<------------------>");
                
                g.setColor(Color.blue);
                g.fillRect(x, y, 100, tam);
                g.setColor(Color.white);
                g.drawString(nome, x+5, y+10);
        
        }
        
    }
    
    public void DesenhaHorasEstudo(Graphics g){
        g.setFont(new Font("",0,10));
        int x, y, horas, minutos, tam;
        GregorianCalendar inicio, fim;
        String nome;
        for(HoraEstudo he : dados.getHorasEstudo()){
                GregorianCalendar actual = new GregorianCalendar();
                nome = he.getTitulo();
                if(nome.length()>19){
                    nome = nome.substring(0, 17) + "...";
                }
                inicio = he.getInicio();
                fim = he.getFim();
            
                
                int semanaAno = inicio.get(Calendar.WEEK_OF_YEAR);
                int actualSemanaAno = actual.get(Calendar.WEEK_OF_YEAR);
                int ano = inicio.get(Calendar.YEAR);
                int anoActual = actual.get(Calendar.YEAR);
                if((semanaAno != actualSemanaAno) && ano != anoActual)
                    continue;
                    
                //inicio = new GregorianCalendar(2016, 11, 1, 10, 30);
                //fim = new GregorianCalendar(2016, 11, 1, 12, 0);
        
                x = (((inicio.get(Calendar.DAY_OF_WEEK)-2)*100)+50);
                y = ((((inicio.get(Calendar.HOUR_OF_DAY)-9)*30)
                        +((inicio.get(Calendar.MINUTE))/2))+35);
                
                horas =  fim.get(Calendar.HOUR_OF_DAY) 
                        - inicio.get(Calendar.HOUR_OF_DAY);
                
                minutos = fim.get(Calendar.MINUTE) 
                        - inicio.get(Calendar.MINUTE);
                if(minutos<0){
                    horas--;
                    minutos += 60;
                }
                
                
                tam = ((horas*30)+(minutos/2));
                
                //System.out.println("Inicio " + getFormated(inicio, "HH:mm"));
                //System.out.println("Fim " + getFormated(fim, "HH:mm"));
                
                //System.out.println("Cadeira: "+ nome + " x: " + x + " y: " + y + "\nhoras: " + horas
                    //+ " minutos: " + minutos + " tam: " + tam);
                
                g.setColor(new Color(124, 19, 21));
                g.fillRect(x, y, 100, tam);
                g.setColor(Color.white);
                g.drawString(nome, x+5, y+10);
        
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
