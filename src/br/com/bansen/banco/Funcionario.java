package br.com.bansen.banco;

import java.util.Date;

public class Funcionario extends Pessoa { //implements IAutenticavel
	private Date dataAdm;
	private double salario;
	private String cargo;
	
	public Date getDataAdm() {
		return dataAdm;
	}
	public void setDataAdm(Date dataAdm) {
		this.dataAdm = dataAdm;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
