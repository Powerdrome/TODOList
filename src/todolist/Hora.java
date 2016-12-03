/*
	class Hora
	Versão 1.0 30/11/2016
	
 */
package todolist;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Hora {
    String nome;
    GregorianCalendar inicio;
    GregorianCalendar fim;

    public Hora(String nome, GregorianCalendar inicio, GregorianCalendar fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.inicio);
        hash = 53 * hash + Objects.hashCode(this.fim);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hora other = (Hora) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fim, other.fim)) {
            return false;
        }
        return true;
    }
        
}