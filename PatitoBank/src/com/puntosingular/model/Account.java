package com.puntosingular.model;

import java.util.List;
import java.util.Random;

public class Account {
	private String titularName;
	private String curp;
	private long idAccount;
	
	public String getTitularName() {
		return titularName;
	}
	public void setTitularName(String titularName) {
		this.titularName = titularName;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public long getIdAccount() {
		return idAccount;
	}
	
	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}
	
	public void generateAccount() {
		Random r = new Random(System.currentTimeMillis());
		//this.idAccount = (int)(Math.random()*999999999+1);
		this.idAccount = 999999999 + r.nextInt(1000000000);
	}
	
	public double calculateAmount(List<Transaction> transacciones) {
		double saldo = 0;
		for (int i = 0; i < transacciones.size(); i++) {
			if((transacciones.get(i).getIdAccount() == this.idAccount) && (transacciones.get(i).getConcept() == "Deposito")) {
				saldo = saldo + transacciones.get(i).getAmount();
			}else if ((transacciones.get(i).getIdAccount() == this.idAccount) && (transacciones.get(i).getConcept() == "Retiro")) {
				saldo = saldo - transacciones.get(i).getAmount();
			}
			//System.out.println("/n/n monto: "+saldo);
		}
		return saldo;
	}
	
	public boolean verifyPasssword(String password) {
		if (password.equals("pass123")) {
			return true;
		}else {
			return false;
		}
	}
}
