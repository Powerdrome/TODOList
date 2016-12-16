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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import todolist.Tarefa;

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
    Tarefa tr = null;
    public TarefasAdicionar(todolist.Dados dados) {
        this.dados = dados;
        this.dados.addObserver(this);
        
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100, 100));
        createAndDisplay();
        registarListeners();
        placeholder();
        verificaExistenciaTarefa();
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
        col1.add(data);
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
                dados.setTarefaActual(null);
                dados.setEstado(2);
            }     
        });
        
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vI = verificaInsercao();
                System.out.println(vI);
                if(vI.isEmpty()){
                    //System.out.println("Tudo ok... Vamos proseguir");
                    try {
                        String strData = data.getData();
                        int dia = Integer.parseInt(strData.substring(0, 2));
                        int mes = Integer.parseInt(strData.substring(3, 5));
                        int ano = Integer.parseInt(strData.substring(6, 10));
                
                        int horaI = Integer.parseInt(inicio.getText().substring(0,2));
                        int horaF = Integer.parseInt(fim.getText().substring(0,2));
                
                        int minI = Integer.parseInt(inicio.getText().substring(3,5));
                        int minF = Integer.parseInt(fim.getText().substring(3,5));
                        
                        Tarefa novaTarefa = new Tarefa(tarefa.getText());
                        novaTarefa.setInicio(ano, (mes-1), dia, horaI, minI);
                        novaTarefa.setFim(ano, (mes-1), dia, horaF, minF);
                        
                        if(dados.getTarefaActual() != null){
                            tr.setInicio(ano, (mes-1), dia, horaI, minI);
                            tr.setFim(ano, (mes-1), dia, horaF, minF);
                            tr.setNome(tarefa.getText());
                            //tr = novaTarefa;
                        }else{
                            dados.addTarefa(novaTarefa);
                        }
                        
                        
                        dados.setEstado(2);
                    }catch(NumberFormatException b){
                        JOptionPane.showMessageDialog(null, "As horas não estão num formato correcto\n",
                        "Erro!", JOptionPane.ERROR_MESSAGE);
                    }catch(Exception b){
                        JOptionPane.showMessageDialog(null, "Alguma coisa correu mal",
                        "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, vI,
                        "Aviso!", JOptionPane.WARNING_MESSAGE);
                    System.out.println(vI);
                }
                
            }
        });
        
    }

    @Override
    public void update(Observable o, Object arg) {
        //update
        System.out.println("Update");
        tr = null;
        verificaExistenciaTarefa();
    }
    
    private String verificaInsercao(){
        String a = "";
        if(tarefa.getText().equalsIgnoreCase("Tarefa") || tarefa.getText().isEmpty())
            a += "Deve inserir o nome da tarefa\n";
        if(inicio.getText().equalsIgnoreCase("HH:mm") || inicio.getText().isEmpty())
            a+= "Deve inserir uma hora correcta de inicio\n";
        if(fim.getText().equalsIgnoreCase("HH:mm") || fim.getText().isEmpty())
            a+= "Deve inserir uma hora correcta de fim\n";
        return a;
    }
    
    protected void placeholder(){
        inicio.setText("HH:mm");
        inicio.setForeground(new Color(150, 150, 150));
        
        inicio.addFocusListener(new FocusListener() {  

        @Override  
        public void focusGained(FocusEvent e) {
            if(inicio.getText().equalsIgnoreCase("HH:mm")){
                inicio.setText("");
                inicio.setForeground(new Color(50, 50, 50)); 
            }
        }

        @Override  
        public void focusLost(FocusEvent e) { 
            if (inicio.getText().length() == 0) {  
                inicio.setText("HH:mm");  
                inicio.setForeground(new Color(150, 150, 150));  
            }  
        }  
        });
        
        fim.setText("HH:mm");
        fim.setForeground(new Color(150, 150, 150));
        
        fim.addFocusListener(new FocusListener() {  

        @Override  
        public void focusGained(FocusEvent e) {
            if(fim.getText().equalsIgnoreCase("HH:mm")){
                fim.setText("");
                fim.setForeground(new Color(50, 50, 50));  
            }
        }

        @Override  
        public void focusLost(FocusEvent e) { 
            if (fim.getText().length() == 0) {  
                fim.setText("HH:mm");  
                fim.setForeground(new Color(150, 150, 150));  
            }  
        }  
        });
        
        tarefa.setText("Tarefa");
        tarefa.setForeground(new Color(150, 150, 150));
        
        tarefa.addFocusListener(new FocusListener() {  

        @Override  
        public void focusGained(FocusEvent e) {
            if(tarefa.getText().equalsIgnoreCase("Tarefa")){
                tarefa.setText("");
                tarefa.setForeground(new Color(50, 50, 50));  
            }
        }

        @Override  
        public void focusLost(FocusEvent e) { 
            if (tarefa.getText().length() == 0) {  
                tarefa.setText("Tarefa");  
                tarefa.setForeground(new Color(150, 150, 150));  
            }  
        }  
        });
        
    }
    
    public void verificaExistenciaTarefa(){
        System.out.println("----Verifica Existencia---");
        if(dados.getTarefaActual() != null){
            System.out.println("Inseri dados");
            tr = dados.getTarefaActual();
            String hI = getFormated(tr.getInicio(), "HH:mm");
            String hF = getFormated(tr.getFim(), "HH:mm");
            tarefa.setText(tr.getNome());
            fim.setText(hF);
            inicio.setText(hI);
        }else{
            tr = null;
            //System.out.println("Problemas");
        }
    }
    
    private String getFormated(GregorianCalendar gC, String formato){     
        DateFormat oDateFormat = new SimpleDateFormat(formato);
        String formated = oDateFormat.format(gC.getTime());
        return formated;
    }
}
