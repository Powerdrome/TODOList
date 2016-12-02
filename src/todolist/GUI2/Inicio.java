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
        int ver = 2; //1->Calendario 2->Tarefas
        
        @SuppressWarnings("unchecked")
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(ver == 1)
            frame.add(new Calendario(), BorderLayout.CENTER);
        else if(ver == 2)
            frame.add(new Tarefas(), BorderLayout.CENTER);
        
        frame.add(new BarraLateral(), BorderLayout.WEST);
        frame.add(new BarraSuperior(), BorderLayout.NORTH);
      
        frame.pack();
        int x = 870, y=600;
        frame.setSize(x, y);
        
        criar_uc();
        
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

    private static void criar_uc() {
        todolist.Calendario calendario = new todolist.Calendario();
        
        UnidadeCurricular pa_uc = new UnidadeCurricular("Programação Distrubuída", 2, 1);
        Nota pa_nota = new Nota("Programação Distribuida Nota", "Isto é uma nota para PA");
        
        Dica pa_dica = new Dica("Programação Distribuida Dica", "Isto é uma dica pra PA");
       
        Exame pa_exame = new Exame("Normal");
        pa_exame.setInicio(2017,01,14,14,30);
        pa_exame.setFim(2017,01,14,16,30);
        
        HoraAula pa_horaaula = new HoraAula(1, "L2.1");
        pa_horaaula.setInicio(2016,01,14,17,30);
        pa_horaaula.setFim(2016,01,14,18,00);
        
        HoraEstudo pa_horaestudo = new HoraEstudo("Hora d e Estudo de PA");
        pa_horaestudo.setInicio(2017,01,13,17,30);
        pa_horaestudo.setFim(2017,01,13,18,00);
        
        pa_uc.addAulas(pa_horaaula);
        pa_uc.addDica(pa_dica);
        pa_uc.addNota(pa_nota);
        pa_uc.addExame(pa_exame);
        pa_uc.addHoraEstudo(pa_horaestudo);
        
        calendario.addCadeira(pa_uc);
    }
}