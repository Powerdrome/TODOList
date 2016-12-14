/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollTarefas extends JPanel implements Observer{
    todolist.Dados dados;
    JPanel addTarefa;
    public ScrollTarefas(todolist.Dados dados) {
        setLayout(new BorderLayout());
        this.dados = dados;
        this.dados.addObserver(this);
        Tarefas x = new Tarefas(dados);
        addTarefa = new TarefasAdicionar(dados);
        
        
        JScrollPane jsp = new JScrollPane(new Tarefas(dados));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(jsp, BorderLayout.CENTER);
        
        update(dados,null);
        
        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(dados.getEstado() == 3){ //3
            add(addTarefa, BorderLayout.SOUTH);
        }else{
            remove(addTarefa);
        }
    
    }
}