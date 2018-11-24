package br.com.bansen.contas;

import br.com.bansen.usuarios.Pessoa;

public class Conta {
	private int numero;
	private String tipoConta;
	private double saldo;
	private int titular;
	private String senha;							
	
	public Conta() {
		
	}
	
	public Conta(int numero, String tipoConta, double saldo, int titular, String senha) {
		setNumero(numero);
		setTipoConta(tipoConta);
		setSaldo(saldo);
		setTitular(titular);
		setSenha(senha);
	}

	public int getNumero() {
		return this.numero;
	}
	
	public String getTipoConta() {
		return this.tipoConta;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getTitular() {
		return this.titular;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setTitular(int titular) {
		this.titular = titular;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
