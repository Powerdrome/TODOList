package todolist;

public class Dica {
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
