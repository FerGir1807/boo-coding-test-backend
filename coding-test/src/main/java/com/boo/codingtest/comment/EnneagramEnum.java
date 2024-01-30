package com.boo.codingtest.comment;

public enum EnneagramEnum {
	ENNE_1W2("1w2"), ENNE_2W3("2w3"), ENNE_3W2("3w2"), ENNE_3W4("3w4"), ENNE_4W3("4w3"), ENNE_4W5("4w5"),
	ENNE_5W4("5w4"), ENNE_5W6("5w6"), ENNE_6W5("6w5"), ENNE_6W7("6w7"), ENNE_7W6("7w6"), ENNE_7W8("7w8"),
	ENNE_8W7("8w7"), ENNE_8W9("8w9"), ENNE_9W8("9w8"), ENNE_9W1("9w1");

	private String value;

	EnneagramEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static EnneagramEnum getEnum(String value) {
		if (value == null) {
			return null;
		}

		for (EnneagramEnum enumValue : values()) {
			if (value.equalsIgnoreCase(enumValue.getValue()))
				return enumValue;
		}

		return null;
	}
}
