package todolist.GUI2;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import todolist.Dica;
import todolist.Exame;
import todolist.HoraAula;
import todolist.HoraEstudo;
import todolist.Nota;
import todolist.UnidadeCurricular;

public class Inicio extends JPanel implements Observer{
   static JFrame frame  = new JFrame();
   static todolist.Dados dados = new todolist.Dados();
   public static void main(String[] args) {
        //@SuppressWarnings("unchecked");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(dados.getEstado() == 1)
            frame.add(new Calendario(), BorderLayout.CENTER);
<<<<<<< HEAD
        else if(ver == 2)
            //frame.add(new Tarefas(), BorderLayout.CENTER);
=======
        else if(dados.getEstado() == 2)
            frame.add(new Tarefas(), BorderLayout.CENTER);
>>>>>>> refs/remotes/origin/master

        
        frame.add(new BarraLateral(dados), BorderLayout.WEST);

        frame.add(new BarraLateral(dados), BorderLayout.WEST);

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
   @Override
    public void update(Observable arg0, Object arg1) {
        if(dados.getEstado() == 1)
            frame.add(new Calendario(), BorderLayout.CENTER);
        else if(dados.getEstado() == 2)
            frame.add(new Tarefas(), BorderLayout.CENTER);
    }
}