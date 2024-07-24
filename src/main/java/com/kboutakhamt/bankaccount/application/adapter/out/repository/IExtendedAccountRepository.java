package com.kboutakhamt.bankaccount.application.adapter.out.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.AccountEntity;
import com.kboutakhamt.bankaccount.domain.Account;

@Repository
@Transactional
public interface IExtendedAccountRepository extends JpaRepository<AccountEntity, Long> {

	Account save(Account account);

}