package todolist.GUI2;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import todolist.Dados;
import todolist.Dica;
import todolist.Exame;
import todolist.HoraAula;
import todolist.HoraEstudo;
import todolist.Nota;
import todolist.UnidadeCurricular;

public class Inicio {
   
   static Dados dados = new Dados();
   
   public static void main(String[] args) {
       
       new TODOListFrame(dados);

   }
   
}