package todolist;

import java.util.Calendar;

public class Exame {
    Calendar inicio;
    Calendar fim;
    String epoca;

    public Exame(String epoca) {
        this.epoca = epoca;
    }

    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        inicio.set(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim.set(ano, mes, dia, hora, minuto);
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public String getEpoca() {
        return epoca;
    }
    
    
    
}
