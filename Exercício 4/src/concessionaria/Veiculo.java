package concessionaria;

public class Veiculo extends Oferta{
	private String cor;
	private String modelo;
	private int ano;
	
	public Veiculo(float preco, String cor, String modelo, int ano) {
		super(preco);
		this.cor = cor;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}
