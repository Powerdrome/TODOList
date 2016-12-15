/*
    class UnidadeCurricular
    Versão 1.1 30/11/16
    
*/
package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
        try{
        dicas.add(dica);
        } catch(Exception e) {
            System.out.println("UC_AddDica: "+e);
        }
    }
    
    public void addTarefa(Tarefa tarefa){
        try{
            tarefas.add(tarefa);
        }catch(Exception e){
            System.out.println("UC_AddTarefa: "+ e);
        }
        
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
        ArrayList<Tarefa> tar = new ArrayList<>();
        for(Tarefa t: tarefas)
            if(!t.getConcluido())
                tar.add(t);
        Collections.sort(tar, new UnidadeCurricular.ComparadorTarefas());
        return tar;
    }
    
    public void eliminaNota(Nota nota){
        int i = 0;
        boolean existe = false;
        for(Nota n: notas){
            i++;
            if(n.equals(nota)){
                existe = true;
                notas.remove(n);
                break;
            }
        }
        if(existe) notas.remove(i);
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
    
    private class ComparadorTarefas implements Comparator<Tarefa>{

    @Override
    public int compare(Tarefa o1, Tarefa o2) {
        if (o1.getInicio().get(Calendar.YEAR) 
                != o2.getInicio().get(Calendar.YEAR)) {
            return o1.getInicio().get(Calendar.YEAR) 
                    - o2.getInicio().get(Calendar.YEAR);
        } else if (o1.getInicio().get(Calendar.MONTH) 
                != o2.getInicio().get(Calendar.MONTH)) {
            return o1.getInicio().get(Calendar.DATE) 
                    - o2.getInicio().get(Calendar.DATE);
        } else if (o1.getInicio().get(Calendar.DATE)
                != o2.getInicio().get(Calendar.DATE)) {
            return o1.getInicio().get(Calendar.DATE) 
                    - o2.getInicio().get(Calendar.DATE);
        } else if (o1.getInicio().get(Calendar.HOUR_OF_DAY) 
                != o2.getInicio().get(Calendar.HOUR_OF_DAY)) {
            return o1.getInicio().get(Calendar.HOUR_OF_DAY) 
                    - o2.getInicio().get(Calendar.HOUR_OF_DAY);  
        }
        return o1.getInicio().get(Calendar.MINUTE) 
                - o2.getInicio().get(Calendar.MINUTE);
    }
    
    }
}
