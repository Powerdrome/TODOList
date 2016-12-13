/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author G21
 */
public class TarefasAdicionar extends JPanel implements Observer{
    todolist.Dados dados;
    JButton btnCancelar;
    JButton btnAdicionar;
    JTextField tarefa;
    DatePickerExample data;
    JTextField inicio;
    JTextField fim;
    public TarefasAdicionar(todolist.Dados dados) {
        this.dados = dados;
        this.dados = dados;
        this.dados.addObserver(this);
        
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100, 100));
        createAndDisplay();
        registarListeners();
        update(dados,null);
    }
    
    protected void createAndDisplay(){
        JPanel frame = new JPanel(new GridLayout(3,0));
        //JLabel 
        JLabel jlData = new JLabel("Data");
        JLabel jlInicio = new JLabel("Inicio");
        JLabel jlFim = new JLabel("Fim");
        tarefa = new JTextField("Tarefa");        
        data = new DatePickerExample();
        inicio = new JTextField("hh:mm");
        fim = new JTextField("hh:mm");
        btnAdicionar = new JButton("Adicionar");
        btnCancelar = new JButton("Cancelar");
        
        
        JPanel linha2 = new JPanel(new GridLayout(0,2));
        JPanel col1 = new JPanel(new GridLayout(0,2));
        col1.add(jlData);
        col1.add(new DatePickerExample());
        //JPanel linha3 = new JPanel(new GridLayout(0,2));´
        JPanel col2 = new JPanel(new GridLayout(0,2));
        col2.add(jlInicio);
        col2.add(inicio);
        JPanel col3 = new JPanel(new GridLayout(0,2));
        col3.add(jlFim);
        col3.add(fim);
        JPanel col4 = new JPanel(new GridLayout(0,2));
        col4.add(col2);
        col4.add(col3);
        
        linha2.add(col1);
        linha2.add(col4);
        
        //dividir em 2 meter os 
        JPanel linha4 =new JPanel(new GridLayout(0,2));
        linha4.add(btnCancelar);
        linha4.add(btnAdicionar);
        
        frame.add(tarefa);
        frame.add(linha2);
        //frame.add(linha3);
        frame.add(linha4);
        add(frame);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        desenhaTarefas(g);
        //setBackground(Color.white);
    }
    
    protected void desenhaTarefas(Graphics g){
        g.setFont(new Font("",0,20));
        g.drawRect(10, 10, 700, 75);
    }
    
    protected void registarListeners(){
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(2);
            }     
        });
        
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = "";
                a += "Tarefa: " + tarefa.getText() + "\n";
                a += "Data: " + data.getData() + "\n";
                a += "Inicio: " + inicio.getText() + "\n";
                a += "Fim: " + fim.getText();
                System.out.println(a);
                
//                String vI = verificaInsercao();
//                if(vI.isEmpty())
//                    System.out.println("Tudo ok... Vamos proseguir");
//                else
//                    System.out.println(vI);
//                //System.out.println(a);
            }
        });
        
    }

    @Override
    public void update(Observable o, Object arg) {
        //update
    }
    
    private String verificaInsercao(){
        String a = "";
        if(tarefa.getText().equalsIgnoreCase("Tarefa") || tarefa.getText().isEmpty())
            a += "Deve inserir o nome da tarefa";
        if(inicio.getText().equalsIgnoreCase("hh:mm") || inicio.getText().isEmpty())
            a+= "Deve inserir uma data correcta";
        if(fim.getText().equalsIgnoreCase("hh:mm") || fim.getText().isEmpty())
            a+= "Deve inserir uma data correcta";
        return a;
    }
}
