package com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper;

import org.springframework.stereotype.Component;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.AccountEntity;
import com.kboutakhamt.bankaccount.domain.Account;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountMapper {

//	private final OperationMapper operationMapper;

	public Account mapEntityToDomain(AccountEntity accountEntity) {
		return new Account(accountEntity.getId(), accountEntity.getUsername(), accountEntity.getBalance(),
				accountEntity.getCreationDate());
	}

	public AccountEntity mapDomainToEntity(Account account) {
		AccountEntity accountEntity = new AccountEntity();
//		if (account.getId() >= 0) {
		accountEntity.setId(account.getId());
//		}
		accountEntity.setUsername(account.getUsername());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setCreationDate(account.getCreationDate());

		// adding the new operation of account creation
//		OperationEntity operationEntity = new OperationEntity();
//		operationEntity.setAccount(accountEntity);
//		operationEntity.setOperationType(OperationTypeEnum.CREATION.getLabel());
//		operationEntity.setAmount(account.getBalance());
//		operationEntity.setOperationDate(account.getCreationDate());
//		List<OperationEntity> operations = new ArrayList<OperationEntity>();
//		operations.add(operationEntity);
//		accountEntity.setOperations(operations);

//		accountEntity.setOperations(account.getOperations().stream().map(operationMapper::mapDomainToEntity).toList());
		return accountEntity;
	}

//	public void merge(Account account, AccountEntity accountEntity) {
//		accountEntity.setBalance(account.getBalance());
//	}

}
