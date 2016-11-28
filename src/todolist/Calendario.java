package todolist;

import java.util.ArrayList;

public class Calendario {
    ArrayList<UnidadeCurricular> cadeiras;

    public Calendario() {
        cadeiras = new ArrayList<>();
    }

    public ArrayList<UnidadeCurricular> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<UnidadeCurricular> cadeiras) {
        this.cadeiras = cadeiras;
    }
    
    public void addCadeira(UnidadeCurricular cadeira){
        cadeiras.add(cadeira);
    }
}
