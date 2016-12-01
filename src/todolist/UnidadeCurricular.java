/*
    class UnidadeCurricular
    Versão 1.1 30/11/16
    
*/
package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class UnidadeCurricular extends Observable implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int ano;
    private int semestre;
    private ArrayList<Nota> notas;
    private ArrayList<HoraAula> aulas;
    private ArrayList<HoraEstudo> horasEstudo;
    private ArrayList<Exame> exames;
    private ArrayList<Dica> dicas;

    public UnidadeCurricular (String nome, int ano, int semestre){
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        notas = new ArrayList<>();
        aulas = new ArrayList<>();
        horasEstudo = new ArrayList<>();
        exames = new ArrayList<>();
        dicas = new ArrayList<>();
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
    
    public void addHoraEstudo(HoraEstudo horaEstudo){
        horasEstudo.add(horaEstudo);
    } 
    
    public void addExame(Exame exame){
        exames.add(exame);
    }
    
    public void addDica(Dica dica){
        dicas.add(dica);
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

    public ArrayList<HoraEstudo> getHorasEstudo() {
        return horasEstudo;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public ArrayList<Dica> getDicas() {
        return dicas;
    }
}
