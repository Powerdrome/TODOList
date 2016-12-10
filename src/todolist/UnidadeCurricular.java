/*
    class UnidadeCurricular
    Versão 1.1 30/11/16
    
*/
package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

public class UnidadeCurricular extends Observable implements Serializable {
    private static final long serialVersionUID = 2L;
    private String nome;
    private int ano;
    private int semestre;
    private ArrayList<Nota> notas;
    private ArrayList<HoraAula> aulas;
    private ArrayList<Exame> exames;
    private ArrayList<Dica> dicas;
    private ArrayList<Tarefa> tarefas;

    public UnidadeCurricular (String nome, int ano, int semestre){
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        notas = new ArrayList<>();
        aulas = new ArrayList<>();
        exames = new ArrayList<>();
        dicas = new ArrayList<>();
        tarefas = new ArrayList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public void addNota(Nota nota){
        notas.add(nota);
    }
    
    public void addAulas(HoraAula aula){
        aulas.add(aula);
    } 
    
    public void addExame(Exame exame){
        exames.add(exame);
    }
    
    public void addDica(Dica dica){
        dicas.add(dica);
    }
    
    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public ArrayList<HoraAula> getAulas() {
        return aulas;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public ArrayList<Dica> getDicas() {
        return dicas;
    }
    
    public ArrayList<Tarefa> getTarefas(){
        return tarefas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeCurricular other = (UnidadeCurricular) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
