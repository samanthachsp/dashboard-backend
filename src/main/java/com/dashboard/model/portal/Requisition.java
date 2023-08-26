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
 * The persistent class for the Requisition database table.
 * 
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="REQUISITION")
@NamedQuery(name="Requisition.findAll", query="SELECT c FROM Requisition c")
public class Requisition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id") @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	
	@Column(name="SkNo", unique=true)
	private String skNo;

	@Column(name="Amount", unique=true)
	private double amount;
	
	@Column(name="DateCreated")
	private Timestamp dateCreated;


	public Requisition() {
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


	public String getSkNo() {
		return skNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setSkNo(String skNo) {
		this.skNo = skNo;
	}

	
}