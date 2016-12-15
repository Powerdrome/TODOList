package todolist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *   class Dados
 *   Versão 1.2 - 6/12/2016
 *
 *      Esta classe tem como objetivo servir de controlador na aplicação (de
 * acordo com o padrão MVC), e como tal possibilita a alteração dos dados
 * dependendo do input do utilizador, para além de providenciar métodos de 
 * obtenção destes mesmos dados para serem usados pela interface.
 *
*/


/*

======== TABELA DE ESTADOS ============
    0 - Define Cadeiras (e depois para as turmas)
    1 - Calendario
    2 - Tarefas 
´   3 - InsereTarefas
    4 - Notas
    5 - InsereNotas
    6 - Truques e Dicas

*/

public class Dados extends Observable{
    private Calendario calendario = null;
    private AulasExistentes aulasExistentes = null;
    private ArrayList<String> nomeCadeiras = null;
    private final String NOME_FICHEIRO_USER = "SAVEDATA";
    private final String NOME_FICHEIRO_HORARIOS = "HORARIOS";
    private int estado = -1;
    private UnidadeCurricular uc;
    
    public Dados() {
        File saveFile = new File(NOME_FICHEIRO_USER);
        File horarios = new File(NOME_FICHEIRO_HORARIOS);
        preparaNomes();
        
        //se ficheiro existe, ler calendário previamente guardado
        if (horarios.exists()) {
            try {
                FileInputStream fis = new FileInputStream(horarios);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                aulasExistentes = (AulasExistentes) ois.readObject();
                if(aulasExistentes != null) {
                    System.out.println("O ficheiro de turmas foi carregado com sucesso.");
                }
                
                ois.close();
                fis.close();
            } catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }
        if (saveFile.exists()) {
            try {
                FileInputStream fis = new FileInputStream(saveFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                calendario = (Calendario) ois.readObject();
                if (calendario != null) {
                    estado = 1;
                }
                
                ois.close();
                fis.close();
            } catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }
        //criarUC();
        if (calendario == null) {
            calendario = new Calendario();
            estado = 0;
        }
    }
    
    public Dados(Calendario calendario, ArrayList<String> nomes) throws IllegalArgumentException {
        if ((calendario != null) && (nomes != null) && (nomes.size() > 0)) {
            this.calendario = calendario;
            this.nomeCadeiras = nomes;
        }
        else {
            throw new IllegalArgumentException(
                    "Um ou mais argumentos não são válidos");
        }
    }
    
    //para testar apenas
    private void criarUC() {
        UnidadeCurricular paUC = new UnidadeCurricular("T1", 2, 1); //teste1
        //UnidadeCurricular edUC = new UnidadeCurricular("ED", 2, 1);
        //UnidadeCurricular mdUC = new UnidadeCurricular("MD", 2, 1);
        HoraEstudo mdEstudo = null;
        HoraAula mdAula = null;
        Exame mdExame = null;
        Dica mdDica = null;
        Nota mdNota = null;
        HoraEstudo paEstudo = null;
        HoraAula paAula = null;
        Tarefa a = new Tarefa("Programar ClassXPTO");
        a.setInicio(2016, 10, 10, 10, 00);
        a.setFim(2016, 10, 10, 12, 00);
        Tarefa b = new Tarefa("Fazer exericio 2 Ficha 3");
        b.setInicio(2016, 10, 10, 10, 00);
        b.setFim(2016, 10, 10, 12, 00);
        Nota paNota = new Nota("Programação Distribuida Nota",
                "Isto é uma nota para PA");
        Dica paDica = new Dica("Programação Distribuida Dica",
                "Isto é uma dica pra PA");
        Exame paExame = new Exame("Normal");
        
        paExame.setInicio(2017, 01, 14, 14, 30);
        paExame.setFim(2017, 01, 14, 16, 30);
        
        paAula = new HoraAula(1, "L2.1", 1, "Programação Avançada");
        try {
            paAula.setInicio("14/01/2016 17:30");
            paAula.setFim("14/01/2016 18:00");
        } catch (ParseException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        paEstudo = new HoraEstudo("Hora d e Estudo de PA");
        paEstudo.setInicio(2017, 01, 13, 17, 30);
        paEstudo.setFim(2017, 01, 13, 18, 00);
        
        paUC.addAulas(paAula);
        paUC.addDica(paDica);
        paUC.addNota(paNota);
        paUC.addExame(paExame);
        paUC.addTarefa(a);
        paUC.addTarefa(b);
        //calendario.addHoraEstudo(paEstudo);
        
        mdNota = new Nota("Programação Distribuida Nota",
                "Isto é uma nota para PA");
        mdDica = new Dica("Programação Distribuida Dica", 
                "Isto é uma dica pra PA");
       
        mdExame = new Exame("Normal");
        mdExame.setInicio(2017, 01, 14, 14, 30);
        mdExame.setFim(2017, 01, 14, 16, 30);
        
        mdAula = new HoraAula(1, "L2.1", 1, "Modelação e Design");
        try {
            mdAula.setInicio("14/01/2016 17:30");
            mdAula.setFim("14/01/2016 18:00");
        } catch (ParseException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mdEstudo = new HoraEstudo("Hora d e Estudo de PA");
        mdEstudo.setInicio(2016, 12, 15, 17, 30);
        mdEstudo.setFim(2016, 12, 15, 18, 30);
        
        //mdUC.addAulas(mdAula);
        //mdUC.addDica(mdDica);
        //mdUC.addNota(mdNota);
        //mdUC.addExame(mdExame);
        //calendario.addHoraEstudo(mdEstudo);
        
        calendario.addCadeira(paUC);
        //calendario.addCadeira(edUC);
        //calendario.addCadeira(mdUC);
    }
    
    //chamar quando janela principal for fechada
    public void guardaCalendario() {
        File saveFile = new File(NOME_FICHEIRO_USER);
        
        //elimina ficheiro prévio (se existir)
        if (saveFile.exists()) {
            saveFile.delete();
        }
        
        //cria novo ficheiro e escreve o Calendário nesse ficheiro
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            
            saveFile.createNewFile();
            fos = new FileOutputStream(saveFile);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(calendario);
            oos.flush();
            
            oos.close();
            fos.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
    
    private void preparaNomes() {
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
        if ((nome == null) || (nome.length() == 0)) {
            return -1;
        }
        
        switch(nome) {
            
        //falls through até ao próximo return
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
            
        //falls through até ao próximo return
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
            
        //falls through até ao próximo return
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
        if ((nome == null) || (nome.length() == 0)) {
            return -1;
        }
        
        switch(nome) {
                
        //falls through até ao próximo return
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
                
        //falls through até ao próximo return
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
    
    public ArrayList<HoraAula> getAulasExistentes() {
        return aulasExistentes.getAulas();
    }
    
    public String [] getHorasAulasT(String nomeUC) {
        return aulasExistentes.getHorasAulasT(nomeUC);
    }
    
    public String [] getHorasAulasP(String nomeUC) {
        return aulasExistentes.getHorasAulasP(nomeUC);
    }
    
    public String [] getHorasAulasTP(String nomeUC) {
        return aulasExistentes.getHorasAulasTP(nomeUC);
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
        ArrayList<UnidadeCurricular> ucs = getCadeiras();;
        
        if ((ucs.isEmpty()) || (id == null) || (id.length() == 0)) {
            return null;
        }
        
        for (UnidadeCurricular uc: ucs) {
            if (uc.getNome().equals(id)) {
                return uc;
            }
        }
        return null;
    }

    public void addCadeira(String nome) {
        if ((nome == null) || (nome.length() == 0)) {
            return;
        }
        
        calendario.getCadeiras().add(new UnidadeCurricular(nome,
                findAnoCadeira(nome),
                findSemestreCadeira(nome)));
        
        if (estado != 0) {
            setChanged();
            notifyObservers();
        }
    }
    
    public void removeCadeira(String nome) {
        if ((nome == null) || (nome.length() == 0)) {
            return;
        }
        
        for (UnidadeCurricular uc: getCadeiras()) {
            if (uc.getNome().equals(nome)) {
                calendario.getCadeiras().remove(uc);
                return;
            }
        }
        if (estado != 0) {
            setChanged();
            notifyObservers();
        }
    }
    
    public boolean inscritoCadeira(String nome) {
        if (calendario.getCadeiras().isEmpty() || (nome == null)
                || (nome.length() == 0)) {
            return false;
        }
        for (UnidadeCurricular uc : calendario.getCadeiras()) {
            if (uc.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public void addNota(String nomeUC, String titulo, String nota) {
        UnidadeCurricular cadeira = null;
        if ((nomeUC == null) || (titulo == null) || (nota == null)) {
            return;
        } else if ((nomeUC.length() == 0) || (titulo.length() == 0)) {
            return;
        }
        cadeira = getCadeira(nomeUC);
        if (cadeira != null) {
            cadeira.addNota(new Nota(titulo, nota));
            setChanged();
            notifyObservers();
        }
    }
    
        public void addHoraAula(int aulaIndex, HoraAula h) {
        if(aulaIndex > getNCadeiras())
            return;
        getCadeiras().get(aulaIndex).addAulas(h);
    } 
    
    public HoraAula getHoraAula(String desc, String nomeUC) {
        if(desc == null || desc.length() == 0)
            return null;
        if(nomeUC == null || nomeUC.length() == 0)
            return null;
        
        return aulasExistentes.getHoraAula(desc, nomeUC);
    }
    
    public void addHoraEstudo(String titulo, GregorianCalendar dataInicio,
            GregorianCalendar dataFim){
        ArrayList<HoraEstudo> horas = calendario.getHorasEstudo();
        
        if ((titulo == null) || (titulo.length() == 0) || (dataInicio == null)
                || (dataFim == null)) {
            return;
        }
        
        horas.add(new HoraEstudo(titulo));
        horas.get(horas.size() - 1).setInicio(dataInicio);
        horas.get(horas.size() - 1).setFim(dataFim);
        
        setChanged();
        notifyObservers();
    }
    
    public void removeHoraEstudo(String titulo) {
        if ((titulo == null) || (titulo.length() == 0)) {
            return;
        }
        
        for (HoraEstudo he: calendario.getHorasEstudo()) {
            if (he.getTitulo().equals(titulo)) {
               calendario.getHoras().remove(he);
            }
        }
        setChanged();
        notifyObservers();
    }
    
//    public ArrayList<String> getTurmas(String nomeUC, String tipo) {
//        ArrayList<String> turmas =  new ArrayList<>();
//        File timesFile = new File("Calendario.txt");
//        BufferedReader bufReader = null;
//        String line = "";
//        String [] turma = null;
//        
//        try {
//            bufReader = new BufferedReader(new FileReader(timesFile));
//        } catch(IOException ex) {
//            System.err.println(ex.toString());
//        }
//        
//        if (bufReader == null) {
//            return null;
//        }       
//        while (true) {
//            try {
//                line = bufReader.readLine();
//                if (line.equals(nomeUC)) {
//                    line = bufReader.readLine();
//                    turma = line.split(" ");
//                    for (int i = 0; i < turma.length; i++) {
//                        turmas.add(turma[i]);
//                    }
//                }
//                else {
//                    line = bufReader.readLine();
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        return turmas;
//    }
    
    public void setEstado(int x){
        if ((x < 0) || (x > 6)) {
            return;
        }
        estado = x;
    }
    
    public int getEstado(){
        return estado;
    }

    public void setDisciplina(UnidadeCurricular uc) {
        this.uc=uc;
        setChanged();
        notifyObservers();
    }

    public UnidadeCurricular getUc() {
        return uc;
    }
    
    public void addTarefa(Tarefa tarefa){
        try{
            uc.addTarefa(tarefa);
        }catch(Exception e){
            System.out.println("Dados_AddTarefa: " + e);
        }
        setChanged();
        notifyObservers();   
    }
    
    public ArrayList<Tarefa> getTarefas(){
        try{
            return uc.getTarefas();
        }catch(Exception e){
            System.out.println("Dados_GetTarefas: " + e);
        }
        
        return null;
    }
    
     public void addNota(Nota nota){
        try{
            uc.addNota(nota);
        }catch(Exception e){
            System.out.println("Dados_AddNotas: " + e);
        }
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<Nota> getNotas(){
        try{
            return uc.getNotas();
        }catch(Exception e){
            System.out.println("Dados_GetNotas: " + e);
        }
        return null;
    }
    
    public Nota getNotaById(int id){
        return uc.getNotas().get(id);
    }
    
    public void setNotas(Nota nova, int id){
        try{
            //Implementação da edição
            Nota antiga = getNotaById(id);
            antiga = nova;
            //confirmar, mas acho que chega
        }catch(Exception e){
            System.out.println("Dados_SetNotas: " + e);
        }
    }
    
    public ArrayList<Dica> getDicas(){
        try{
            return uc.getDicas();
        }catch(Exception e){
            System.out.println("Dados_GetDicas: " + e);
        }
        return null;
    }
    
    public void actualiza(){
        setChanged();
        notifyObservers();
    }
    
    //added by Paulo
    public void eliminaNota(Nota eleNota){
        try{
            uc.eliminaNota(eleNota);
        }catch(Exception e){
            System.out.println("Dados_EliminaNota: " + e);
        }
        setChanged();
        notifyObservers();
    }
}