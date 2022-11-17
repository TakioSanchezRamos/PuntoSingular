package com.puntosingular.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	
	private long idAccount;
	private double amount;
	private String concept;
	private String date;
	
	public void createTransaction(long idAccount, String concept, double amount) {
		Date dateNow = new Date();
		SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		this.idAccount = idAccount;
		this.amount = amount;
		this.concept = concept;
		this.date = dateFor.format(dateNow);
	}

	public long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
