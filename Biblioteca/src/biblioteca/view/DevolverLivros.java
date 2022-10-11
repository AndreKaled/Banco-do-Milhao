/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Aluno
 */
public class DevolverLivros extends JFrame{

    
    // Painel Funcionario
    private JPanel painelFuncionario;
    private JLabel rotuloFuncionario, matricula, numOab, nome, iconeFuncionario;
    private JTextField txtMatricula, txtNumOab, txtNome;
    private JButton btnLimpar, btnPesquisarFuncionario, btnVoltar;
    
    // Painel Livro Devolução
    
    private JPanel painelLivroDevolução;
    private JLabel rotuloDevolução, numExemplar1, iconeDevolucao;
    private JTextField txtNumExemplar1;
    private JButton btnPesquisarLivro, btnSalvar;
    private JTable tabelaLivro;
    private String colunas[] = {"Nº Exemplar", "Nome", "Editora", "Devoluir"};
    private Object dados[][] = {};
    
    
    public DevolverLivros(){
        configFrame();
        configPainelFuncionario();
        configElementosPainelFuncionario();
        configPainelDevolucaoLivro();
        configElementosPainelDevolução();
    }        
    
    private void configFrame(){
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Devolver Livro");
        
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
    
    private void configPainelFuncionario(){
        painelFuncionario = new JPanel(null);
        painelFuncionario.setBounds(0, 10, this.getSize().width, (this.getSize().height/2)-40);
        painelFuncionario.setBackground(new Color(209, 226, 205));
        add(painelFuncionario);
    }
    
    private void configPainelDevolucaoLivro(){
        painelLivroDevolução = new JPanel(null);
        painelLivroDevolução.setBounds(0, 330, this.getSize().width, (this.getSize().height/2)-10);
        painelLivroDevolução.setBackground(new Color(209, 226, 205));
        add(painelLivroDevolução);
    }
    
    private void configElementosPainelFuncionario(){
        if(painelFuncionario!=null){
            
            iconeFuncionario = new JLabel(new ImageIcon(getClass().getResource("/images/FuncionarioIcone.png")));
            iconeFuncionario.setBounds(580, 60, 150, 150);
            painelFuncionario.add(iconeFuncionario);
            
            rotuloFuncionario = new JLabel("Funcionario");
            rotuloFuncionario.setBounds(580, 10, 180, 40);
            rotuloFuncionario.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3)));
            rotuloFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
            rotuloFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);
            rotuloFuncionario.setFont(new Font("Arial", 0, 32));
            painelFuncionario.add(rotuloFuncionario);
            
            matricula = new JLabel("Matricula");
            matricula.setFont(new Font("Arial", 0, 24));
            matricula.setBounds(10, 10, 200, 30);
            painelFuncionario.add(matricula);
            
            numOab = new JLabel("Número OAB");
            numOab.setFont(new Font("Arial", 0, 24));
            numOab.setBounds(10, 110, 200, 30);
            painelFuncionario.add(numOab);
            
            nome = new JLabel("Nome");
            nome.setFont(new Font("Arial", 0, 24));
            nome.setBounds(10, 210, 200, 30);
            painelFuncionario.add(nome);
            
            txtMatricula = new JTextField();
            txtMatricula.setFont(new Font("Arial", 0, 18));
            txtMatricula.setBounds(10, 55, 300, 30);
            painelFuncionario.add(txtMatricula);
            
            txtNumOab = new JTextField();
            txtNumOab.setFont(new Font("Arial", 0, 18));
            txtNumOab.setBounds(10, 155, 300, 30);
            txtNumOab.setEditable(false);
            painelFuncionario.add(txtNumOab);
            
            txtNome = new JTextField();
            txtNome.setFont(new Font("Arial", 0, 18));
            txtNome.setBounds(10, 255, 300, 30);
            painelFuncionario.add(txtNome);
            
            btnPesquisarFuncionario = new JButton("Pesquisar");
            btnPesquisarFuncionario.setFont(new Font("Arial", 0, 24));
            btnPesquisarFuncionario.setBounds(500, 250, 150, 30);
            btnPesquisarFuncionario.setBackground(painelFuncionario.getBackground().brighter());
            painelFuncionario.add(btnPesquisarFuncionario);
            
            btnLimpar = new JButton("Limpar");
            btnLimpar.setFont(new Font("Arial", 0, 24));
            btnLimpar.setBounds(675, 250, 150, 30);
            btnLimpar.setBackground(painelFuncionario.getBackground().brighter());
            painelFuncionario.add(btnLimpar);
        }
    }
    
    private void configElementosPainelDevolução(){
        if(painelLivroDevolução!=null){
            
            iconeDevolucao = new JLabel(new ImageIcon(getClass().getResource("/images/Devolucao.png")));
            iconeDevolucao.setBounds(600, 60, 150, 150);
            painelLivroDevolução.add(iconeDevolucao);
            
            rotuloDevolução = new JLabel("Devolução");
            rotuloDevolução.setBounds(580, 10, 165, 40);
            rotuloDevolução.setFont(new Font("Arial", 0, 32));
            rotuloDevolução.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3)));
            rotuloDevolução.setHorizontalAlignment(SwingConstants.CENTER);
            rotuloDevolução.setHorizontalTextPosition(SwingConstants.CENTER);
            painelLivroDevolução.add(rotuloDevolução);
            
            numExemplar1 = new JLabel("Nº Exemplar");
            numExemplar1.setFont(new Font("Arial", 0, 24));
            numExemplar1.setBounds(10, 10, 200, 30);
            painelLivroDevolução.add(numExemplar1);
            
            btnPesquisarLivro = new JButton("Pesquisar");
            btnPesquisarLivro.setFont(new Font("Arial", 0, 24));
            btnPesquisarLivro.setBounds(320, 55, 150, 30);
            btnPesquisarLivro.setBackground(painelLivroDevolução.getBackground().brighter());
            painelLivroDevolução.add(btnPesquisarLivro);
            
            txtNumExemplar1 = new JTextField();
            txtNumExemplar1.setFont(new Font("Arial", 0, 18));
            txtNumExemplar1.setBounds(10, 55, 300, 30);
            painelLivroDevolução.add(txtNumExemplar1);
            
            DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
            
            
            tabelaLivro = new JTable(modeloTabela);
            tabelaLivro.setBackground(painelLivroDevolução.getBackground());
            tabelaLivro.getTableHeader().setFont(new Font("Arial", 0, 14));
            tabelaLivro.getTableHeader().setBackground(painelLivroDevolução.getBackground().brighter());
            tabelaLivro.getTableHeader().setReorderingAllowed(false);
            tabelaLivro.getTableHeader().setResizingAllowed(true);
            tabelaLivro.setFont(new Font("Arial", 0, 16));
            
            JScrollPane painelTabela = new JScrollPane(tabelaLivro);
            
            painelTabela.setBounds(10, 100, 500, 200);
            painelTabela.getViewport().setBackground(painelLivroDevolução.getBackground());
            painelTabela.setBackground(painelLivroDevolução.getBackground());
            painelLivroDevolução.add(painelTabela);
            
            btnSalvar = new JButton("Salvar");
            btnSalvar.setFont(new Font("Arial", 0, 24));
            btnSalvar.setBounds(580, 250, 150, 30);
            btnSalvar.setBackground(painelLivroDevolução.getBackground().brighter());
            painelLivroDevolução.add(btnSalvar);
        }
    }
    
    public static void main(String[] args) {
        new DevolverLivros().setVisible(true);
    }
    
}
