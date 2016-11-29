/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.Calendar;

/**
 *
 * @author Ricardo
 */
public class TODOList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendario calendario = new Calendario();
        UnidadeCurricular pa_uc = new UnidadeCurricular("Programação Distrubuída", 2, 1);
        Nota pa_nota = new Nota("Programação Distribuida Nota", "Isto é uma nota para PA");
        
        Dica pa_dica = new Dica("Programação Distribuida Dica", "Isto é uma dica pra PA");
       
        Exame pa_exame = new Exame("Normal");
        pa_exame.setInicio(2017,01,14,14,30);
        pa_exame.setFim(2017,01,14,16,30);
        
        HoraAula pa_horaaula = new HoraAula(1, "L2.1");
        pa_horaaula.setInicio(2017,01,14,17,30);
        pa_horaaula.setFim(2017,01,14,18,00);
        
        HoraEstudo pa_horaestudo = new HoraEstudo("Hora de Estudo de PA");
        pa_horaaula.setInicio(2017,01,14,17,30);
        pa_horaaula.setFim(2017,01,14,18,00);
        
        pa_uc.addAulas(pa_horaaula);
        pa_uc.addDica(pa_dica);
        pa_uc.addHoraEstudo(pa_horaestudo);
        pa_uc.addNota(pa_nota);
        pa_uc.addExame(pa_exame);
        
        calendario.addCadeira(pa_uc);
        System.out.println("todolist.TODOList.main()");
        
    }
    
}
