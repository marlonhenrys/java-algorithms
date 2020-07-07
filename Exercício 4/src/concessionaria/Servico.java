package concessionaria;

public class Servico extends Oferta {
	private String descricao;

	public Servico(float preco, String descricao) {
		super(preco);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
