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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class ConsultarEmprestados extends JFrame{
    
    JPanel painelPrincipal;
    JScrollPane painelTabela;
    JTable tabelaLivroEmprestados;
    JLabel lblTitulo;
    JButton btnSair, btnVoltar;
    String colunasTabelaLivrosEmprestado[] = {"Nº Ex", "Nome", "Advogado", "Empréstimo", "Devolução", "Entrega"};
    Object dadosTabela[][] = {};
    
    public ConsultarEmprestados() {
        configFrame();
        configPainel();
        configElementosPainel();
    }
    
    private void configFrame(){
        setSize(900, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Consultar Livros Emprestados");
    }
    
    private void configPainel(){
        painelPrincipal = new JPanel(null);
        painelPrincipal.setBackground(new Color(209, 226, 205));
        painelPrincipal.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(painelPrincipal);
    }
    
    private void configElementosPainel(){
        
        lblTitulo = new JLabel("Sistema para Controle da Biblioteca");
        lblTitulo.setFont(new Font("Arial", 1, 32));
        lblTitulo.setBounds(180, 20, 600, 40);
        painelPrincipal.add(lblTitulo);
        
        DefaultTableModel modeleTabela = new DefaultTableModel(dadosTabela, colunasTabelaLivrosEmprestado);
        tabelaLivroEmprestados = new JTable(modeleTabela);
        tabelaLivroEmprestados.setFont(new Font("Arial", 0, 12));
        tabelaLivroEmprestados.getTableHeader().setFont(new Font("Arial", 1, 16));
        tabelaLivroEmprestados.getTableHeader().setReorderingAllowed(false);
        tabelaLivroEmprestados.getTableHeader().setResizingAllowed(true);
        tabelaLivroEmprestados.getTableHeader().setBackground(painelPrincipal.getBackground().brighter());
        tabelaLivroEmprestados.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
        tabelaLivroEmprestados.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(70);
        
        painelTabela = new JScrollPane(tabelaLivroEmprestados);
        painelTabela.setBounds(10, 80, 870, 240);
        painelTabela.getViewport().setBackground(painelPrincipal.getBackground());
        painelPrincipal.add(painelTabela);
        
        btnSair = new JButton("Sair");
        btnSair.setBackground(Color.red.brighter());
        btnSair.setBounds(380, 330, 100, 30);
        btnSair.setFont(new Font("Arial", 1, 20));
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaPrincipal().setVisible(true);
            }
        });
        
        painelPrincipal.add(btnSair);
        
    }
    
    public static void main(String[] args) {
        new ConsultarEmprestados().setVisible(true);
    }
    
}
