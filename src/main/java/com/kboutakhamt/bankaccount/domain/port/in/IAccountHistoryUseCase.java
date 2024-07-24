package com.kboutakhamt.bankaccount.domain.port.in;

import java.util.List;

import com.kboutakhamt.bankaccount.domain.Operation;

/**
 * UC: view history of account
 * 
 */
public interface IAccountHistoryUseCase {

	List<Operation> getHistory(Long id);

}
