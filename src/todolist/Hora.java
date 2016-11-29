/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.GregorianCalendar;

/**
 *
 * @author jorgetrovisco
 */
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
    
    
}
