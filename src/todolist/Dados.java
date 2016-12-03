/*
    class Dados
    Versão 1.0 - 1/12/2016
 */
package todolist;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;

public class Dados extends Observable{
    private Calendario calendario;
<<<<<<< HEAD
    private UnidadeCurricular ucs;
    private final String NOME_FICHEIRO = "CUSTOMDATA";
    int estado = 2;
=======
    private ArrayList<String> nomeCadeiras;
    private final String NOME_FICHEIRO = "SAVEDATA";
    private int estado;
    
>>>>>>> master
    public Dados() {
        File f = new File(NOME_FICHEIRO);
        calendario = null;
        preparaNomes();
        
        //se ficheiro existe, ler calendário previamente guardado
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                calendario = (Calendario)ois.readObject();
                if(calendario != null)
                    estado = 1;
                
                ois.close();
                fis.close();
            } catch (Exception ex) {
            }
        }
  
        if(calendario == null) {
            calendario = new Calendario(); // faz o que tem a fazer para criar novo calendário
            estado = 0;
        }
        
        // criar_uc(); para testar
    }
    
    //para testar apenas
    private void criar_uc() {
        UnidadeCurricular pa_uc = new UnidadeCurricular("PA", 2, 1);
        UnidadeCurricular ed_uc = new UnidadeCurricular("ED", 2, 1);
        UnidadeCurricular md_uc = new UnidadeCurricular("MD", 2, 1);
        
        Nota pa_nota = new Nota("Programação Distribuida Nota", "Isto é uma nota para PA");
        
        Dica pa_dica = new Dica("Programação Distribuida Dica", "Isto é uma dica pra PA");
       
        Exame pa_exame = new Exame("Normal");
        pa_exame.setInicio(2017,01,14,14,30);
        pa_exame.setFim(2017,01,14,16,30);
        
        HoraAula pa_horaaula = new HoraAula(1, "L2.1");
        pa_horaaula.setInicio(2016,01,14,17,30);
        pa_horaaula.setFim(2016,01,14,18,00);
        
        HoraEstudo pa_horaestudo = new HoraEstudo("Hora d e Estudo de PA");
        pa_horaestudo.setInicio(2017,01,13,17,30);
        pa_horaestudo.setFim(2017,01,13,18,00);
        
        pa_uc.addAulas(pa_horaaula);
        pa_uc.addDica(pa_dica);
        pa_uc.addNota(pa_nota);
        pa_uc.addExame(pa_exame);
        calendario.addHoraEstudo(pa_horaestudo);
        
        
        Nota md_nota = new Nota("Programação Distribuida Nota", "Isto é uma nota para PA");
        
        Dica md_dica = new Dica("Programação Distribuida Dica", "Isto é uma dica pra PA");
       
        Exame md_exame = new Exame("Normal");
        pa_exame.setInicio(2017,01,14,14,30);
        pa_exame.setFim(2017,01,14,16,30);
        
        HoraAula md_horaaula = new HoraAula(1, "L2.1");
        pa_horaaula.setInicio(2016,01,14,17,30);
        pa_horaaula.setFim(2016,01,14,18,00);
        
        HoraEstudo md_horaestudo = new HoraEstudo("Hora d e Estudo de PA");
        pa_horaestudo.setInicio(2017,01,13,17,30);
        pa_horaestudo.setFim(2017,01,13,18,00);
        
        pa_uc.addAulas(pa_horaaula);
        pa_uc.addDica(pa_dica);
        pa_uc.addNota(pa_nota);
        pa_uc.addExame(pa_exame);
        calendario.addHoraEstudo(pa_horaestudo);
        
        calendario.addCadeira(pa_uc);
        calendario.addCadeira(ed_uc);
        calendario.addCadeira(md_uc);
    }
    
    public Dados(Calendario calendario, ArrayList<String> nomes) {
        this.calendario = calendario;
    }
    
    public void guardaCalendario() { //chamar quando a janela principal for fechada
        File f = new File(NOME_FICHEIRO);
        
        //elimina ficheiro prévio (se existir)
        if(f.exists()) {
            f.delete();
        }
        
        //cria novo ficheiro e escreve o Calendário nesse ficheiro
        try {
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(calendario);
            oos.flush();
            
            oos.close();
            fos.close();
        } catch (IOException ex) {
        }
    }
    
    public void preparaNomes() {
        nomeCadeiras = new ArrayList<>();
        
        //1ºano 1ºsemestre
        nomeCadeiras.add("Tecnologias Web");
        nomeCadeiras.add("Introdução à Programação");
        nomeCadeiras.add("Sistemas Digitais");
        nomeCadeiras.add("Álgebra Linear");
        nomeCadeiras.add("Gestão");
        nomeCadeiras.add("Análise Matemática I");
        
        //1ºano 2ºsemestre
        nomeCadeiras.add("Análise Matemática II");
        nomeCadeiras.add("Fundamentos de Computação Gráfica");
        nomeCadeiras.add("Programação");
        nomeCadeiras.add("Tecnologias e Arquitecturas de Computadores");
        nomeCadeiras.add("Métodos Estatísticos");
        nomeCadeiras.add("Eletrónica");
        nomeCadeiras.add("Análise Matemática I (deslizante)");
        
        //2ºano 1ºsemestre
        nomeCadeiras.add("Programação Orientada a Objectos");
        nomeCadeiras.add("Introdução às Redes de Comunicação");
        nomeCadeiras.add("Bases de Dados");
        nomeCadeiras.add("Investigação Operacional");
        nomeCadeiras.add("Sistemas Operativos");
        nomeCadeiras.add("Introdução à Inteligência Artificial");
        
        //2ºano 2ºsemestre
        nomeCadeiras.add("Serviço de Rede I");
        nomeCadeiras.add("Cablagem Estruturada");
        nomeCadeiras.add("Encaminhamento de Dados");
        nomeCadeiras.add("Segurança");
        nomeCadeiras.add("Empreendedorismo e Inovação");
        nomeCadeiras.add("Sistemas Operativos II");
        nomeCadeiras.add("Interação Pessoa-Máquina");
        nomeCadeiras.add("Programação Avançada");
        nomeCadeiras.add("Conhecimento e Raciocínio");
        nomeCadeiras.add("Arquitectura e Administração de Bases de Dados");
        nomeCadeiras.add("Integração de Dados");
        nomeCadeiras.add("Modelação e Design");
        nomeCadeiras.add("Sistemas de Informação I");
        
        //3ºano 1ºsemestre
        nomeCadeiras.add("Tecnologias de Ligação");
        nomeCadeiras.add("Serviços de Rede II");
        nomeCadeiras.add("Disponibilidade e Desempenho");
        nomeCadeiras.add("Gestão de Redes");
        nomeCadeiras.add("Programação Web");
        nomeCadeiras.add("Programação Distribuída");
        nomeCadeiras.add("Arquitecturas Móveis");
        nomeCadeiras.add("Estruturas de Dados");
        nomeCadeiras.add("Gestão de Projeto de Software");
        nomeCadeiras.add("Inteligência Computacional");
        nomeCadeiras.add("Sistemas de Informação II");
        nomeCadeiras.add("Metodologias de Otimização e Apoio à Decisão");
        nomeCadeiras.add("Estratégia Organizacional");
        
        //3ºano 2ºsemestre
        nomeCadeiras.add("Ética e Deontologia");
    }
    
    public ArrayList<String> getNomeCadeiras() {
        return nomeCadeiras;
    }
    
    public int findAnoCadeira(String nome) {
        switch(nome) {
            case "Tecnologias Web":
            case "Introdução à Programação":
            case "Sistemas Digitais":
            case "Álgebra Linear":
            case "Gestão":
            case "Análise Matemática I":
            case "Análise Matemática II":
            case "Fundamentos de Computação Gráfica":
            case "Programação":
            case "Tecnologias e Arquitecturas de Computadores":
            case "Métodos Estatísticos":
            case "Eletrónica":
            case "Análise Matemática I (deslizante)":
                return 1;
            case "Programação Orientada a Objectos":
            case "Introdução às Redes de Comunicação":
            case "Bases de Dados":
            case "Investigação Operacional":
            case "Sistemas Operativos":
            case "Introdução à Inteligência Artificial":
            case "Serviço de Rede I":
            case "Cablagem Estruturada":
            case "Encaminhamento de Dados":
            case "Segurança":
            case "Empreendedorismo e Inovação":
            case "Sistemas Operativos II":
            case "Interação Pessoa-Máquina":
            case "Programação Avançada":
            case "Modelação e Design":
            case "Conhecimento e Raciocínio":
            case "Arquitectura e Administração de Bases de Dados":
            case "Integração de Dados":
            case "Sistemas de Informação I":
                return 2;
            case "Tecnologias de Ligação":
            case "Serviços de Rede II":
            case "Disponibilidade e Desempenho":
            case "Gestão de Redes":
            case "Programação Web":
            case "Programação Distribuída":
            case "Arquitecturas Móveis":
            case "Estruturas de Dados":
            case "Gestão de Projeto de Software":
            case "Inteligência Computacional":
            case "Sistemas de Informação II":
            case "Metodologias de Otimização e Apoio à Decisão":
            case "Estratégia Organizacional":
            case "Ética e Deontologia":
                return 3;
            default:
                break;
        }
        
        return -1;
    }
    
    public int findSemestreCadeira(String nome) {
        switch(nome) {
        case "Tecnologias Web" :
        case "Introdução à Programação":
        case "Sistemas Digitais":
        case "Álgebra Linear":
        case "Gestão":
        case "Análise Matemática I":
        case "Programação Orientada a Objectos":
        case "Introdução às Redes de Comunicação":
        case "Bases de Dados":
        case "Investigação Operacional":
        case "Sistemas Operativos":
        case "Introdução à Inteligência Artificial":
        case "Tecnologias de Ligação":
        case "Serviços de Rede II":
        case "Disponibilidade e Desempenho":
        case "Gestão de Redes":
        case "Programação Web":
        case "Programação Distribuída":
        case "Arquitecturas Móveis":
        case "Estruturas de Dados":
        case "Gestão de Projeto de Software":
        case "Inteligência Computacional":
        case "Sistemas de Informação II":
        case "Metodologias de Otimização e Apoio à Decisão":
        case "Estratégia Organizacional":
                return 1;
        case "Análise Matemática II":
        case "Fundamentos de Computação Gráfica":
        case "Programação":
        case "Tecnologias e Arquitecturas de Computadores":
        case "Métodos Estatísticos":
        case "Eletrónica":
        case "Análise Matemática I (deslizante)":
        case "Serviço de Rede I":
        case "Cablagem Estruturada":
        case "Encaminhamento de Dados":
        case "Segurança":
        case "Empreendedorismo e Inovação":
        case "Sistemas Operativos II":
        case "Interação Pessoa-Máquina":
        case "Programação Avançada":
        case "Modelação e Design":
        case "Conhecimento e Raciocínio":
        case "Arquitectura e Administração de Bases de Dados":
        case "Integração de Dados":
        case "Sistemas de Informação I":
        case "Ética e Deontologia":
            return 2;
        default:
            break;
        }
        return -1;
    }
    
    public ArrayList<Hora> getHoras() {
        return calendario.getHoras();
    }
    
    public ArrayList<UnidadeCurricular> getCadeiras() {
        return calendario.getCadeiras();
    }
    
    public int getNCadeiras() {
        return getCadeiras().size();
    }
    
    public ArrayList<HoraEstudo> getHorasEstudo() {
        return calendario.getHorasEstudo();
    }
    
    public UnidadeCurricular getCadeira(String id) {
        ArrayList<UnidadeCurricular> ucs = getCadeiras();
        
        if (ucs.isEmpty()) {
            return null;
        }
        
        for(UnidadeCurricular uc: ucs) {
            if(uc.getNome().equals(id)) {
                return uc;
            }
        }
        return null;
    }

    public void addCadeira(String nome) {
        calendario.getCadeiras().add(new UnidadeCurricular(nome,
                findAnoCadeira(nome),
                findSemestreCadeira(nome)));
    }
    
    public void removeCadeira(String nome) { //nao foi testado
        for(UnidadeCurricular uc: getCadeiras()) {
            if(uc.getNome().equals(nome)) {
                calendario.getCadeiras().remove(uc);
                return;
            }
        }
    }
    
    public boolean inscritoCadeira(String nome) { //nao foi testado
        if(calendario.getCadeiras().isEmpty())
            return false;
        for(UnidadeCurricular uc : calendario.getCadeiras()) {
            if(uc.getNome().equals(nome))
                return true;
        }
        return false;
    }
    
    public void addNota(String nomeUC, String titulo, String nota) { //nao foi testado
        getCadeira(nomeUC).addNota(new Nota(titulo,nota));
    }
    
    public void addHoraEstudo(String titulo, String dataInicio, String dataFim) { // nao foi testado
        int ano;
        int mes;
        int dia;
        int hora;
        int minuto;
        StringTokenizer tokenizer;
        

        ArrayList<HoraEstudo> horas = calendario.getHorasEstudo();
        horas.add(new HoraEstudo(titulo));
        
        tokenizer = new StringTokenizer(dataInicio, "/: ", false);
        dia = Integer.parseInt(tokenizer.nextToken());
        mes = Integer.parseInt(tokenizer.nextToken());
        ano = Integer.parseInt(tokenizer.nextToken());
        hora = Integer.parseInt(tokenizer.nextToken());
        minuto = Integer.parseInt(tokenizer.nextToken());
        horas.get(horas.size()-1).setInicio(ano,mes,dia,hora,minuto);
        
        tokenizer = new StringTokenizer(dataFim, "/: ", false);
        dia = Integer.parseInt(tokenizer.nextToken());
        mes = Integer.parseInt(tokenizer.nextToken());
        ano = Integer.parseInt(tokenizer.nextToken());
        hora = Integer.parseInt(tokenizer.nextToken());
        minuto = Integer.parseInt(tokenizer.nextToken());
        horas.get(horas.size()-1).setFim(ano,mes,dia,hora,minuto);
        
    }
    
    public void removeHoraEstudo(String titulo) { // nao foi testado
        for (HoraEstudo he: calendario.getHorasEstudo()) {
            if (he.getTitulo().equals(titulo)) {
               calendario.getHoras().remove(he);
            }
        }
    }
    
    public void setEstado(int x){
        estado = x;
        setChanged();
        notifyObservers();
    }
    
    public int getEstado(){
        return estado;
    }
}