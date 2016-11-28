package todolist;

import java.util.Calendar;

public class HoraEstudo {
    private String titulo;
    private Calendar inicio;
    private Calendar fim;

    public HoraEstudo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        this.inicio.set(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        this.fim.set(ano, mes, dia, hora, minuto);
    }
    
    
}
