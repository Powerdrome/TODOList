
package todolist;

import java.io.Serializable;
import java.util.Observable;

public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String tarefa;

    public Tarefa(String titulo, String tarefa) {
        this.titulo = titulo;
        this.tarefa = tarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
    
    @Override
    public String toString() {
        return "Titulo: "+titulo+" Tarefa: "+tarefa;
    }
}
