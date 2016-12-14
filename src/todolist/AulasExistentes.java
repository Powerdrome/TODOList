package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AulasExistentes implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<HoraAula> aulas;

    public AulasExistentes() {
        this.aulas = new ArrayList<>();
    }

    public ArrayList<HoraAula> getAulas() {
        return aulas;
    }
    
    public void addHora(HoraAula hora){
        aulas.add(hora);
    }
    
    public String [] getHorasAulasT(String nomeUC) {
        ArrayList<String> arr = new ArrayList<>();
        String [] arrT;
        for(HoraAula h: aulas) {
            if(h.getUc().equals(nomeUC) && h.getTipo() == 0)
                arr.add("T " + h.getTurma());
        }
        arrT = new String [arr.size()];
        for(int i = 0; i < arr.size(); i++)
            arrT[i] = arr.get(i);
        
        return arrT;
    }
    
    public String [] getHorasAulasP(String nomeUC) {
        ArrayList<String> arr = new ArrayList<>();
        String [] arrP;
        
        for(HoraAula h: aulas) {
            if(h.getUc().equals(nomeUC) && h.getTipo() == 1)
                arr.add("P " + h.getTurma());
        }
        arrP = new String [arr.size()];
        for(int i = 0; i < arr.size(); i++)
            arrP[i] = arr.get(i);
        
        return arrP;
    }
    
    public String [] getHorasAulasTP(String nomeUC) {
        ArrayList<String> arr = new ArrayList<>();
        String [] arrTP;
        
        for(HoraAula h: aulas) {
            if(h.getUc().equals(nomeUC) && h.getTipo() == 2)
                arr.add("TP " + h.getTurma());
        }
        arrTP = new String [arr.size()];
        for(int i = 0; i < arr.size(); i++)
            arrTP[i] = arr.get(i);
        
        return arrTP;
    }
    
    public HoraAula getHoraAula(String desc, String nomeUC) {
        StringTokenizer token = new StringTokenizer(desc," ");
        String tipoS = token.nextToken();
        int turma;
        int tipo;
        
        try {
            turma = Integer.parseInt(token.nextToken());
        } catch(NumberFormatException ex) {
            System.err.println(ex.toString());
            turma = -1;
        }
        switch(tipoS) {
            case "T":
                tipo = 0;
                break;
            case "P":
                tipo = 1;
                break;
            case "TP":
                tipo = 2;
                break;
            default:
                tipo = -1;
                break;
        }
        
        if(tipo >= 0 && turma >= 0)
            for(HoraAula h: aulas) {
                if(h.getTurma() == turma && h.getTipo() == tipo)
                    return h;
            }
        
        return null;
    }
}
