package com.kboutakhamt.bankaccount.application.adapter.out.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.AccountEntity;
import com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper.AccountMapper;
import com.kboutakhamt.bankaccount.domain.Account;
import com.kboutakhamt.bankaccount.domain.port.out.IAccountRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountRepository implements IAccountRepository {

	private final IExtendedAccountRepository extendedAccountRepository;
	private final AccountMapper accountMapper;
//	private final OperationRepository operationRepository;

	@Override
	public Account get(Long id) {
		Optional<AccountEntity> optionalAccountEntity = extendedAccountRepository.findById(id);
		return optionalAccountEntity.map(accountMapper::mapEntityToDomain).orElse(null);
	}

//	@Override
//	public Account create(Long id, String username, Long balance) {
//		// check if the account already exists
//		Account account = get(id);
//		if (account != null) {
//			throw new DuplicateAccountException("This account already exists!");
//		}
//
//		// or else saving the new account
//		account = new Account(id, username, balance, LocalDateTime.now());
//
//		// saving the new operation of account creation
//		Operation operation = new Operation(account, OperationTypeEnum.CREATION.getLabel(), balance,
//				account.getCreationDate());
//		operation = operationRepository.save(operation);
//
//		// saving the new account
//		List<Operation> operations = new ArrayList<>();
//		operations.add(operation);
//		account.setOperations(operations);
//		return save(account);
//	}

	@Override
	public Account save(Account account) {
		AccountEntity accountEntity = accountMapper.mapDomainToEntity(account);
		accountEntity = extendedAccountRepository.save(accountEntity);
		return accountMapper.mapEntityToDomain(accountEntity);
	}

}
