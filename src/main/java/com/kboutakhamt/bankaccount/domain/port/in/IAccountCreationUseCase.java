package com.kboutakhamt.bankaccount.domain.port.in;

import com.kboutakhamt.bankaccount.domain.Account;

/**
 * UC: create an account
 * 
 */
public interface IAccountCreationUseCase {

	Account create(Long id, String username, Long balance);

}
