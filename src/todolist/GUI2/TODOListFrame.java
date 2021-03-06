/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import todolist.Dados;


/**
 *
 * @author Ricardo
 */
class TODOListFrame extends JFrame implements Observer{

    private Dados dados;
    private Calendario cal;
    //private Tarefas tar;
    private ScrollTarefas tar;
    private ScrollNotas sNotas;
    private ScrollDicas sDicas;
    
    public TODOListFrame(Dados dados) {
        super("TODOList");
        this.dados = dados;
        dados.addObserver(this);

        
        if (dados.getEstado() == 0) {
            new EscolherCadeiras(this, dados);
            new EscolherHoras(this, dados);
            dados.carregaDicas();
        }

        cal = new Calendario(dados);
        cal.setBackground(Color.gray);
        tar = new ScrollTarefas(dados);
        sNotas = new ScrollNotas(dados);
        sDicas = new ScrollDicas(dados);
        
        dados.setEstado(1);
        //tar = new Tarefas(dados);
        //tar.setBackground(Color.blue);
        
        addCompontes();
        
        validate();
    }

    private void addCompontes() {
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dados.guardaCalendario();
            }
        });
        
        add(new BarraSuperior(dados), BorderLayout.NORTH);
        add(new BarraLateral(dados), BorderLayout.WEST);
        add(new Calendario(dados), BorderLayout.CENTER);
        
      
        pack();
        int x = 870, y=600;
        setSize(x, y);
        
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        if(System.getProperty("os.name").contains("Windows")) {
            setResizable(false);
        } else {
            setMinimumSize(new Dimension(x, y));
            setMaximumSize(new Dimension(x, y));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE - MAIN");
        remove(cal);
        remove(tar);
        remove(sNotas);
        remove(sDicas);
        if(dados.getEstado() == 1){
            add(cal, BorderLayout.CENTER);
        }else if(dados.getEstado() == 2 || dados.getEstado() == 3){
            add(tar, BorderLayout.CENTER);
            System.out.println("Devia aparecer outra coisa");
        }else if(dados.getEstado() == 4 || dados.getEstado() == 5){
            add(sNotas, BorderLayout.CENTER);
            System.out.println("Notas - Devia aparecer outra coisa");
        }else if(dados.getEstado() == 6) {
            add(sDicas, BorderLayout.CENTER);
            System.out.println("Dicas - Para os meninos aprenderem como se faz");
        }
        
        repaint();
    }
    
}
