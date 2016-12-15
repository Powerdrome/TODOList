/*
    class HoraAula
    Versão 1.0 30/11/16
*/
package todolist;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class HoraAula implements Serializable {
    private static final long serialVersionUID = 1L;
    private int tipo; //0 - teórica, 1 - prática, 2 - tprática
    private String sala;
    private String uc;
    private int turma;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
 
    public HoraAula(int tipo, String sala, int turma, String uc) {
        this.tipo = tipo;
        this.sala = sala;
        this.turma = turma;
        this.uc = uc;
    }
    public HoraAula(String uc, String turma, String sala) {
        this.uc = uc;
        this.turma = Integer.parseInt(turma);
        this.sala = sala;
    }
    public HoraAula(int tipo, String sala, GregorianCalendar inicio,
            GregorianCalendar fim, String uc) {
        this.tipo = tipo;
        this.sala = sala;
        this.inicio = inicio;
        this.fim = fim;
        this.uc = uc;
    }

    public String getUc() {
        return uc;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setInicio(String inicio) throws ParseException{
        Date data;
        try {
            data =  formatter.parse(inicio);
        } catch (ParseException ex) {
            data = null;
            throw ex;
        }
        if(data != null) {
            this.inicio = new GregorianCalendar();
            this.inicio.setTime(data);
        }
    }

    public void setFim(String fim) throws ParseException{        
        Date data;
        try {
            data =  formatter.parse(fim);
        } catch (ParseException ex) {
            data = null;
            throw ex;
        }
        if(data != null) {
            this.fim = new GregorianCalendar();
            this.fim.setTime(data);
        }
    }

    public void setInicio(int ano, int mes, int dia, int hora, int minuto) {
        inicio = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }

    public void setFim(int ano, int mes, int dia, int hora, int minuto) {
        fim = new GregorianCalendar(ano, mes, dia, hora, minuto);
    }
    
    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
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

    @Override
    public String toString() {
        return "HoraAula{" + "\ntipo=" + tipo + "\nsala=" + sala + "\nturma=" + turma + "\ninicio=" + inicio.getTime() + "\nfim=" + fim.getTime() + '}';
    }
    
    
}
