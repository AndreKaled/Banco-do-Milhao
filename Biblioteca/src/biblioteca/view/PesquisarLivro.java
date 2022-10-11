/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thiag
 */
public class PesquisarLivro extends JFrame{
    
    
    JPanel painelTitulo, painelBusca, painelExternoTabela;
    JScrollPane painelTabela;
    
    JLabel lblTitulo, lblTipoPesquisa, lblInforma, lblResultadoBusca;
    JButton btnPesquisar, btnNovaPesquisa, btnSair, btnVoltar;
    JTextField txtPalavraChave;
    JRadioButton radioAutor, radioLivro, radioEditora;
    
    JTable tabelaLivroPesquisa;
    String colunasTabela[] = {"Nº Ex", "Nome", "Autor", "Editora", "Previsão devolução"};
    Object dados[][] = {};
    
    public PesquisarLivro(){
        configFrame();
        configPainelTitulo();
        configPainelBusca();
        configPainelExternoTabela();
    }

    
    private void configFrame(){
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Pesquisar Livro");
        
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
    
    private void configPainelTitulo(){
        painelTitulo = new JPanel(null);
        painelTitulo.setBackground(new Color(189, 187, 187));
        painelTitulo.setBounds(10, 20, 770, 100);
        add(painelTitulo);
        
        lblTitulo = new JLabel("Sistema para Controle da Biblioteca");
        lblTitulo.setFont(new Font("Arial", 1, 32));
        lblTitulo.setBounds(130, 30, 600, 40);
        painelTitulo.add(lblTitulo);
    }
    
    private void configPainelBusca(){
        painelBusca = new JPanel(null);
        painelBusca.setBackground(new Color(209, 226, 205));
        painelBusca.setBounds(10, 135, 770, 200);
        add(painelBusca);
        
        lblTipoPesquisa = new JLabel("Selecione o tipo de pesquisa");
        lblTipoPesquisa.setFont(new Font("Arial", 1, 16));
        lblTipoPesquisa.setBounds(10, 10, 300, 30);
        painelBusca.add(lblTipoPesquisa);
                
        radioAutor = new JRadioButton("Autor");
        radioAutor.setBounds(10, 40, 70, 30);
        radioAutor.setBackground(painelBusca.getBackground());
        radioAutor.setFont(new Font("Arial", 0, 14));
        painelBusca.add(radioAutor);
        
        radioLivro = new JRadioButton("Livro");
        radioLivro.setBounds(80, 40, 70, 30);
        radioLivro.setBackground(painelBusca.getBackground());
        radioLivro.setFont(new Font("Arial", 0, 14));
        painelBusca.add(radioLivro);
        
        radioEditora = new JRadioButton("Editora");
        radioEditora.setBounds(150, 40, 120, 30);
        radioEditora.setBackground(painelBusca.getBackground());
        radioEditora.setFont(new Font("Arial", 0, 14));
        painelBusca.add(radioEditora);
        
        lblInforma = new JLabel("Digite a palavra chave para pesquisa e clique no botão pesquisar");
        lblInforma.setFont(new Font("Arial", 1, 12));
        lblInforma.setBounds(10, 80, 380, 30);
        painelBusca.add(lblInforma);
        
        txtPalavraChave = new JTextField();
        txtPalavraChave.setBackground(Color.white);
        txtPalavraChave.setBounds(10, 110, 400, 25);
        txtPalavraChave.setFont(new Font("Arial", 0, 12));
        painelBusca.add(txtPalavraChave);
        
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBackground(painelBusca.getBackground().brighter());
        btnPesquisar.setFont(new Font("Arial", 0, 16));
        btnPesquisar.setBounds(10, 155, 150, 25);
        painelBusca.add(btnPesquisar);
        
        btnNovaPesquisa = new JButton("Nova Pesquisa");
        btnNovaPesquisa.setBackground(painelBusca.getBackground().brighter());
        btnNovaPesquisa.setFont(new Font("Arial", 0, 16));
        btnNovaPesquisa.setBounds(190, 155, 150, 25);
        painelBusca.add(btnNovaPesquisa);
    }
    
    private void configPainelExternoTabela(){
        painelExternoTabela = new JPanel(null);
        painelExternoTabela.setBackground(new Color(209, 226, 205));
        painelExternoTabela.setBounds(10, 350, 770, 200);
        add(painelExternoTabela);
        
        lblResultadoBusca = new JLabel("Resultado da busca");
        lblResultadoBusca.setFont(new Font("Arial", 1, 16));
        lblResultadoBusca.setBounds(10, 10, 300, 30);
        painelExternoTabela.add(lblResultadoBusca);
        
        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunasTabela);
        
        tabelaLivroPesquisa = new JTable(modeloTabela);
        tabelaLivroPesquisa.setFont(new Font("Arial", 0, 12));
        tabelaLivroPesquisa.getTableHeader().setFont(new Font("Arial", 1, 14));
        tabelaLivroPesquisa.getTableHeader().setReorderingAllowed(false);
        tabelaLivroPesquisa.getTableHeader().setResizingAllowed(true);
        tabelaLivroPesquisa.getTableHeader().setBackground(painelExternoTabela.getBackground().brighter());
        tabelaLivroPesquisa.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(70);
        
        painelTabela = new JScrollPane(tabelaLivroPesquisa);
        painelTabela.setBounds(10, 40, 750, 150);
        painelTabela.getViewport().setBackground(painelExternoTabela.getBackground());
        painelExternoTabela.add(painelTabela);
        
    }
    
    public static void main(String[] args) {
        new PesquisarLivro().setVisible(true);
    }
}
