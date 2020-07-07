package entidades;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import interfaces.Entidade;

public class Monitor extends Aluno implements Entidade {
	private String disciplina;

	public Monitor(String nome, int matricula, String curso, String disciplina) {
		super(nome, matricula, curso);
		this.disciplina = disciplina;
	}

	public Monitor() {
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public void setId(int codigo) {
		super.setMatricula(codigo);
	}

	@Override
	public int getId() {
		return super.getMatricula();
	}

	public String toString() {
		return this.getMatricula() + " - " + this.getNome() + "\n" + this.getCurso() + " - " + this.getDisciplina();
	}

	@Override
	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		saida.writeUTF(super.getNome());
		saida.writeInt(super.getMatricula());
		saida.writeUTF(super.getCurso());
		saida.writeUTF(this.getDisciplina());
		return dados.toByteArray();
	}

	@Override
	public void setByteArray(byte[] b) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(b);
		DataInputStream entrada = new DataInputStream(dados);
		super.setNome(entrada.readUTF());
		super.setMatricula(entrada.readInt());
		super.setCurso(entrada.readUTF());
		this.setDisciplina(entrada.readUTF());
	}
}