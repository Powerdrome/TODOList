package todolist;

import java.util.Calendar;

public class Exame {
    Calendar inicio;
    Calendar fim;
    String epoca;

    public Exame(Calendar inicio, Calendar fim, String epoca) {
        this.inicio = inicio;
        this.fim = fim;
        this.epoca = epoca;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public void setFim(Calendar fim) {
        this.fim = fim;
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
