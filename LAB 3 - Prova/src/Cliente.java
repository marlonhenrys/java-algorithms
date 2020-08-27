
import java.io.*;

public class Cliente implements Entidade {
	protected int id;
	protected String nome;
	protected int idade;

	public Cliente(String nome, int idade, int c) {
		this.id = c;
		this.nome = nome;
		this.idade = idade;
	}

	public Cliente() {
		this.id = 0;
		this.nome = "";
		this.idade = 0;
	}

	public void setId(int codigo) {
		this.id = codigo;
	}

	public int getId() {
		return this.id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public String toString() {
		return "\nCódigo: " + this.id + "\nNome: " + this.nome + "\nIdade: " + this.idade;
	}

	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		saida.writeInt(this.id);
		saida.writeUTF(this.nome);
		saida.writeInt(this.idade);
		return dados.toByteArray();
	}

	public void setByteArray(byte[] b) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(b);
		DataInputStream entrada = new DataInputStream(dados);
		this.id = entrada.readInt();
		this.nome = entrada.readUTF();
		this.idade = entrada.readInt();
	}
}
