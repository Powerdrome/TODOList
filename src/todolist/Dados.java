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

public class Dados extends Observable{
    private Calendario calendario;
    private ArrayList<String> nomeCadeiras;
    private final String NOME_FICHEIRO = "CUSTOMDATA";
    private int estado;
    
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
        criar_uc();
    }
    
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
        
        nomeCadeiras.add("Tecnologias Web");
        nomeCadeiras.add("Introdução à Programação");
        nomeCadeiras.add("Bases de Dados");
        nomeCadeiras.add("Investigação Operacional");
        nomeCadeiras.add("Programação Distribuída");
        nomeCadeiras.add("Arquitecturas Móveis");
    }
    
    public ArrayList<String> getNomeCadeiras() {
        return nomeCadeiras;
    }
    
    public int findAnoCadeira(String nome) {
        switch(nome) {
            case "Tecnologias Web":
            case "Introdução à Programação":
                return 1;
            case "Bases de Dados":
            case "Investigação Operacional":
                return 2;
            case "Programação Distribuída":
            case "Arquitecturas Móveis":
                return 3;
        }
        return -1;
    }
    
    public int findSemestreCadeira(String nome) {
        switch(nome) {
            case "Tecnologias Web":
            case "Introdução à Programação":
            case "Bases de Dados":
            case "Investigação Operacional":
            case "Programação Distribuída":
            case "Arquitecturas Móveis":
                return 1;
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
    
    public void setEstado(int x){
        estado = x;
        setChanged();
        notifyObservers();
    }
    
    public int getEstado(){
        return estado;
    }

    public void removeCadeira(String nome) {
        for(UnidadeCurricular uc: getCadeiras()) {
            if(uc.getNome().equals(nome)) {
                calendario.getCadeiras().remove(uc);
                return;
            }
        }
    }

    public void addCadeira(String nome) {
        calendario.getCadeiras().add(new UnidadeCurricular(nome,
                findAnoCadeira(nome),
                findSemestreCadeira(nome)));
    }
    
    public boolean inscritoCadeira(String nome) {
        if(calendario.getCadeiras().isEmpty())
            return false;
        for(UnidadeCurricular uc : calendario.getCadeiras()) {
            if(uc.getNome().equals(nome))
                return true;
        }
        return false;
    }
    
}
