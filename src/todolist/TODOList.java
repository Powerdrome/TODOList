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
        
        Exame exame1 = new Exame("Normal");
        exame1.setInicio(2016, 11, 29, 14, 0);
        exame1.setFim(2016, 11, 29, 16, 0);
        System.out.println(exame1.getInicio().get(Calendar.DATE));
    }
    
}
