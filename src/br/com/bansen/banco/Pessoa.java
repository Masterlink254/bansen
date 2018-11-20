package br.com.bansen.banco;

import java.util.Date;

public class Pessoa {

	private String nome;
<<<<<<< HEAD
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
=======
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
		setCpf(cpf);
		setRg(rg);
		setDataNasc(dataNasc);
		setTelefone1(telefone1);
		setTelefone2(telefone2);
		setAtivo(ativo);
	}

	public String getNome() {
		return this.nome;
>>>>>>> design
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

<<<<<<< HEAD
	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
=======
	public Integer getRg() {
		return this.rg;
	}

	public void setRg(Integer rg) {
>>>>>>> design
		this.rg = rg;
	}

	public String getCpf() {
<<<<<<< HEAD
		return cpf;
=======
		return this.cpf;
>>>>>>> design
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
<<<<<<< HEAD
		return dataNasc;
=======
		return this.dataNasc;
>>>>>>> design
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone1() {
<<<<<<< HEAD
		return telefone1;
=======
		return this.telefone1;
>>>>>>> design
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
<<<<<<< HEAD
		return telefone2;
=======
		return this.telefone2;
>>>>>>> design
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

<<<<<<< HEAD
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

=======
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
>>>>>>> design
}
