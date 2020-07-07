package crud;

import java.io.*;
import java.time.LocalDateTime;

public class Pagina implements Entidade {
	protected int id;
	protected String url;
	protected String acesso;

	public Pagina(int id, String url, LocalDateTime acesso) {
		this.id = id;
		this.url = url;
		this.acesso = acesso.toString();
	}

	public Pagina() {
		this.id = 0;
		this.url = "";
		this.acesso = LocalDateTime.now().toString();
	}

	public void setId(int c) {
		this.id = c;
	}

	public int getId() {
		return this.id;
	}

	public String toString() {
		return "\nID: " + this.id + "\nURL: " + this.url + "\nAcesso: " + this.acesso;
	}

	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		saida.writeInt(this.id);
		saida.writeUTF(this.url);
		saida.writeUTF(this.acesso);
		return dados.toByteArray();
	}

	public void setByteArray(byte[] b) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(b);
		DataInputStream entrada = new DataInputStream(dados);
		this.id = entrada.readInt();
		this.url = entrada.readUTF();
		this.acesso = entrada.readUTF();
	}

}
