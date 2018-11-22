package br.com.bansen.usuarios;

import java.util.Date;

public class Pessoa {

	private String nome;
	private String sobrenome;
	private String email;
	private String sexo;
	private String cpf;
	private Integer rg;
	private Date dataNasc;
	private String telefone1;
	private String telefone2;
	private boolean ativo;
	
	public Pessoa() {
		this(null, null, null, null, null, 0, null, null, null, false);
	}

	public Pessoa(String nome, String sobrenome, String email, String sexo, String cpf, Integer rg, Date dataNasc, String telefone1, String telefone2, boolean ativo) {

		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSexo(sexo);
		setCpf(cpf);
		setRg(rg);
		setDataNasc(dataNasc);
		setTelefone1(telefone1);
		setTelefone2(telefone2);
		setAtivo(ativo);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRg() {
		return this.rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}
	
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean getAtivo() {
		return this.ativo;
	}
}
