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
public class Funcionario extends MovimentaçãoExemplar{

    private String nome;
    private int matricula;
    private String numeroOAB;

    public Funcionario() {
    }

    public Funcionario(String nome, int matricula, String numeroOAB, Date dataEmprestimo, Date dataDevolucao) {
        super(dataEmprestimo, dataDevolucao);
        this.nome = nome;
        this.matricula = matricula;
        this.numeroOAB = numeroOAB;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public void setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
    }
    
    
    
    
}
