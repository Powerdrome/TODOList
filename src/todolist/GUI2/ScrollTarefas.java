/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollTarefas extends JPanel {
    public ScrollTarefas(todolist.Dados dados) {
        setLayout(new BorderLayout());
        
        JScrollPane jsp = new JScrollPane(new Tarefas(dados));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(jsp, BorderLayout.CENTER);
        
        JPanel addTarefa = new JPanel();
        addTarefa.setBackground(Color.red);
        //addTarefa.
        add(addTarefa, BorderLayout.SOUTH);
    }
}