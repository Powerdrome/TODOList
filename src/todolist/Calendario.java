/*
    class Calendario
    Versão 1.1 30/11/16
    
*/
package todolist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Observable;

public class Calendario extends Observable {
    private ArrayList<UnidadeCurricular> cadeiras;

    public Calendario() {
        cadeiras = new ArrayList<>();
    }

    public ArrayList<UnidadeCurricular> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<UnidadeCurricular> cadeiras) {
        this.cadeiras = cadeiras;
        setChanged();
        notifyObservers();
    }
    
    public void addCadeira(UnidadeCurricular cadeira){
        cadeiras.add(cadeira);
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<Hora> getHoras(){
        ArrayList<Hora> horas = new ArrayList<>();
        String exame;
        for(UnidadeCurricular uc : cadeiras){
            for(HoraAula ha: (uc.getAulas())){
                horas.add(new Hora(uc.getNome(), ha.getInicio(), ha.getFim()));
            }
            for(HoraEstudo he: (uc.getHorasEstudo())){
                horas.add(new Hora(he.getTitulo(), he.getInicio(),
                        he.getFim()));
            }
            for(Exame ex: (uc.getExames())){
                exame = "exame: "+uc.getNome();
                horas.add(new Hora(exame, ex.getInicio(), ex.getFim()));
            }
        }
        Collections.sort(horas, new ComparadorHoras());
        return horas;
    }
    
private class Hora {
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

private class ComparadorHoras implements Comparator<Hora>{

    @Override
    public int compare(Hora o1, Hora o2) {
        if (o1.getInicio().get(Calendar.YEAR) 
                != o2.getInicio().get(Calendar.YEAR)) {
            return o1.getInicio().get(Calendar.YEAR) 
                    - o2.getInicio().get(Calendar.YEAR);
        } else if (o1.getInicio().get(Calendar.MONTH) 
                != o2.getInicio().get(Calendar.MONTH)) {
            return o1.getInicio().get(Calendar.DATE) 
                    - o2.getInicio().get(Calendar.DATE);
        } else if (o1.getInicio().get(Calendar.DATE)
                != o2.getInicio().get(Calendar.DATE)) {
            return o1.getInicio().get(Calendar.DATE) 
                    - o2.getInicio().get(Calendar.DATE);
        } else if (o1.getInicio().get(Calendar.HOUR_OF_DAY) 
                != o2.getInicio().get(Calendar.HOUR_OF_DAY)) {
            return o1.getInicio().get(Calendar.HOUR) 
                    - o2.getInicio().get(Calendar.HOUR);  
        }
        return o1.getInicio().get(Calendar.MINUTE) 
                - o2.getInicio().get(Calendar.MINUTE);
    }
    
}

}
