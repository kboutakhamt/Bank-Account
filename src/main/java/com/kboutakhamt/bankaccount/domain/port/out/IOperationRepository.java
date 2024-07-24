package com.kboutakhamt.bankaccount.domain.port.out;

import java.util.List;

import com.kboutakhamt.bankaccount.domain.Operation;

public interface IOperationRepository {

	List<Operation> getAll(Long id);

	Operation save(Operation operation);

//	Operation create(Account account, String type, Long amount, LocalDateTime operationDate);

}
