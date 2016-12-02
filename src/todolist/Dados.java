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
    private UnidadeCurricular ucs;
    private final String NOME_FICHEIRO = "CUSTOMDATA";
    int estado = 1;
    public Dados() {
        
        File f = new File(NOME_FICHEIRO);
        calendario = null;
        
        //se ficheiro existe, ler calendário previamente guardado
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                calendario = (Calendario)ois.readObject();
                
                ois.close();
                fis.close();
            } catch (Exception ex) {
            }
        }
  
        if(calendario == null) {
            calendario = new Calendario(); // faz o que tem a fazer para criar novo calendário
        }
        criar_uc();
    }
    
    private void criar_uc() {
        calendario = new Calendario();
        
        UnidadeCurricular pa_uc = new UnidadeCurricular("PA", 2, 1);
        UnidadeCurricular ed_uc = new UnidadeCurricular("ED", 2, 1);
        
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
        pa_uc.addHoraEstudo(pa_horaestudo);
        
        calendario.addCadeira(pa_uc);
        calendario.addCadeira(ed_uc);
    }
    
    public Dados(Calendario calendario) {
        this.calendario = calendario;
    }
    
    public void guardaCalendario() {
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
    
    public ArrayList<Hora> getHoras() {
        return calendario.getHoras();
    }
    public ArrayList<UnidadeCurricular> getCadeiras() {
        return calendario.getCadeiras();
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
