package com.kboutakhamt.bankaccount.application.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper.AccountMapper;
import com.kboutakhamt.bankaccount.domain.Account;

@ActiveProfiles("test")
@DataJpaTest
@Import({ AccountRepository.class, AccountMapper.class })
class AccountRepositoryTest {
	private final Logger LOGGER = LoggerFactory.getLogger(AccountRepositoryTest.class);

	@Autowired
	AccountRepository accountRepository;

	@Test
	void saveTest() {
		Account account = new Account(1L, "user1", 1500L, LocalDateTime.now());
		account = accountRepository.save(account);
		LOGGER.info(" ************* saveTest(): " + account);
		assertEquals(account, accountRepository.get(account.getId()));
	}

	@Test
	void getNotFoundTest() {
		LOGGER.info(" ************* getNotFoundTest(): ");
		assertNull(accountRepository.get(29L));
	}
}