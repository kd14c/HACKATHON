package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.BancoDeDados;
import model.Produto;

public class JanelaProduto extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField txtId, txtNome, txtPreco, txtCategoria;
    private JTable table;

    public JanelaProduto() {
    	getContentPane().setBackground(new Color(0, 255, 255));
        setTitle("Cadastro de Produtos");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 60, 25);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(80, 10, 100, 25);
        getContentPane().add(txtId);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 45, 60, 25);
        getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(80, 45, 200, 25);
        getContentPane().add(txtNome);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(10, 80, 60, 25);
        getContentPane().add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(80, 80, 100, 25);
        getContentPane().add(txtPreco);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(10, 115, 70, 25);
        getContentPane().add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(80, 115, 150, 25);
        getContentPane().add(txtCategoria);

        JButton btnAdicionar = new JButton("Adicionar Produto");
        btnAdicionar.setBounds(10, 150, 200, 30);
        getContentPane().add(btnAdicionar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 190, 460, 150);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Nome", "Preço", "Categoria" }
        ));
        scrollPane.setViewportView(table);

        btnAdicionar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nome = txtNome.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                String categoria = txtCategoria.getText();

                Produto p = new Produto(id, nome, preco, categoria);
                BancoDeDados.produtos.add(p);
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar produto.");
            }
        });
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Produto p : BancoDeDados.produtos) {
            model.addRow(new Object[] { p.getId(), p.getNome(), p.getPreco(), p.getCategoria() });
        }
    }
}