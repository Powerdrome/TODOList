/*
    class Nota
    Versão 1.0 30/11/16
    
*/
package todolist;

import java.io.Serializable;

public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Titulo;
    private String Nota;

    public Nota(String Titulo, String Nota){
        this.Titulo = Titulo;
        this.Nota = Nota;
    }

    public String getNota() {
        return Nota;
    }
    
    public String getTitulo() {
        return Titulo;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    
    @Override
    public String toString() {
        return "Titulo: "+Titulo+" Nota: "+Nota;
    }
}
