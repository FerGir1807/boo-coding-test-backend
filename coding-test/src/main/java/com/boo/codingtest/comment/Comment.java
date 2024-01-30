package com.boo.codingtest.comment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.boo.codingtest.comment.like.Like;

import jakarta.validation.constraints.NotNull;

@Document("comments")
public class Comment {

	@Id
	private String id;
	@NotNull(message = "idUserCreator is mandatory")
	private String idUserCreator;
	@NotNull(message = "idUserDestination is mandatory")
	private String idUserDestination;
	private String description;
	private String mbti;
	private String enneagram;
	private String zodiac;
	private LocalDateTime creationDate;
	private int likes;
	private List<Like> likesDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUserCreator() {
		return idUserCreator;
	}

	public void setIdUserCreator(String idUserCreator) {
		this.idUserCreator = idUserCreator;
	}

	public String getIdUserDestination() {
		return idUserDestination;
	}

	public void setIdUserDestination(String idUserDestination) {
		this.idUserDestination = idUserDestination;
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

	public String getZodiac() {
		return zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Like> getLikesDetails() {
		return likesDetails;
	}

	public void setLikesDetails(List<Like> likesDetails) {
		this.likesDetails = likesDetails;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", idUserCreator=" + idUserCreator + ", idUserDestination=" + idUserDestination
				+ ", description=" + description + ", mbti=" + mbti + ", enneagram=" + enneagram + ", zodiac=" + zodiac
				+ ", creationDate=" + creationDate + ", likes=" + likes + ", likesDetails=" + likesDetails + "]";
	}

}
