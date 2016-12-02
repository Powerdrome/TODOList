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
import javax.swing.JFrame;
import todolist.Dados;
import static todolist.GUI2.Inicio.dados;


/**
 *
 * @author Ricardo
 */
class TODOListFrame extends JFrame implements Observer{

    private Dados dados;
    public TODOListFrame(Dados dados) {
        super("TODOList");
        this.dados=dados;
        
        dados.addObserver(this);
        
        addCompontes();
        
        validate();
    }

    private void addCompontes() {
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        add(new BarraLateral(dados), BorderLayout.WEST);
        add(new BarraLateral(dados), BorderLayout.WEST);
        add(new BarraSuperior(), BorderLayout.NORTH);
      
        pack();
        int x = 870, y=600;
        setSize(x, y);
        
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        if(System.getProperty("os.name").contains("Windows")) {
            setResizable(false);
        }
        else {
            setMinimumSize(new Dimension(x, y));
            setMaximumSize(new Dimension(x, y));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(dados.getEstado() == 1)
            add(new Calendario(), BorderLayout.CENTER);
        else if(dados.getEstado() == 2)
            add(new Tarefas(), BorderLayout.CENTER);
    }
    
}
