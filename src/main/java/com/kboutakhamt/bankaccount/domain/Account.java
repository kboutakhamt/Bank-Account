package com.kboutakhamt.bankaccount.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

/**
 * 
 * POJO of bank account
 * 
 */
@Data
public final class Account {
	private final Long id;
	private String username;
	private Long balance;
	private LocalDateTime creationDate;
	private List<Operation> operations;

	// Init constructor
	public Account(Long id, String username, Long balance, LocalDateTime creationDate) {
		this.id = id;
		this.username = username;
		this.balance = balance;
		this.creationDate = creationDate;
	}

}
