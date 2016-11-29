package todolist;

import java.util.ArrayList;
import java.util.Collections;

public class Calendario {
    private ArrayList<UnidadeCurricular> cadeiras;

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
    
    public ArrayList<Hora> getHoras(){
        ArrayList<Hora> horas = new ArrayList<>();
        String exame;
        for(UnidadeCurricular uc : cadeiras){
            for(HoraAula ha: (uc.getAulas())){
                horas.add(new Hora(uc.getNome(), ha.getInicio(), ha.getFim()));
            }
            for(HoraEstudo he: (uc.getHorasEstudo())){
                horas.add(new Hora(he.getTitulo(), he.getInicio(), he.getFim()));
            }
            for(Exame ex: (uc.getExames())){
                exame = "exame: "+uc.getNome();
                horas.add(new Hora(exame, ex.getInicio(), ex.getFim()));
            }
        }
        Collections.sort(horas, new ComparadorHoras());
        return horas;
    }
}
