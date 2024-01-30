package com.boo.codingtest.comment;

public enum ZodiacEnum {

	ZODI_ARIES("aries"), ZODI_TAURUS("taurus"), ZODI_GEMINI("gemini"), ZODI_CANCER("cancer"), ZODI_LEO("leo"),
	ZODI_VIRGO("virgo"), ZODI_LIBRA("libra"), ZODI_SCORPIO("scorpio"), ZODI_SAGITTARIUS("sagittarius"),
	ZODI_CAPRICORN("capricorn"), ZODI_AQUARIUS("aquarius"), ZODI_PISCES("pisces");

	private String value;

	ZodiacEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static ZodiacEnum getEnum(String value) {
		if (value == null) {
			return null;
		}

		for (ZodiacEnum enumValue : values()) {
			if (value.equalsIgnoreCase(enumValue.getValue()))
				return enumValue;
		}

		return null;
	}
}
