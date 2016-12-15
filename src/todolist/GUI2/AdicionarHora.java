/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import todolist.HoraEstudo;

/**
 *
 * @author G21
 */
public class AdicionarHora  extends JDialog implements Observer{
    todolist.Dados dados;
    private DatePickerExample data_inicio;
    private DatePickerExample data_fim;
    JButton botao;
    JTextField hora_inicio_field;
    JLabel hora_inicio;
    JLabel minuto_inicio ;
    JTextField minuto_inicio_field ;
    JLabel minuto_fim ;
    JTextField hora_fim_field ;
    JLabel hora_fim ;
    JTextField minuto_fim_field ;
    JTextField fieldNome;
    HoraEstudo novaHora;
    public AdicionarHora(todolist.Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLUE);
        setSize(new Dimension(400,200));
        setLocation(200,200);
        setTitle("Adicionar Hora");
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(true);

        
        
        
        
    }
    protected void createAndDisplay(){
        
        Box box_horizontal = Box.createHorizontalBox();
        Box box_horizonta2 = Box.createHorizontalBox();
        Box box_horizonta3 = Box.createHorizontalBox();
        Box box_vertical = Box.createVerticalBox();
        
        JPanel frame = new JPanel(new SpringLayout());
        
        
        
        
        
        
        JLabel nome = new JLabel("Hora de Estudo");
        fieldNome = new JTextField(3);
        
        JLabel inicio = new JLabel("Inicio");
        data_inicio = new DatePickerExample();
        
        JLabel fim = new JLabel("Fim   ");  
        data_fim = new DatePickerExample();
        
        hora_inicio = new JLabel("Hora:");
        hora_inicio_field = new JTextField(3);
        
        
        minuto_inicio = new JLabel("Minuto:");
        minuto_inicio_field = new JTextField(3);
        
        minuto_fim = new JLabel("Minuto:");
        hora_fim_field = new JTextField(3);
        hora_fim = new JLabel("Hora:");
        minuto_fim_field = new JTextField(3);
        
        
        botao = new JButton("Inserir");
        botao.setBounds(100,100,10,10);
        botao.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                String dat_inicio = data_inicio.getData();
                int dia_inicio = Integer.parseInt(dat_inicio.substring(0, 2));
                int mes_inicio = Integer.parseInt(dat_inicio.substring(3, 5));
                int ano_inicio = Integer.parseInt(dat_inicio.substring(6, 10));
                
                String dat_fim = data_fim.getData();
                int dia_fim = Integer.parseInt(dat_fim.substring(0, 2));
                int mes_fim = Integer.parseInt(dat_fim.substring(3, 5));
                int ano_fim = Integer.parseInt(dat_fim.substring(6, 10));
                
                int hora_inicio,hora_fim;
                int minuto_inicio,minuto_fim;
                String aula = fieldNome.getText();
                
                hora_inicio = Integer.parseInt(hora_inicio_field.getText());
                hora_fim = Integer.parseInt(hora_fim_field.getText());
                
                minuto_inicio = Integer.parseInt(minuto_inicio_field.getText());
                minuto_fim = Integer.parseInt(minuto_fim_field.getText());
                
                
                
                System.out.println(aula);
                System.out.println(dia_inicio+":"+mes_inicio+":"+ano_inicio);
                System.out.println(dia_fim+":"+mes_fim+":"+ano_fim);
                System.out.println(hora_inicio+":"+minuto_inicio);
                System.out.println(hora_fim+":"+minuto_inicio); 
                
                novaHora = new HoraEstudo(aula);
                novaHora.setInicio(ano_inicio, mes_inicio, dia_inicio, hora_inicio, minuto_inicio);
                novaHora.setInicio(ano_fim, mes_fim, dia_fim, hora_fim, hora_fim);   
                
                 
                
                
             }
         });
        
        
        
        
        
        box_horizontal.add(nome); 
        box_horizontal.add(fieldNome);
  
        
        box_horizonta2.add(inicio);
        box_horizonta2.add(data_inicio);
        box_horizonta2.add(hora_inicio);
        box_horizonta2.add(hora_inicio_field);
        box_horizonta2.add(minuto_inicio);
        box_horizonta2.add(minuto_inicio_field);
        
        
        box_horizonta3.add(fim);
        box_horizonta3.add(data_fim);
        box_horizonta3.add(hora_fim);
        box_horizonta3.add(hora_fim_field);
        box_horizonta3.add(minuto_fim);
        box_horizonta3.add(minuto_fim_field);
        
        
         
        box_vertical.add(box_horizontal);
       
        box_vertical.add(box_horizonta2);
        
        box_vertical.add(box_horizonta3);
        
        
        frame.add(box_vertical);
        
        JPanel frameBotao = new JPanel();
        frameBotao.add(botao);
        
       
        add(frame, BorderLayout.CENTER);
        add(frameBotao, BorderLayout.SOUTH);
        
        
        
        
        
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
