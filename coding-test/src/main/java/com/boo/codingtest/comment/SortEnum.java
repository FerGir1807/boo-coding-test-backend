package com.boo.codingtest.comment;

public enum SortEnum {
	RECENT("recent"), BEST("best");

	private String value;

	SortEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static SortEnum getEnum(String value) {
		if (value == null) {
			return null;
		}

		for (SortEnum enumValue : values()) {
			if (value.equalsIgnoreCase(enumValue.getValue()))
				return enumValue;
		}

		return null;
	}

}
