package com.kboutakhamt.bankaccount.application.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper.AccountMapper;
import com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper.OperationMapper;
import com.kboutakhamt.bankaccount.application.common.enums.OperationTypeEnum;
import com.kboutakhamt.bankaccount.domain.Account;
import com.kboutakhamt.bankaccount.domain.Operation;

@ActiveProfiles("test")
@DataJpaTest
@Import({ AccountRepository.class, AccountMapper.class, OperationRepository.class, OperationMapper.class })
class OperationRepositoryTest {
	private final Logger LOGGER = LoggerFactory.getLogger(AccountRepositoryTest.class);

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OperationRepository operationRepository;

	@Test
	void createTest() {
		Account account = new Account(1L, "user1", 0L, LocalDateTime.now());
		account = accountRepository.save(account);
		Operation operation = new Operation(account, OperationTypeEnum.CREATION.getLabel(), account.getBalance(),
				account.getCreationDate());
		operationRepository.save(operation);
		LOGGER.info(" ************* createTest(): Account: " + account + " | Operation: " + operation);
		assertEquals(operation, operationRepository.save(operation));
	}

	@Test
	void getAllTest() {
		Account account = new Account(1L, "user2", 1000L, LocalDateTime.now());
		account = accountRepository.save(account);
		Operation operation1 = new Operation(account, OperationTypeEnum.CREATION.getLabel(), account.getBalance(),
				account.getCreationDate());
		operationRepository.save(operation1);
		Operation operation2 = new Operation(account, OperationTypeEnum.WITHDRAWAL.getLabel(), 200L,
				LocalDateTime.now());
		operationRepository.save(operation2);
		LOGGER.info(" ************* getAllTest(): Operation1: " + operation1 + " | Operation2: " + operation2);
		assertEquals(2, operationRepository.getAll(1L).size());
	}

	@Test
	void getAllOrderedTest() {
		Account account = new Account(1L, "user3", 500L, LocalDateTime.now());
		account = accountRepository.save(account);
		Operation operation1 = new Operation(account, OperationTypeEnum.CREATION.getLabel(), account.getBalance(),
				account.getCreationDate());
		operationRepository.save(operation1);
		Operation operation2 = new Operation(account, OperationTypeEnum.WITHDRAWAL.getLabel(), 200L,
				LocalDateTime.now());
		operationRepository.save(operation2);
		LOGGER.info(" ************* getAllOrderedTest(): Operation1: " + operation1 + " | Operation2: " + operation2);
		assertTrue(operation2.operationDate().isAfter(operation1.operationDate()));
	}

}