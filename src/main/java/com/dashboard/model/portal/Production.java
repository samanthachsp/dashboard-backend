package com.dashboard.model.portal;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The persistent class for the Production database table.
 * 
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="PRODUCTION")
@NamedQuery(name="Production.findAll", query="SELECT c FROM Production c")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id") @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	
	@Column(name="Item", unique=true)
	private String item;

	@Column(name="Amount", unique=true)
	private double amount;
	
	@Column(name="DateCreated")
	private Timestamp dateCreated;


	public Production() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}



	
}