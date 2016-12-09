/*
    class Dica
    Versão 1.1 09/12/16
    
*/
package todolist;

import java.io.Serializable;

public class Dica implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String dica;

    public Dica(String titulo, String dica) {
        this.titulo = titulo;
        this.dica = dica;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDica() {
        return dica;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
    
    @Override
    public String toString() {
        return "Titulo: "+titulo+" Dica: "+dica;
    }
}
