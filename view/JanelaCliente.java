package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.BancoDeDados;
import model.Cliente;

public class JanelaCliente extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField txtId, txtNome, txtCredito;
    private JTable table;

    public JanelaCliente() {
    	getContentPane().setBackground(new Color(0, 255, 255));
        setTitle("Cadastro de Clientes");
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

        JLabel lblCredito = new JLabel("Crédito:");
        lblCredito.setBounds(10, 80, 60, 25);
        getContentPane().add(lblCredito);

        txtCredito = new JTextField();
        txtCredito.setBounds(80, 80, 100, 25);
        getContentPane().add(txtCredito);

        JButton btnAdicionar = new JButton("Adicionar Cliente");
        btnAdicionar.setBounds(10, 120, 200, 30);
        getContentPane().add(btnAdicionar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 160, 460, 170);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Nome", "Crédito" }
        ));
        scrollPane.setViewportView(table);

        btnAdicionar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nome = txtNome.getText();
                double credito = Double.parseDouble(txtCredito.getText());

                Cliente c = new Cliente(id, nome, credito);
                BancoDeDados.clientes.add(c);
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente.");
            }
        });
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Cliente c : BancoDeDados.clientes) {
            model.addRow(new Object[] { c.getId(), c.getNome(), c.getCredito() });
        }
    }
}