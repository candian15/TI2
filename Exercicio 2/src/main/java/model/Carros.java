package model;

public class Carros {
	private int codigo;
	private String placa;
	private String nome_carro;
	private char cor;
	
	public Carros() {
		this.codigo = -1;
		this.placa = "";
		this.nome_carro = "";
		this.cor = '*';
	}
	
	public Carros(int codigo, String placa, String nome_carro, char cor) {
		this.codigo = codigo;
		this.placa = placa;
		this.nome_carro = nome_carro;
		this.cor = cor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getplaca() {
		return placa;
	}

	public void setplaca(String placa) {
		this.placa = placa;
	}

	public String getnome_carro() {
		return nome_carro;
	}

	public void setnome_carro(String nome_carro) {
		this.nome_carro = nome_carro;
	}

	public char getcor() {
		return cor;
	}

	public void setcor(char cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Carros [codigo=" + codigo + ", placa=" + placa + ", nome_carro=" + nome_carro + ", cor=" + cor + "]";
	}	
}
