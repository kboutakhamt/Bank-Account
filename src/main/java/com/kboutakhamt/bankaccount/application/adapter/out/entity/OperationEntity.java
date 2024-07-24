package com.kboutakhamt.bankaccount.application.adapter.out.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation", schema = "bank")
public class OperationEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq-generator", sequenceName = "operation_id_seq", initialValue = 1, allocationSize = 12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-generator")
	@Column(name = "operation_id", unique = true, nullable = false)
	private Long id;

//	@Column(name = "account_id")
//	private Long accountId;

	@Column(name = "operation_type")
	private String operationType;

	@Column(name = "amount")
	private Long amount;

	@Column(name = "operation_date")
	private LocalDateTime operationDate;

	// org.hibernate.PersistentObjectException: detached entity passed to persist:
	// com.kboutakhamt.bankaccount.application.adapter.out.entity.AccountEntity
//	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@ManyToOne(cascade = { CascadeType.MERGE })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private AccountEntity account;

}
