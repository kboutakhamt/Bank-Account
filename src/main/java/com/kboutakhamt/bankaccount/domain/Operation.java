package com.kboutakhamt.bankaccount.domain;

import java.time.LocalDateTime;

/**
 * 
 * Immutable recording of account operations and transactions
 * 
 */
public record Operation(Account account, String operationType, Long amount, LocalDateTime operationDate) {
}