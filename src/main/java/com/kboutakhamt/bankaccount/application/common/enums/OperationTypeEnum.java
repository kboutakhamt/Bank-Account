package com.kboutakhamt.bankaccount.application.common.enums;

public enum OperationTypeEnum {
	CREATION("CREATION"), DEPOSIT("DEPOSIT"), WITHDRAWAL("WITHDRAWAL"), HISTORY("HISTORY"), DELETION("DELETION");

	private final String label;

	private OperationTypeEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
