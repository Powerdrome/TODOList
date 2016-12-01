/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
}