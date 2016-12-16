
package todolist;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;

public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    String nome;
    GregorianCalendar inicio;
    GregorianCalendar fim;
    boolean concluido;

    public Tarefa(String nome) {
        this.nome = nome;
        concluido = false;
    }

    public String getNome() {
        return nome;
    }

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public GregorianCalendar getFim() {
        return fim;
    }  
    
    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        inicio = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }
    
    public void setInicio(GregorianCalendar inicio) {
        this.inicio = inicio;
    }

    public void setFim(GregorianCalendar fim) {
        this.fim = fim;
    }
    
    public boolean getConcluido(){
        return concluido;
    }
    
    public void Concluido(){
        this.concluido = true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    @Override
    public String toString() {
        String inicioStr = inicio.get(Calendar.DATE)+"/"+inicio.get(Calendar.MONTH)
                +"/"+inicio.get(Calendar.YEAR)
                +" "+inicio.get(Calendar.HOUR_OF_DAY)+":"+inicio.get(Calendar.MINUTE);

        String fimStr = fim.get(Calendar.DATE)+""+"/"+fim.get(Calendar.MONTH)
                +"/"+fim.get(Calendar.YEAR)
                +" "+fim.get(Calendar.HOUR_OF_DAY)+":"+fim.get(Calendar.MINUTE);

        return "\n\nnome=" + nome + "\nInicio=" + inicioStr + ", \nFim=" + fimStr;
    }
}
