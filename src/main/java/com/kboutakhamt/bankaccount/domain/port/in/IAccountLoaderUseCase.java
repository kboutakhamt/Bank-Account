package com.kboutakhamt.bankaccount.domain.port.in;

import com.kboutakhamt.bankaccount.domain.Account;

/**
 * UC: load an account
 * 
 */
public interface IAccountLoaderUseCase {

	Account get(Long id);

}
