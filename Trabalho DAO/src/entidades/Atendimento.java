package entidades;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import interfaces.Entidade;

public class Atendimento implements Entidade {
	private int id;
	private int monitorID;
	private String data;
	private int alunoID;
	private String nomeAluno;
	private String assunto;

	public Atendimento(int monitorID, String data, int alunoID, String nomeAluno, String assunto) {
		this.monitorID = monitorID;
		this.data = data;
		this.alunoID = alunoID;
		this.nomeAluno = nomeAluno;
		this.assunto = assunto;
	}

	public Atendimento() {

	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getAlunoID() {
		return alunoID;
	}

	public void setAlunoID(int alunoID) {
		this.alunoID = alunoID;
	}

	public int getMonitorID() {
		return monitorID;
	}

	public void setMonitorID(int monitorID) {
		this.monitorID = monitorID;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	@Override
	public void setId(int codigo) {
		this.id = codigo;
	}

	@Override
	public int getId() {
		return this.id;
	}

	public String toString() {
		return "ID: " + this.getId() + " - " + this.getData() + "\n" + this.getAlunoID() + " - " + this.getNomeAluno()
				+ "\n" + this.getAssunto();
	}

	@Override
	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		saida.writeInt(this.getMonitorID());
		saida.writeInt(this.getId());
		saida.writeUTF(this.getData());
		saida.writeInt(this.getAlunoID());
		saida.writeUTF(this.getNomeAluno());
		saida.writeUTF(this.getAssunto());
		return dados.toByteArray();
	}

	@Override
	public void setByteArray(byte[] b) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(b);
		DataInputStream entrada = new DataInputStream(dados);
		this.setMonitorID(entrada.readInt());
		this.setId(entrada.readInt());
		this.setData(entrada.readUTF());
		this.setAlunoID(entrada.readInt());
		this.setNomeAluno(entrada.readUTF());
		this.setAssunto(entrada.readUTF());
	}
}
