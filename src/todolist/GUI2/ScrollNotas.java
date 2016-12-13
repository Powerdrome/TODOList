/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Paulo
 */
public class ScrollNotas extends JPanel implements Observer{
    todolist.Dados dados;
    JPanel addNota;
    public ScrollNotas(todolist.Dados dados) {
        setLayout(new BorderLayout());
        this.dados = dados;
        this.dados.addObserver(this);
        
        addNota = new NotasAdicionar(dados);
        
        JScrollPane jsp = new JScrollPane(new Notas(dados));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(jsp, BorderLayout.CENTER);
        update(dados,null);
        
        
        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(dados.getEstado() == 5){
            add(addNota, BorderLayout.SOUTH);
        }else{
            remove(addNota);
        }
    
    }
}