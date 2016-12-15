/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.Serializable;

/**
 *
 * @author Rui
 */
public class DicaBase implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nomeUC;
    private String titulo;
    private String dica;

    public DicaBase(String nomeUC, String titulo, String dica) {
        this.nomeUC = nomeUC;
        this.titulo = titulo;
        this.dica = dica;
    }

    public String getNomeUC() {
        return nomeUC;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDica() {
        return dica;
    }
}
