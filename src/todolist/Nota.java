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
    boolean existe;

    public Nota(String Titulo, String Nota){
        this.Titulo = Titulo;
        this.Nota = Nota;
        existe = true;
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

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public boolean isExiste() {
        return existe;
    }
    
    
    @Override
    public String toString() {
        return "Titulo: "+Titulo+" Nota: "+Nota;
    }
}
