package com.micky.samples.springcouchcache.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Player implements Serializable {

	private static final long serialVersionUID = 3072475211055736282L;

	@Id
	private String id;

	@Field
	private BigDecimal balance;

	@Field
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Player [id=%s, balance=%s, name=%s]", id, balance, name);
	}

}
