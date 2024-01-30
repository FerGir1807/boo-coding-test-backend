package com.boo.codingtest.comment.like;

import jakarta.validation.constraints.NotNull;

public class Like {
	@NotNull
	private String idUserCreator;
	private boolean active;

	public String getIdUserCreator() {
		return idUserCreator;
	}

	public void setIdUserCreator(String idUserCreator) {
		this.idUserCreator = idUserCreator;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Like [idUserCreator=" + idUserCreator + ", active=" + active + "]";
	}

}
