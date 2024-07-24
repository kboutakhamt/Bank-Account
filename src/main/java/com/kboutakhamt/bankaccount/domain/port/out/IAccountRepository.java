package com.kboutakhamt.bankaccount.domain.port.out;

import com.kboutakhamt.bankaccount.domain.Account;

public interface IAccountRepository {

	Account get(Long id);

//	Account create(Long id, String username, Long balance);

	Account save(Account account);

}
