/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class TODOList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        
        UnidadeCurricular pa_uc = new UnidadeCurricular("Programação Distribuída", 2, 1);
        Nota pa_nota = new Nota("Programação Distribuida Nota", "Isto é uma nota para PA");
        
        Dica pa_dica = new Dica("Programação Distribuida Dica", "Isto é uma dica pra PA");
       
        Exame pa_exame = new Exame("Normal");
        pa_exame.setInicio(2017,01,14,14,30);
        pa_exame.setFim(2017,01,14,16,30);
        
        HoraAula pa_horaaula = new HoraAula(1, "L2.1", 1, "Programação Avançada");
        try {
            pa_horaaula.setInicio("14/01/2016 17:30");
            pa_horaaula.setFim("14/01/2016 18:00");
        } catch (ParseException ex) {
            Logger.getLogger(TODOList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HoraEstudo pa_horaestudo = new HoraEstudo("Hora de Estudo de PA");
        pa_horaestudo.setInicio(2017,01,13,17,30);
        pa_horaestudo.setFim(2017,01,13,18,00);
        
        pa_uc.addAula(pa_horaaula);
        pa_uc.addDica(pa_dica);
        pa_uc.addNota(pa_nota);
        pa_uc.addExame(pa_exame);
        calendario.addHoraEstudo(pa_horaestudo);

        calendario.addCadeira(pa_uc);
        System.out.println("todolist.TODO List.main()");
        
        for(Hora hr: calendario.getHoras()){
            System.out.println(hr.getNome());
        }
        for(Hora hr: calendario.getHoras()){
            System.out.println(hr.getInicio().get(Calendar.DATE));
        }
        System.out.println("\n\nGETHORAS ORIG:");
        System.out.println(calendario.getHoras());
        
// Imprime 1º dia da semana e toda a semana
Calendar cal = Calendar.getInstance();
System.out.println("Data Actual:" + cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
System.out.println("Primeiro dia da semana: "+df.format(cal.getTime()));
for (int i = 0; i < 7; i++) {
    System.out.println(df.format(cal.getTime()));
    cal.add(Calendar.DATE, 1);
}

        System.out.println("todolist.TODOList.main()");
        
        Exame exame1 = new Exame("Normal");
        exame1.setInicio(2016, 11, 29, 14, 0);
        exame1.setFim(2016, 11, 29, 16, 0);
    }
    
}
