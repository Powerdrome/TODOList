/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 *
 * @author jorgetrovisco
 */
public class ComparadorHoras implements Comparator<Hora>{

    @Override
    public int compare(Hora o1, Hora o2) {
        if(o1.getInicio().get(Calendar.YEAR) != o2.getInicio().get(Calendar.YEAR))
            return o1.getInicio().get(Calendar.YEAR) - o2.getInicio().get(Calendar.YEAR);
        if(o1.getInicio().get(Calendar.MONTH) != o2.getInicio().get(Calendar.MONTH))
            return o1.getInicio().get(Calendar.DATE) - o2.getInicio().get(Calendar.DATE);
        if(o1.getInicio().get(Calendar.DATE) != o2.getInicio().get(Calendar.DATE))
            return o1.getInicio().get(Calendar.DATE) - o2.getInicio().get(Calendar.DATE);
        if(o1.getInicio().get(Calendar.HOUR) != o2.getInicio().get(Calendar.HOUR))
            return o1.getInicio().get(Calendar.HOUR) - o2.getInicio().get(Calendar.HOUR);  
        return o1.getInicio().get(Calendar.MINUTE) - o2.getInicio().get(Calendar.MINUTE);
    }
    
}
