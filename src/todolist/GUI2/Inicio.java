package todolist.GUI2;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import todolist.Dica;
import todolist.Exame;
import todolist.HoraAula;
import todolist.HoraEstudo;
import todolist.Nota;
import todolist.UnidadeCurricular;

public class Inicio extends JPanel {
   public static void main(String[] args) {
        int ver = 1; //1->Calendario 2->Tarefas
        todolist.Dados dados = new todolist.Dados();
        @SuppressWarnings("unchecked")
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(ver == 1)
            frame.add(new Calendario(), BorderLayout.CENTER);
        else if(ver == 2)
            frame.add(new Tarefas(), BorderLayout.CENTER);
<<<<<<< HEAD
        
        frame.add(new BarraLateral(), BorderLayout.WEST);
=======
        frame.add(new BarraLateral(dados), BorderLayout.WEST);
>>>>>>> refs/remotes/origin/master
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