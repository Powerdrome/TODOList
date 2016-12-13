package todolist.GUI2;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ScrollDicas extends JPanel implements Observer{
    todolist.Dados dados;
    
    public ScrollDicas(todolist.Dados dados) {
        setLayout(new BorderLayout());
        this.dados = dados;
        this.dados.addObserver(this);
        
        JScrollPane jsp = new JScrollPane(new Dicas(dados));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(jsp, BorderLayout.CENTER);
        update(dados,null);  
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(dados.getEstado() == 6){
            // Para já não faz nada 
            // Só mais tarde, é que eu tenho uma consulta às 17h e tenho que abandonar
        }
    
    }
}