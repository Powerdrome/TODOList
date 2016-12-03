/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class testeScroll extends JPanel {
    public testeScroll(todolist.Dados dados) {
        Tarefas container = new Tarefas(dados);
        //container.setBackground(Color.white);
        //repaint();
        
        JScrollPane jsp = new JScrollPane(container);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setPreferredSize(new Dimension(770,540));
        
        container.setPreferredSize(new Dimension(500, 2500));
        
        add(jsp);
    }
}