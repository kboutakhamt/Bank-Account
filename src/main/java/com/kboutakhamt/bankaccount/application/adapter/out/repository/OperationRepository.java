package com.kboutakhamt.bankaccount.application.adapter.out.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.OperationEntity;
import com.kboutakhamt.bankaccount.application.adapter.out.entity.mapper.OperationMapper;
import com.kboutakhamt.bankaccount.domain.Operation;
import com.kboutakhamt.bankaccount.domain.port.out.IOperationRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OperationRepository implements IOperationRepository {

	private final IExtendedOperationRepository extendedOperationRepository;
	private final OperationMapper operationMapper;

	@Override
	public List<Operation> getAll(Long id) {
		List<Operation> list = extendedOperationRepository.findAllByAccountIdOrderByOperationDateDesc(id).stream()
				.map(operationMapper::mapEntityToDomain).toList();
		return list;

	}

//	@Override
//	public Operation create(Account account, String type, Long amount, LocalDateTime operationDate) {
//		Operation operation = new Operation(account, type, amount, operationDate);
//		return this.save(operation);
//	}

	@Override
	public Operation save(Operation operation) {
		OperationEntity operationEntity = operationMapper.mapDomainToEntity(operation);
		operationEntity = extendedOperationRepository.save(operationEntity);
		return operationMapper.mapEntityToDomain(operationEntity);
	}

}
