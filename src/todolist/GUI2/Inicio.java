package todolist.GUI2;

import todolist.Dados;

public class Inicio {
   
   static Dados dados = new Dados();
   
   public static void main(String[] args) {
       
       new TODOListFrame(dados);

   }
   
}