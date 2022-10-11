/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.model.beans;

import java.util.Date;

/**
 *
 * @author thiag
 */
public class ExemplarLivro {
    
    private Livro livro;
    private Date dataAquisicao;
    private float precoAquisicao;
    private boolean ativo = true;

    public ExemplarLivro() {
    }

    public ExemplarLivro(Livro livro, Date dataAquisicao, float precoAquisicao) {
        this.livro = livro;
        this.dataAquisicao = dataAquisicao;
        this.precoAquisicao = precoAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public float getPrecoAquisicao() {
        return precoAquisicao;
    }

    public void setPrecoAquisicao(float precoAquisicao) {
        this.precoAquisicao = precoAquisicao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
