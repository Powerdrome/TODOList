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

    public NotasAcao(Dados dados) {
        this.dados = dados;
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 70));
        setLocation(200, 200);
        setTitle("Que operação pretende realizar para a Nota x?");
        createAndDisplay();
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setVisible(true);
        
    }

    protected void createAndDisplay() {
        JPanel frame = new JPanel(new GridLayout(0, 2));
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(100,100,10,10);
        
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(100,100,10,10);
        
        frame.add(btnEliminar);
        frame.add(btnEditar);
        
        frame.setBackground(Color.gray);
        add(frame, BorderLayout.CENTER);      
    }
    
    
    
}
