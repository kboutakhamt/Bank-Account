package com.kboutakhamt.bankaccount.domain.port.in;

/**
 * UC: deposit money to account
 * 
 */
public interface IAccountTransactionUseCase {

	Long process(Long id, String type, Long amount);

}
