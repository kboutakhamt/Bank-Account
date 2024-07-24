package com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.AccountEntity;
import com.kboutakhamt.bankaccount.application.adapter.out.entity.OperationEntity;
import com.kboutakhamt.bankaccount.application.adapter.out.repository.IExtendedAccountRepository;
import com.kboutakhamt.bankaccount.domain.Account;
import com.kboutakhamt.bankaccount.domain.Operation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OperationMapper {

	private final IExtendedAccountRepository accountRepository;
	private final AccountMapper accountMapper;

	public Operation mapEntityToDomain(OperationEntity operationEntity) {
		Optional<AccountEntity> optionalAccountEntity = accountRepository
				.findById(operationEntity.getAccount().getId());
//		if (optionalAccountEntity.isPresent()) {
		Account account = accountMapper.mapEntityToDomain(optionalAccountEntity.get());
		return new Operation(account, operationEntity.getOperationType(), operationEntity.getAmount(),
				account.getCreationDate());
//		}
//		throw new IllegalArgumentException("Operation should have an existing account");
	}

	public OperationEntity mapDomainToEntity(Operation operation) {
		AccountEntity accountEntity = accountRepository.findById(operation.account().getId()).orElse(null);
//		if (optionalAccountEntity.isPresent()) {
//			accountMapper.merge(operation.account(), accountEntity);
		OperationEntity operationEntity = new OperationEntity();
		operationEntity.setAccount(accountEntity);
		operationEntity.setOperationType(operation.operationType());
		operationEntity.setAmount(operation.amount());
		operationEntity.setOperationDate(operation.operationDate());
		return operationEntity;
//		}
//		throw new IllegalArgumentException("Operation should have an existing account");
	}

}
