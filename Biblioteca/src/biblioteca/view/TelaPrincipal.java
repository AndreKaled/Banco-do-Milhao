/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author thiag
 */
public class TelaPrincipal extends JFrame {

    JPanel painelPrincipal;
    JLabel lblTitulo, lblFoto, lblEmprestar, lblPesquisar, lblDevolver, lblConsultar;
    JButton btnEmprestar, btnPesquisar, btnDevolver, btnConsultar;

    public TelaPrincipal() {
        configFrame();
        configPainel();
        configElementosPainel();
    }

    private void configFrame() {
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Biblioteca dos advogados");
    }

    private void configPainel() {
        painelPrincipal = new JPanel(null);
        painelPrincipal.setBackground(new Color(209, 226, 205));
        painelPrincipal.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(painelPrincipal);
    }

    private void configElementosPainel() {

        lblFoto = new JLabel(new ImageIcon(getClass().getResource("/images/IconeLeiBiblioteca.png")));
        lblFoto.setBounds(50, 30, 125, 125);
        painelPrincipal.add(lblFoto);

        lblTitulo = new JLabel("SISTEMA PARA GERENCIAMENTO DA BIBLIOTECA");
        lblTitulo.setFont(new Font("Arial", 1, 20));
        lblTitulo.setBounds(225, 75, 600, 30);
        painelPrincipal.add(lblTitulo);

        lblEmprestar = new JLabel("Emprestar Livro");
        lblEmprestar.setFont(new Font("Arial", 1, 17));
        lblEmprestar.setBounds(40, 200, 300, 30);
        lblEmprestar.setHorizontalTextPosition(SwingConstants.CENTER);
        lblEmprestar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmprestar.setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black.brighter()));
        painelPrincipal.add(lblEmprestar);

        btnEmprestar = new JButton(new ImageIcon(getClass().getResource("/images/EmprestarLivro.png")));
        btnEmprestar.setBounds(100, 250, 150, 125);
        btnEmprestar.addMouseListener(new AnimacaoBotao(btnEmprestar));
        btnEmprestar.addActionListener(new AbrirEmprestar());
        btnEmprestar.setBackground(null);
        btnEmprestar.setHorizontalAlignment(SwingConstants.CENTER);
        btnEmprestar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEmprestar.setBorder(BorderFactory.createMatteBorder(4, 3, 4, 3, Color.black));
        painelPrincipal.add(btnEmprestar);

        lblDevolver = new JLabel("Devolver Livro");
        lblDevolver.setFont(new Font("Arial", 1, 17));
        lblDevolver.setBounds(425, 200, 300, 30);
        lblDevolver.setHorizontalTextPosition(SwingConstants.CENTER);
        lblDevolver.setHorizontalAlignment(SwingConstants.CENTER);
        lblDevolver.setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black.brighter()));
        painelPrincipal.add(lblDevolver);

        btnDevolver = new JButton(new ImageIcon(getClass().getResource("/images/DevolverLivro.png")));
        btnDevolver.setBounds(485, 250, 150, 125);
        btnDevolver.setBackground(null);
        btnDevolver.addMouseListener(new AnimacaoBotao(btnDevolver));
        btnDevolver.addActionListener(new AbrirDevolver());
        btnDevolver.setHorizontalAlignment(SwingConstants.CENTER);
        btnDevolver.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDevolver.setBorder(BorderFactory.createMatteBorder(4, 3, 4, 3, Color.black));
        painelPrincipal.add(btnDevolver);

        lblPesquisar = new JLabel("Pesquisar Livro");
        lblPesquisar.setFont(new Font("Arial", 1, 17));
        lblPesquisar.setBounds(40, 400, 300, 30);
        lblPesquisar.setHorizontalTextPosition(SwingConstants.CENTER);
        lblPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
        lblPesquisar.setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black.brighter()));
        painelPrincipal.add(lblPesquisar);

        btnPesquisar = new JButton(new ImageIcon(getClass().getResource("/images/PesquisarLivro.png")));
        btnPesquisar.setBounds(100, 450, 150, 125);
        btnPesquisar.setBackground(null);
        btnPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
        btnPesquisar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPesquisar.addMouseListener(new AnimacaoBotao(btnPesquisar));
        btnPesquisar.addActionListener(new AbrirPesquisar());
        btnPesquisar.setBorder(BorderFactory.createMatteBorder(4, 3, 4, 3, Color.black));
        painelPrincipal.add(btnPesquisar);

        lblConsultar = new JLabel("Consultar Livros emprestados");
        lblConsultar.setFont(new Font("Arial", 1, 17));
        lblConsultar.setBounds(425, 400, 300, 30);
        lblConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
        lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsultar.setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black.brighter()));
        painelPrincipal.add(lblConsultar);

        btnConsultar = new JButton(new ImageIcon(getClass().getResource("/images/ConsultarLivro.png")));
        btnConsultar.setBounds(485, 450, 150, 125);
        btnConsultar.setBackground(null);
        btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
        btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnConsultar.addMouseListener(new AnimacaoBotao(btnConsultar));
        btnConsultar.addActionListener(new AbrirConsula());
        btnConsultar.setBorder(BorderFactory.createMatteBorder(4, 3, 4, 3, Color.black));
        painelPrincipal.add(btnConsultar);
    }

    private class AnimacaoBotao implements MouseListener {

        private Thread animacao;
        private JButton btn;
        private int x;
        private int y;
        private int widht;
        private int height;

        public AnimacaoBotao(JButton btn) {
            this.btn = btn;
            x = btn.getX();
            y = btn.getY();
            widht = btn.getWidth();
            height = btn.getHeight();
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            animacao = new Thread(new RunAnimacao(btn));
            btn.setBackground(painelPrincipal.getBackground().darker());
            animacao.start();
        }

        @Override
        public void mouseExited(MouseEvent me) {
            btn.setBounds(x, y, widht, height);
            btn.setBackground(null);
            painelPrincipal.revalidate();
            painelPrincipal.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

    }

    private class RunAnimacao implements Runnable {

        private JButton btn;
        private int numMaxW;
        private int numMaxH;
        private int widht;
        private int height;
        private int x;
        private int y;

        public RunAnimacao(JButton btn) {
            this.btn = btn;
            numMaxW = btn.getWidth() + 10;
            numMaxH = btn.getHeight() + 10;
            widht = btn.getWidth();
            height = btn.getHeight();
            x = btn.getX()+10;
            y = btn.getY()+10;
        }

        @Override
        public void run() {
            try {
                while (widht != numMaxW && height != numMaxH) {
                    btn.setBounds(btn.getX(), btn.getY(), widht, height);
                    widht++;
                    height++;
                    painelPrincipal.revalidate();
                    painelPrincipal.repaint();
                    x--;
                    y--;
                    Thread.sleep(4);
                }
                Thread.yield();
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }

    }
    
    private class AbrirEmprestar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            new EmprestarLivro().setVisible(true);
        }
        
    }
    private class AbrirDevolver implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            new DevolverLivros().setVisible(true);
        }
        
    }
    private class AbrirPesquisar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            new PesquisarLivro().setVisible(true);
        }
        
    }
    private class AbrirConsula implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            new ConsultarEmprestados().setVisible(true);
        }
        
    }

    public static void main(String[] args) {
        new TelaPrincipal().setVisible(true);
    }

}
