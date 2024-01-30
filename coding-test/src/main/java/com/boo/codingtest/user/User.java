package com.boo.codingtest.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document("users")
public class User {

	@Id
	private String id;
	@NotBlank(message = "Name is mandatory.")
	private String name;
	private String description;
	private String mbti;
	private String enneagram;
	private String variant;
	private int tritype;
	private String socionics;
	private String sloan;
	private String psyche;
	private String image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getEnneagram() {
		return enneagram;
	}

	public void setEnneagram(String enneagram) {
		this.enneagram = enneagram;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public int getTritype() {
		return tritype;
	}

	public void setTritype(int tritype) {
		this.tritype = tritype;
	}

	public String getSocionics() {
		return socionics;
	}

	public void setSocionics(String socionics) {
		this.socionics = socionics;
	}

	public String getSloan() {
		return sloan;
	}

	public void setSloan(String sloan) {
		this.sloan = sloan;
	}

	public String getPsyche() {
		return psyche;
	}

	public void setPsyche(String psyche) {
		this.psyche = psyche;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description + ", mbti=" + mbti + ", enneagram="
				+ enneagram + ", variant=" + variant + ", tritype=" + tritype + ", socionics=" + socionics + ", sloan="
				+ sloan + ", psyche=" + psyche + ", image=" + image + "]";
	}
}
