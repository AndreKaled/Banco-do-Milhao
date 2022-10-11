/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import biblioteca.model.beans.AreaAdvocacia;
import biblioteca.model.beans.Autor;
import biblioteca.model.beans.Editora;
import biblioteca.model.beans.ExemplarLivro;
import biblioteca.model.beans.Funcionario;
import biblioteca.model.beans.Livro;
import biblioteca.model.beans.MovimentaçãoExemplar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class BancoDados {
    /*
    //
    //  Livros
    //
    */
    private static ArrayList<Livro> livros = new ArrayList<>();
    
    public static void addLivro(Livro livro){
        livros.add(livro);
    }
    
    public static void alterarLivro(Livro livroAntigo, Livro livroNovo){
        int indiceLivro = 0;
        for (Livro livro : livros) {
            if(livro == livroAntigo){
                livros.remove(livro);
                livros.add(indiceLivro, livroNovo);
            }
            indiceLivro++;
        }
    }
    
    public static void removeLivro(Livro livro){
        livros.add(livro);
    }
    
    public static List<Livro> selectLivros(){
        return livros;
    }
    
    /*
    //
    //  Funcionario
    //
    */
    
    private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    public static void add(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    
    public static void alterarLivro(Funcionario funcionarioAntigo, Funcionario funcionarioNovo){
        int indiceFuncionario = 0;
        for (Funcionario funcionario : funcionarios) {
            if(funcionario == funcionarioAntigo){
                funcionarios.remove(funcionario);
                funcionarios.add(indiceFuncionario, funcionarioNovo);
            }
            indiceFuncionario++;
        }
    }
    
    public static void removeFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    
    public static List<Funcionario> selectFuncionario(){
        return funcionarios;
    }
    
    /*
    //
    // Exemplar Livro
    //
    */
    
    private static ArrayList<ExemplarLivro> exemplares = new ArrayList<>();
    
    public static void addExemplares(ExemplarLivro exemplarLivro){
        exemplares.add(exemplarLivro);
    }
    
    public static void alterarExemplar(ExemplarLivro exemplarLivroAntigo, ExemplarLivro exemplarLivroNovo){
        int indiceExemplares = 0;
        for (ExemplarLivro exemplarLivro : exemplares) {
            if(exemplarLivro == exemplarLivroAntigo){
                exemplares.remove(exemplarLivro);
                exemplares.add(indiceExemplares, exemplarLivroNovo);
            }
            indiceExemplares++;
        }
    }
    
    public static void removeExemplar(ExemplarLivro exemplare){
        exemplares.add(exemplare);
    }
    
    public static List<ExemplarLivro> selectExemplares(){
        return exemplares;
    }
    
    /*
    //
    //  Editora
    //
    */
    
    private static ArrayList<Editora> editores = new ArrayList<>();
    
    public static void addEditores(Editora editora){
        editores.add(editora);
    }
    
    public static void alterarEditora(Editora editoraAntiga, Editora editoraNova){
        int indiceEditora = 0;
        for (Editora editora : editores) {
            if(editora == editoraAntiga){
                editores.remove(editora);
                editores.add(indiceEditora, editoraNova);
            }
            indiceEditora++;
        }
    }
    
    public static void removeEditora(Editora editora){
        editores.add(editora);
    }
    
    public static List<Editora> selectEditora(){
        return editores;
    }
    
    /*
    //
    // Autor
    //
    */
    
    private static ArrayList<Autor> autores = new ArrayList<>();
    
    public static void addAutores(Autor autor){
        autores.add(autor);
    }
    
    public static void alterarEditora(Autor autorAntigo, Autor autorNovo){
        int indiceAutor = 0;
        for (Autor autor : autores) {
            if(autor == autorAntigo){
                autores.remove(autor);
                autores.add(indiceAutor, autorNovo);
            }
            indiceAutor++;
        }
    }
    
    public static void removeAutor(Autor autor){
        autores.add(autor);
    }
    
    public static List<Autor> selectAutor(){
        return autores;
    }
    
    /*
    //
    //  Area advocacia
    //
    */
    
    private static ArrayList<AreaAdvocacia> arAdvocacias = new ArrayList<>();
    
    public static void addAreaAdvocacia(AreaAdvocacia arAdvocacia){
        arAdvocacias.add(arAdvocacia);
    }
    
    public static void alterarAdvocacia(AreaAdvocacia arAdvocaciaAntigo, AreaAdvocacia arAdvocaciaNovo){
        int indiceAreaAdvocacia = 0;
        for (AreaAdvocacia arAdvocacia : arAdvocacias) {
            if(arAdvocacia == arAdvocaciaAntigo){
                arAdvocacias.remove(arAdvocacia);
                arAdvocacias.add(indiceAreaAdvocacia, arAdvocaciaNovo);
            }
            indiceAreaAdvocacia++;
        }
    }
    
    public static void removeAreaAdvocacia(AreaAdvocacia areaAdvocacia){
        arAdvocacias.add(areaAdvocacia);
    }
    
    public static List<AreaAdvocacia> selectAreasAdvocacias(){
        return arAdvocacias;
    }
    
    /*
    //
    //  Movimentação Rxemplar
    //
    */
    
    private static ArrayList<MovimentaçãoExemplar> movimentos = new ArrayList<>();
    
    public static void addAreaAdvocacia(AreaAdvocacia arAdvocacia){
        arAdvocacias.add(arAdvocacia);
    }
    
    public static void alterarAdvocacia(AreaAdvocacia arAdvocaciaAntigo, AreaAdvocacia arAdvocaciaNovo){
        int indiceAreaAdvocacia = 0;
        for (AreaAdvocacia arAdvocacia : arAdvocacias) {
            if(arAdvocacia == arAdvocaciaAntigo){
                arAdvocacias.remove(arAdvocacia);
                arAdvocacias.add(indiceAreaAdvocacia, arAdvocaciaNovo);
            }
            indiceAreaAdvocacia++;
        }
    }
    
    public static void removeAreaAdvocacia(AreaAdvocacia areaAdvocacia){
        arAdvocacias.add(areaAdvocacia);
    }
    
    public static List<AreaAdvocacia> selectAreasAdvocacias(){
        return arAdvocacias;
    }
}
