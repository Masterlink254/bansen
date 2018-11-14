package br.com.bansen.banco;

import java.util.Date;

public class Pessoa {

	private String nome;
	private int rg;
	private String cpf;
	private Date dataNasc;
	private String telefone1;
	private String telefone2;
	private String endereco;
	private int numero;
	private String bairro;
	private String municipio;
	private String uf;
	private int cep;

	public Pessoa() {
		this(null, 0, null, null, null, null, null, 0, null, null, null, 0);
	}

	public Pessoa(String nome, int rg, String cpf, Date dataNasc, String telefone1, String telefone2, String endereco,
				  int numero, String bairro, String municipio, String uf, int cep) {

		setNome(nome);
		setRg(rg);
		setCpf(cpf);
		setDataNasc(dataNasc);
		setTelefone1(telefone1);
		setTelefone2(telefone2);
		setEndereco(endereco);
		setNumero(numero);
		setBairro(bairro);
		setMunicipio(municipio);
		setUf(uf);
		setCep(cep);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

}
