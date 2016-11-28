package todolist;

import java.util.ArrayList;

public class UnidadeCurricular {
    String nome;
    int ano;
    int semestre;
    ArrayList<Nota> notas;
    ArrayList<HoraAula> aulas;
    ArrayList<HoraEstudo> horasEstudo;
    ArrayList<Exame> exames;
    ArrayList<Dica> dicas;

    public UnidadeCurricular(String nome, int ano, int semestre) {
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
