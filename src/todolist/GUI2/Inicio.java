/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist.GUI2;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inicio extends JPanel {
   
   public static void main(String[] args) {
      
        @SuppressWarnings("unchecked")
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new Calendario(), BorderLayout.CENTER);
        frame.add(new BarraLateral2(), BorderLayout.WEST);
        frame.add(new BarraSuperior(), BorderLayout.NORTH);
      
        frame.pack();
        int x = 870, y=600;
        frame.setSize(x, y);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GRAY);
        if(System.getProperty("os.name").contains("Windows")) {
            frame.setResizable(false);
        }
        else {
            frame.setMinimumSize(new Dimension(x, y));
            frame.setMaximumSize(new Dimension(x, y));
        }
   }
}