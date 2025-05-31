package model;

import javax.swing.*;
import view.JanelaProduto;
import view.JanelaCliente;
import view.JanelaVenda;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Vendas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 250);
            frame.setLayout(null);

            JButton btnProdutos = new JButton("Gerenciar Produtos");
            btnProdutos.setBounds(50, 30, 180, 30);
            frame.add(btnProdutos);

            JButton btnClientes = new JButton("Gerenciar Clientes");
            btnClientes.setBounds(50, 70, 180, 30);
            frame.add(btnClientes);

            JButton btnVendas = new JButton("Realizar Venda");
            btnVendas.setBounds(50, 110, 180, 30);
            frame.add(btnVendas);

            btnProdutos.addActionListener(e -> new JanelaProduto().setVisible(true));
            btnClientes.addActionListener(e -> new JanelaCliente().setVisible(true));
            btnVendas.addActionListener(e -> new JanelaVenda().setVisible(true));

            frame.setVisible(true);
        });

	}

}