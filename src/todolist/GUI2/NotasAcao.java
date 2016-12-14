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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import todolist.Dados;

/**
 *
 * @author Paulo
 */
public class NotasAcao extends JDialog {
    Dados dados;
    JButton btnEliminar, btnEditar;
    int numNota;

    public NotasAcao(Dados dados, int numNota) {
        this.dados = dados;
        this.numNota = numNota;
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 70));
        setLocation(200, 200);
        setTitle("Que operação pretende realizar para a Nota "+numNota+"?");
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        registarListeners();
        setVisible(true);
        
    }

    protected void createAndDisplay() {
        JPanel frame = new JPanel(new GridLayout(0, 2));
        
        btnEliminar = new JButton("Eliminar Nota " + numNota);
        //btnEliminar.setBounds(100,100,10,10);
        
        btnEditar = new JButton("Editar Nota "+ numNota);
        //btnEditar.setBounds(100,100,10,10);
        
        frame.add(btnEliminar);
        frame.add(btnEditar);
        
        frame.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);      
    }

    protected void registarListeners() {
        btnEliminar.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {                
                System.out.println("Eliminar Nota "+numNota);
                dispose();
                
            }
        });
        
        btnEditar.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Editar Nota "+numNota);
                
                dispose();
            }
        });        
    }
        
    
    
}
