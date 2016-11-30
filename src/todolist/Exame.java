package todolist;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exame {
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private String epoca;

    public Exame(String epoca) {
        this.epoca = epoca;
    }

    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        inicio = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public GregorianCalendar getFim() {
        return fim;
    }

    public String getEpoca() {
        return epoca;
    }
    
    
    
}
