/*
    class Dados
    Versão 1.0 - 1/12/2016
 */
package todolist;

import java.util.ArrayList;
import java.util.Observable;

public class Dados extends Observable{
    private Calendario calendario;
    
    public Dados() {
        calendario = new Calendario();
    }
    
    public Dados(Calendario calendario) {
        this.calendario = calendario;
    }
    
    public ArrayList<Hora> getHoras() {
        return calendario.getHoras();
    }
    public ArrayList<UnidadeCurricular> getCadeiras() {
        return calendario.getCadeiras();
    }
}
