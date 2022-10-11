/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class EmprestarLivro extends JFrame {

    JPanel titulo, dadosFuncionario, dadosLivros;
    JLabel lblFuncionario, lblLivros;
    JButton btnVoltar;
    
    //Painel Titulo
    JLabel lblTituloT, lblEmprestarLivro;
    
    // Painel Dados do Funcionario
    JLabel lblMatricula, lblOab, lblNome;
    JTextField txtMatricula, txtOab, txtNome;
    JButton btnPesquisarFuncionario;
    
    // Painel Dados Livros
    JLabel nExemplar;
    JTextField txtNumExemplar;
    JTable tabelaLivros;
    DefaultTableModel modelaTabelaLivros;
    JButton btnPesquisarLivro;
    private String colunasLivros[] = {"Nº Exemplar", "Nome", "Editora", "Ação"};
    private String dados[][] = {};
    
    public EmprestarLivro() {
        
        lblFuncionario = new JLabel("Dados Funcionario");
        lblFuncionario.setFont(new Font("Arial", 1, 20));
        lblFuncionario.setBounds(0, 155, 300, 40);
        add(lblFuncionario);
        
        lblLivros = new JLabel("Dados Livros");
        lblLivros.setFont(new Font("Arial", 1, 20));
        lblLivros.setBounds(0, 370, 300, 40);
        add(lblLivros);
        
        configFrame();
        configPainelTitulo();
        configPainelDadosFuncionario();
        configPainelDadosLivros();
    }
    private void configPainelTitulo() {

        titulo = new JPanel(null);
        titulo.setBackground(new Color(189, 187, 187));
        titulo.setBounds(0, 50, 600, 100);
        add(titulo);

        lblTituloT = new JLabel("Sistema para controle de Biblioteca");
        lblTituloT.setFont(new Font("Arial", 1, 24));
        lblTituloT.setBounds(100, 30, 500, 40);
        
        titulo.add(lblTituloT);
    }

    private void configPainelDadosFuncionario() {
        dadosFuncionario = new JPanel(null);
        dadosFuncionario.setBackground(new Color(209, 226, 205));
        dadosFuncionario.setBounds(0, 185, 600, 175);
        add(dadosFuncionario);
        
        lblMatricula = new JLabel("Matricula");
        lblMatricula.setFont(new Font("Arial", 0, 18));
        lblMatricula.setBounds(5, 0, 200, 30);
        dadosFuncionario.add(lblMatricula);
        
        lblOab = new JLabel("Número OAB");
        lblOab.setFont(new Font("Arial", 0, 18));
        lblOab.setBounds(5, 75, 200, 30);
        dadosFuncionario.add(lblOab);
        
        lblOab = new JLabel("Nome");
        lblOab.setFont(new Font("Arial", 0, 18));
        lblOab.setBounds(300, 0, 200, 30);
        dadosFuncionario.add(lblOab);
        
        txtMatricula = new JTextField();
        txtMatricula.setFont(new Font("Arial", 0, 16));
        txtMatricula.setBounds(5, 30, 200, 30);
        dadosFuncionario.add(txtMatricula);
        
        txtOab = new JTextField();
        txtOab.setFont(new Font("Arial", 0, 16));
        txtOab.setBounds(5, 110, 200, 30);
        dadosFuncionario.add(txtOab);
        
        txtNome = new JTextField();
        txtNome.setFont(new Font("Arial", 0, 16));
        txtNome.setBounds(300, 30, 275, 30);
        dadosFuncionario.add(txtNome);
        
        btnPesquisarFuncionario = new JButton("PESQUISAR");
        btnPesquisarFuncionario.setBackground(dadosFuncionario.getBackground().brighter());
        btnPesquisarFuncionario.setFont(new Font("Arial", 0, 18));
        btnPesquisarFuncionario.setBounds(300, 100, 200, 30);
        dadosFuncionario.add(btnPesquisarFuncionario);
    }
    
    private void configPainelDadosLivros(){
        dadosLivros = new JPanel(null);
        dadosLivros.setBackground(new Color(209, 226, 205));
        dadosLivros.setBounds(0, 400, 600, 400);
        add(dadosLivros);
        
        nExemplar = new JLabel("Nº Exemplar");
        nExemplar.setFont(new Font("Arial", 0, 16));
        nExemplar.setBounds(10, 10, 200, 30);
        dadosLivros.add(nExemplar);
        
        txtNumExemplar = new JTextField();
        txtNumExemplar.setFont(new Font("Arial", 0, 16));
        txtNumExemplar.setBounds(10, 40, 200, 30);
        dadosLivros.add(txtNumExemplar);
        
        btnPesquisarLivro = new JButton("PESQUISAR");
        btnPesquisarLivro.setBackground(dadosLivros.getBackground().brighter());
        btnPesquisarLivro.setFont(new Font("Arial", 0, 18));
        btnPesquisarLivro.setBounds(300, 40, 200, 30);
        dadosLivros.add(btnPesquisarLivro);
        
        modelaTabelaLivros = new DefaultTableModel(dados, colunasLivros);
        
        tabelaLivros = new JTable(modelaTabelaLivros);
        JScrollPane painelScrollado = new JScrollPane(tabelaLivros);
                
        painelScrollado.setBounds(5, 100, 575, 300);
        dadosLivros.add(painelScrollado);
    }

    private void configFrame() {
        setSize(600, 800);
        setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Emprestar Livro");
        
        btnVoltar = new JButton("<--");
        btnVoltar.setFont(new Font("Arial", 0, 18));
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaPrincipal().setVisible(true);
            }
        });
        btnVoltar.setBounds(0, 0, 100, 17);
        btnVoltar.setBackground(Color.WHITE);
        btnVoltar.setBorder(null);
        add(btnVoltar);
    }

    public static void main(String[] args) {
        new EmprestarLivro().setVisible(true);
    }
}