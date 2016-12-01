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
      
<<<<<<< HEAD
      @SuppressWarnings("unchecked")
      JFrame frame = new JFrame();
      
      frame.setLayout(new BorderLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
        @SuppressWarnings("unchecked")
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>>>>>>> refs/remotes/origin/master
      
        frame.add(new Calendario(), BorderLayout.CENTER);
        frame.add(new BarraLateral(), BorderLayout.WEST);
        frame.add(new BarraSuperior(), BorderLayout.NORTH);
      
<<<<<<< HEAD
      frame.pack();
      frame.setSize(1200, 700);
      frame.setMinimumSize(new Dimension(1000, 500));
      
      
      frame.setVisible(true);
      frame.getContentPane().setBackground(Color.GRAY);
=======
        frame.pack();
        frame.setSize(1200, 700);
        frame.setMinimumSize(new Dimension(1000, 500));
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GRAY);

>>>>>>> refs/remotes/origin/master
   }
}