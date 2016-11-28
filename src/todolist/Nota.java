package todolist;

public class Nota {
    private String Titulo;
    private String Nota;

    public Nota(String Nota, String Titulo) {
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
