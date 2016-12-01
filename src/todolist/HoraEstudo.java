package todolist;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HoraEstudo {
    private String titulo;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;

    public HoraEstudo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public GregorianCalendar getFim() {
        return fim;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        inicio = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }
    
    
}
