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
    private int turma;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
 
    public HoraAula(int tipo, String sala, int turma) {
        this.tipo = tipo;
        this.sala = sala;
        this.turma = turma;
    }
    
    public HoraAula(int tipo, String sala, GregorianCalendar inicio,
            GregorianCalendar fim) {
        this.tipo = tipo;
        this.sala = sala;
        this.inicio = inicio;
        this.fim = fim;
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
