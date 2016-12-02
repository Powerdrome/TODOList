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
}
