package todolist;

import java.util.Calendar;

public class horaAula {
    int tipo;
    String sala;
    Calendar inicio;
    Calendar fim;
    
    

    public horaAula(int tipo, String sala) {
        this.tipo = tipo;
        this.sala = sala;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        inicio.set(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim.set(ano, mes, dia, hora, minuto);
    }

    public int getTipo() {
        return tipo;
    }

    public String getSala() {
        return sala;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public Calendar getFim() {
        return fim;
    }       
}
