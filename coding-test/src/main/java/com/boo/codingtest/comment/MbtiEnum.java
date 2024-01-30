package com.boo.codingtest.comment;

public enum MbtiEnum {
	MBTI_INFJ("INFJ"), MBTI_INFP("INFP"), MBTI_ENFJ("ENFJ"), MBTI_ENFP("ENFP"), MBTI_INTJ("INTJ"), MBTI_INTP("INTP"),
	MBTI_ENTJ("ENTJ"), MBTI_ENTP("ENTP"), MBTI_ISFJ("ISFJ"), MBTI_ISFP("ISFP"), MBTI_ESFJ("ESFJ"), MBTI_ESFP("ESFP"),
	MBTI_ISTJ("ISTJ"), MBTI_ISTP("ISTP"), MBTI_ESTJ("ESTJ"), MBTI_ESTP("ESTP");

	private String value;

	MbtiEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static MbtiEnum getEnum(String value) {
		if (value == null) {
			return null;
		}

		for (MbtiEnum enumValue : values()) {
			if (value.equalsIgnoreCase(enumValue.getValue()))
				return enumValue;
		}

		return null;
	}
}
