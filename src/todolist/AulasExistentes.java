package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AulasExistentes implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<HoraAula> aulas;
    private ArrayList<DicaBase> dicas;

    public AulasExistentes() {
        this.aulas = new ArrayList<>();
        this.dicas = new ArrayList<>();
    }

    public ArrayList<HoraAula> getAulas() {
        return aulas;
    }
    
    public ArrayList<DicaBase> getDicas() {
        return dicas;
    }
    
    public void addDica(String uc, String nome, String dica) {
        dicas.add(new DicaBase(uc, nome, dica));
    }
    
    public void addHora(HoraAula hora){
        aulas.add(hora);
    }
    
    public String [] getHorasAulasT(String nomeUC) {
        ArrayList<String> arr = new ArrayList<>();
        String [] arrT = null;
        String string = null;
        for (HoraAula h: aulas) {
            if (h.getUc().equals(nomeUC) && h.getTipo() == 0) {
                string = "T " + h.getTurma();
                if (!arr.contains(string)) {
                    arr.add(string);
                }
            }
        }
        arrT = new String [arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrT[i] = arr.get(i);
        }
        return arrT;
    }
    
    public String [] getHorasAulasP(String nomeUC) {
        ArrayList<String> arr = new ArrayList<>();
        String [] arrP;
        String string;
        for(HoraAula h: aulas) {
            if(h.getUc().equals(nomeUC) && h.getTipo() == 1) {
                string = "P " + h.getTurma();
                if (!arr.contains(string)) {
                    arr.add(string);
                }
            }
        }
        arrP = new String [arr.size()];
        for(int i = 0; i < arr.size(); i++)
            arrP[i] = arr.get(i);
        
        return arrP;
    }
    
    public String [] getHorasAulasTP(String nomeUC) {
        ArrayList<String> arr = new ArrayList<>();
        String [] arrTP;
        String string;
        
        for(HoraAula h: aulas) {
            if(h.getUc().equals(nomeUC) && h.getTipo() == 2) {
                string = "TP " + h.getTurma();
                if (!arr.contains(string)) {
                    arr.add(string);
                }
            }
        }
        arrTP = new String [arr.size()];
        for(int i = 0; i < arr.size(); i++)
            arrTP[i] = arr.get(i);
        
        return arrTP;
    }
    
    public ArrayList<HoraAula> getHoraAulas(String desc, String nomeUC) {
        StringTokenizer token = new StringTokenizer(desc," ");
        String tipoS = token.nextToken();
        ArrayList<HoraAula> arrAulas = new ArrayList<>();
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
                System.err.println("Tipo de aula errado.");
                tipo = -1;
                break;
        }
        System.err.println("A procurar turmas: tipo=" + tipo + " , turma=" + turma);
        if(tipo > -1 && turma > -1)
            for(HoraAula h: aulas) {
                if(h.getTurma() == turma && h.getTipo() == tipo && h.getUc().equals(nomeUC)) {
                    arrAulas.add(h);
                }
            }
        
        if(aulas.size() == 0) {
            System.err.println("Nao ha aulas para esta UC.");
            return null;
        }
        return arrAulas;
    }
}
