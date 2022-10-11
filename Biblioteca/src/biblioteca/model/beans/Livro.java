/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.model.beans;

import java.util.ArrayList;

/**
 *
 * @author thiag
 */
public class Livro {
    
    private AreaAdvocacia areaAdvocacia;
    private ArrayList<Autor> autores;
    private Editora editora;
    private String nome;
    
    public Livro() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AreaAdvocacia getAreaAdvocacia() {
        return areaAdvocacia;
    }

    public void setAreaAdvocacia(AreaAdvocacia areaAdvocacia) {
        this.areaAdvocacia = areaAdvocacia;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    
    
    
}
