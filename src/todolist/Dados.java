/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.List;
import java.util.Observable;

/**
 *
 * @author Rui
 */
public class Dados extends Observable{
    private Calendario calendario;
    
    public Dados() {
        calendario = new Calendario();
    }
    
    public Dados(Calendario calendario) {
        this.calendario = calendario;
    }
    
    public List getHoras() {
        return calendario.getHoras();
    }
}
