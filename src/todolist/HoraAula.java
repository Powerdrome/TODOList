/*
    class HoraAula
    Versão 1.0 30/11/16
    
*/
package todolist;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class HoraAula implements Serializable {
    private static final long serialVersionUID = 1L;
    private int tipo;
    private String sala;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
 
    public HoraAula(int tipo, String sala) {
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
        inicio = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public int getTipo() {
        return tipo;
    }

    public String getSala() {
        return sala;
    }

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public GregorianCalendar getFim() {
        return fim;
    }       
}
