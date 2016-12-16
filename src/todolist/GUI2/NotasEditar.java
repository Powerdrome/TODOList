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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import todolist.Dados;
import todolist.Nota;

/**
 *
 * @author Paulo
 */
public class NotasEditar extends JDialog {
    todolist.Dados dados;
    JButton btnCancelar, btnEditar;
    JTextField titulo;
    JTextArea nota;
    Nota notaEdit;

    public NotasEditar(Dados dados, Nota notaEdit) {
        this.dados = dados;
        this.notaEdit = notaEdit;
        
        setLayout(new BorderLayout());
        setSize(new Dimension(600, 150));
        setLocation(200, 200);
        setTitle("Edição da Nota "+ notaEdit.getTitulo());
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        registarListeners();
        setVisible(true);
        
        //update(dados,null);
    }
        
    protected void createAndDisplay(){
        titulo = new JTextField(notaEdit.getTitulo());
        nota = new JTextArea(notaEdit.getNota());
        
        btnEditar = new JButton("Editar");
        btnCancelar = new JButton("Cancelar");


        JPanel frame = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.fill = GridBagConstraints.BOTH;
        
        //Primeira Coluna
        gc.weightx = 0.3;
        gc.weighty = 0.3;
        
        
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
        gc.weightx = 0.3;
        gc.weighty = 0.3;
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 3;
        frame.add(btnCancelar, gc);
        gc.gridx = 1;
        gc.gridy = 3;
        frame.add(btnEditar, gc);

        add(frame);

    }
    
    
    protected void registarListeners(){
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                
                System.out.println("Cancela Edição da nota!!");
                titulo.setText("Titulo para a nota");
                nota.setText("Introduza a nota");
                dispose();
                
         }          
      });
        
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("Editar nota!!");
                System.out.println("Titulo da Nota: " + titulo.getText());
                System.out.println("Nota: "+ nota.getText());
//                
                String novoTitulo, novaNotaTexto;
                
                novoTitulo = titulo.getText();
                if(novoTitulo.isEmpty()){
                    novoTitulo = "Erro -> Nota x";
                }
                novaNotaTexto = nota.getText();
                if(novaNotaTexto.isEmpty()){
                    novaNotaTexto = "Erro -> texto";
                }
                
                Nota novaNotaEdit = new Nota(novoTitulo,novaNotaTexto);
                dados.setNotas_v2(novaNotaEdit, notaEdit);
                                
                titulo.setText("Titulo para a nota");
                nota.setText("Introduza a nota");
                dados.actualiza();
                dispose();
            }
        });
        
    }


   
}
