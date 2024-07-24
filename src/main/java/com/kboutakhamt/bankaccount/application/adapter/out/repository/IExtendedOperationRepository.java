package com.kboutakhamt.bankaccount.application.adapter.out.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kboutakhamt.bankaccount.application.adapter.out.entity.OperationEntity;

@Repository
@Transactional
public interface IExtendedOperationRepository extends JpaRepository<OperationEntity, Long> {

	public List<OperationEntity> findAllByAccountIdOrderByOperationDateDesc(Long id);

}
