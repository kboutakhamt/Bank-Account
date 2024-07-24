package com.kboutakhamt.bankaccount.application.adapter.out.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account", schema = "bank")
public class AccountEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq-generator", sequenceName = "account_id_seq", initialValue = 1, allocationSize = 12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-generator")
	@Column(name = "account_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "balance")
	private Long balance;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

//	@OneToMany
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
//	@OrderBy("operation_date")
	private List<OperationEntity> operations;

}
