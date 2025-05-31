package view;

import javax.swing.*;
import java.awt.*;
import model.Cliente;
import model.Produto;
import model.BancoDeDados;

public class JanelaVenda extends JFrame {
	private static final long serialVersionUID = 1L;
    private JComboBox<Cliente> comboClientes;
    private JComboBox<Produto> comboProdutos;

    public JanelaVenda() {
    	getContentPane().setBackground(new Color(0, 255, 255));
        setTitle("Vendas");
        setBounds(100, 100, 400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(10, 20, 100, 25);
        getContentPane().add(lblCliente);

        comboClientes = new JComboBox<>();
        comboClientes.setBounds(100, 20, 250, 25);
        getContentPane().add(comboClientes);

        JLabel lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(10, 60, 100, 25);
        getContentPane().add(lblProduto);

        comboProdutos = new JComboBox<>();
        comboProdutos.setBounds(100, 60, 250, 25);
        getContentPane().add(comboProdutos);

        JButton btnVender = new JButton("Vender");
        btnVender.setBounds(100, 110, 120, 30);
        getContentPane().add(btnVender);

        btnVender.addActionListener(e -> realizarVenda());

        atualizarCombos();
    }

    private void atualizarCombos() {
        comboClientes.removeAllItems();
        comboProdutos.removeAllItems();

        for (Cliente c : BancoDeDados.clientes) {
            comboClientes.addItem(c);
        }

        for (Produto p : BancoDeDados.produtos) {
            comboProdutos.addItem(p);
        }
    }

    private void realizarVenda() {
        Cliente cliente = (Cliente) comboClientes.getSelectedItem();
        Produto produto = (Produto) comboProdutos.getSelectedItem();

        if (cliente == null || produto == null) {
            JOptionPane.showMessageDialog(this, "Selecione cliente e produto.");
            return;
        }

        if (cliente.getCredito() >= produto.getPreco()) {
            cliente.setCredito(cliente.getCredito() - produto.getPreco());
            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Crédito insuficiente.");
        }

        atualizarCombos();
    }
}