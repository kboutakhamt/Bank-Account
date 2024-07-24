package com.kboutakhamt.bankaccount.application.common.utils;

import org.springframework.stereotype.Component;

import com.kboutakhamt.bankaccount.application.common.enums.OperationTypeEnum;
import com.kboutakhamt.bankaccount.application.common.exception.IllegalAmountException;

@Component
public class AccountUtils {

	public void checkAccountCreationArgs(Long id, String username, Long balance) {
		if (id <= 0) {
			throw new IllegalArgumentException("invalid account id! " + id);
		}

		if (username == "") {
			throw new IllegalArgumentException("invalid account username! " + username);
		}

		if (balance < 0) {
			throw new IllegalArgumentException("Balance must be zero or positive! " + balance);
		}
	}

	public void checkAccountTransactionArgs(Long id, String type, Long amount) {
		if (id <= 0) {
			throw new IllegalArgumentException("invalid account id! " + id);
		}

		if (type != OperationTypeEnum.DEPOSIT.getLabel() || type != OperationTypeEnum.WITHDRAWAL.getLabel()) {
			throw new IllegalArgumentException("invalid transaction type! " + type);
		}

		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive! " + amount);
		}
	}

	public void checkWithdrawalAmount(String type, Long balance, Long amount) {
		if (OperationTypeEnum.WITHDRAWAL.getLabel().equals(type) && amount > balance) {
			throw new IllegalAmountException(
					"Insufficient account balance: " + balance + " / Amount requested: " + amount);
		}

	}

}