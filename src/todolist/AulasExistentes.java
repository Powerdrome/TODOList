package todolist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Rui
 */
public class AulasExistentes implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> nomeUCs = new ArrayList<>();
    private ArrayList<ArrayList<HoraAula>> aulas = new ArrayList<>();

    public AulasExistentes() {
        preparaNomes();
        for(int i = 0; i < nomeUCs.size(); i++) {
            aulas.add(new ArrayList<HoraAula>());
        }
    }
    
    public void preparaNomes() {
         //1ºano 1ºsemestre
        nomeUCs.add("Tecnologias Web");
        nomeUCs.add("Introdução à Programação");
        nomeUCs.add("Sistemas Digitais");
        nomeUCs.add("Álgebra Linear");
        nomeUCs.add("Gestão");
        nomeUCs.add("Análise Matemática I");
        
        //1ºano 2ºsemestre
        nomeUCs.add("Análise Matemática II");
        nomeUCs.add("Fundamentos de Computação Gráfica");
        nomeUCs.add("Programação");
        nomeUCs.add("Tecnologias e Arquitecturas de Computadores");
        nomeUCs.add("Métodos Estatísticos");
        nomeUCs.add("Eletrónica");
        nomeUCs.add("Análise Matemática I (deslizante)");
        
        //2ºano 1ºsemestre
        nomeUCs.add("Programação Orientada a Objectos");
        nomeUCs.add("Introdução às Redes de Comunicação");
        nomeUCs.add("Bases de Dados");
        nomeUCs.add("Investigação Operacional");
        nomeUCs.add("Sistemas Operativos");
        nomeUCs.add("Introdução à Inteligência Artificial");
        
        //2ºano 2ºsemestre
        nomeUCs.add("Serviço de Rede I");
        nomeUCs.add("Cablagem Estruturada");
        nomeUCs.add("Encaminhamento de Dados");
        nomeUCs.add("Segurança");
        nomeUCs.add("Empreendedorismo e Inovação");
        nomeUCs.add("Sistemas Operativos II");
        nomeUCs.add("Interação Pessoa-Máquina");
        nomeUCs.add("Programação Avançada");
        nomeUCs.add("Conhecimento e Raciocínio");
        nomeUCs.add("Arquitectura e Administração de Bases de Dados");
        nomeUCs.add("Integração de Dados");
        nomeUCs.add("Modelação e Design");
        nomeUCs.add("Sistemas de Informação I");
        
        //3ºano 1ºsemestre
        nomeUCs.add("Tecnologias de Ligação");
        nomeUCs.add("Serviços de Rede II");
        nomeUCs.add("Disponibilidade e Desempenho");
        nomeUCs.add("Gestão de Redes");
        nomeUCs.add("Programação Web");
        nomeUCs.add("Programação Distribuída");
        nomeUCs.add("Arquitecturas Móveis");
        nomeUCs.add("Estruturas de Dados");
        nomeUCs.add("Gestão de Projeto de Software");
        nomeUCs.add("Inteligência Computacional");
        nomeUCs.add("Sistemas de Informação II");
        nomeUCs.add("Metodologias de Otimização e Apoio à Decisão");
        nomeUCs.add("Estratégia Organizacional");
        
        //3ºano 2ºsemestre
        nomeUCs.add("Ética e Deontologia");
    }
    
    public ArrayList<ArrayList<HoraAula>> getAulas() {
        return aulas;
    }
    public String [] getHorasAulasT(String nomeUC) {
        ArrayList<String> horas = new ArrayList<>();
        String [] turmas;
        if(nomeUC == null || nomeUC.length() > 1)
            return null;
        int i = nomeUCs.indexOf(nomeUC);
        System.out.println("UC encontrada - i = " + i);
        if(i >= 0) {
            ArrayList<HoraAula> arr = aulas.get(i);
            for(HoraAula h: arr) {
                if(h.getTipo() == 0)
                    horas.add("T " + h.getTurma());
            }
        }
        else return null;
        if(horas.size() == 0)
            return null;
        turmas = new String[horas.size()];
        for(int j = 0; i < horas.size(); i++)
            turmas[j] = horas.get(j);
        
        return turmas;
        //return (String []) horas.toArray();
    }
    
    public String [] getHorasAulasP(String nomeUC) {
        ArrayList<String> horas = new ArrayList<>();
        String [] turmas;
        if(nomeUC == null || nomeUC.length() > 1)
            return null;
        int i = nomeUCs.indexOf(nomeUC);
        if(i >= 0) {
            ArrayList<HoraAula> arr = aulas.get(i);
            for(HoraAula h: arr) {
                if(h.getTipo() == 0)
                    horas.add("P " + h.getTurma());
            }
        }
        else return null;
        if(horas.size() == 0)
            return null;
        turmas = new String[horas.size()];
        for(int j = 0; i < horas.size(); i++)
            turmas[j] = horas.get(j);
        
        return turmas;
        //return (String []) horas.toArray();
    }
    
    public String [] getHorasAulasTP(String nomeUC) {
        ArrayList<String> horas = new ArrayList<>();
        String [] turmas;
        if(nomeUC == null || nomeUC.length() > 1)
            return null;
        int i = nomeUCs.indexOf(nomeUC);
        if(i >= 0) {
            ArrayList<HoraAula> arr = aulas.get(i);
            for(HoraAula h: arr) {
                if(h.getTipo() == 0)
                    horas.add("TP " + h.getTurma());
            }
        }
        else return null;
        if(horas.size() == 0)
            return null;
        turmas = new String[horas.size()];
        for(int j = 0; i < horas.size(); i++)
            turmas[j] = horas.get(j);
        
        return turmas;
        //return (String []) horas.toArray();
    }
    
    public HoraAula getHoraAula(String desc, String nomeUC) {
        int i = nomeUCs.indexOf(nomeUC);
        StringTokenizer token = new StringTokenizer(desc," ");
        String tipoS = token.nextToken();
        int turma = Integer.parseInt(token.nextToken());
        int tipo;
        
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
        
        if((i >= 0) && (tipo >= 0))
            for(HoraAula h: aulas.get(i)) {
                if(h.getTurma() == turma && h.getTipo() == tipo)
                    return h;
            }
        
        return null;
    }
    
    public void addHora(String nomeUC, String tipo, String sala, int turma, 
            String inicio, String fim) throws Exception{
        int i = nomeUCs.indexOf(nomeUC);
        if(i > -1) {
            int itipo;
            switch(tipo) {
                case "T":
                    itipo = 0;
                    break;
                case "P":
                    itipo = 1;
                    break;
                case "TP":
                    itipo = 2;
                    break;
                default:
                    itipo = -1;
                    break;
            }
            HoraAula h = new HoraAula(itipo, sala, turma);
            try {
                h.setInicio(inicio);
                h.setFim(fim);
                aulas.get(i).add(h);
                System.out.println("Adicionada hora " + h.toString());
            } catch(Exception ex) {
                System.err.println("Erro ao adicionar a aula pretendida.");
                throw ex;
            }
        }
    }
    
    public void guardaFicheiro() {
        final String FILENAME = "HORARIOS";
        File predefHorarios = new File(FILENAME);
        
        try {
            ObjectOutputStream oos;
            FileOutputStream fos;
            
            if(predefHorarios.exists()) {
                predefHorarios.delete();
                predefHorarios.createNewFile();
            }
            
            fos = new FileOutputStream(predefHorarios);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(this);
            
            oos.close();
            fos.close();
            
        } catch (Exception ex) {
            
        }
    }
}
