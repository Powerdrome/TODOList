/*
    class Dica
    Versão 1.0 30/11/16
    
*/
package todolist;

import java.io.Serializable;

public class Dica implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String dica;

    public Dica(String titulo, String nota) {
        this.titulo = titulo;
        this.dica = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNota() {
        return dica;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNota(String nota) {
        this.dica = nota;
    }
}
