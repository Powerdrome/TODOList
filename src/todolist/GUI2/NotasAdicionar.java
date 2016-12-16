/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import todolist.Dados;
import todolist.Nota;

/**
 *
 * @author Paulo
 */
public class NotasAdicionar extends JPanel implements Observer{
    todolist.Dados dados;
    JButton btnCancelar, btnAdicionar;
    JTextField titulo;
    JTextArea nota;

    public NotasAdicionar(Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        
        setLayout(new BorderLayout());
        createAndDisplay();
        this.setPreferredSize(new Dimension(100, 100));
        createAndDisplay();
        registarListeners();
        placeholder();
        //update(dados,null);
    }
        
        protected void createAndDisplay(){

        titulo = new JTextField("Titulo para a nota");
        nota = new JTextArea("Introduza a nota"); //Talvez Usar TextArea
        
        btnAdicionar = new JButton("Adicionar");
        btnCancelar = new JButton("Cancelar");


        JPanel frame = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.fill = GridBagConstraints.BOTH;
        
        //Primeira Coluna
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        
        
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 0;
        frame.add(titulo, gc);
        
        //Segunda Coluna
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        frame.add(nota, gc);
        
        //Terceira Coluna
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 3;
        frame.add(btnCancelar, gc);
        gc.gridx = 1;
        gc.gridy = 3;
        frame.add(btnAdicionar, gc);

        add(frame);

    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhaNotas(g);
        //setBackground(Color.white);
    }
    
    protected void desenhaNotas(Graphics g){
        g.setFont(new Font("",0,20));
        g.drawRect(10, 10, 700, 75);
    }
    
    protected void registarListeners(){
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.setEstado(4);
                System.out.println("Cancela nota!!");
                titulo.setText("Titulo para a nota");
                nota.setText("Introduza a nota");                          
                
         }          
      });
        
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("Adiciona nota!!");
                System.out.println("Titulo da Nota: " + titulo.getText());
                System.out.println("Nota: "+ nota.getText());
                
                String novoTitulo, novaNotaTexto;
                
                novoTitulo = titulo.getText();
                if(novoTitulo.isEmpty()){
                    novoTitulo = "Erro -> Nota x";
                }
                novaNotaTexto = nota.getText();
                if(novaNotaTexto.isEmpty()){
                    novaNotaTexto = "Erro -> texto";
                }
                
                Nota novaNota = new Nota(novoTitulo,novaNotaTexto);
                dados.addNota(novaNota);
                dados.setEstado(4);
                titulo.setText("Titulo para a nota");
                nota.setText("Introduza a nota"); 
            }
        });
        
    }

    @Override
    public void update(Observable o, Object arg) {
        //update
    }

    private void placeholder() {
        //titulo
        titulo.setText("Titulo para a nota");
        titulo.setForeground(new Color(150,150,140));
        titulo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(titulo.getText().equalsIgnoreCase("Titulo para a nota")){
                    titulo.setText("");
                    titulo.setForeground(new Color(50,50,50));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(titulo.getText().length()==0){
                    titulo.setText("Titulo para a nota");
                    titulo.setForeground(new Color(150,150,150));
                }
            }
        });
        
        //nota
        nota.setText("Introduza a nota");
        nota.setForeground(new Color(150,150,140));
        nota.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(nota.getText().equalsIgnoreCase("Introduza a nota")){
                    nota.setText("");
                    nota.setForeground(new Color(50,50,50));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(nota.getText().length()==0){
                    nota.setText("Introduza a nota");
                    nota.setForeground(new Color(150,150,150));
                }
            }
        });
    }

   
}
