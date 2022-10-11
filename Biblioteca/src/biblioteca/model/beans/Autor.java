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
public class Autor {
    
    private String nome;
    private ArrayList<Livro> livros;

    public Autor() {
    }

    public Autor(String nome, ArrayList<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }
    
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
