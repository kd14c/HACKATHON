package model;

public class Cliente {
	
	private int id;
    private String nome;
    private double credito;

    public Cliente(int id, String nome, double credito) {
        this.id = id;
        this.nome = nome;
        this.credito = credito;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getCredito() { return credito; }
    public void setCredito(double credito) { this.credito = credito; }

    @Override
    public String toString() {
        return nome + " (Crédito: R$ " + credito + ")";
    }

}