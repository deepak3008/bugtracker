package com.example.bugs.mapper;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "userStory", description = "This payload contains user story "
		+ "information to be added into the bug tracking system")
public class UserStoryMapper {
	
	@ApiModelProperty(required=true)
	@NotBlank
	private String story;
	
	@ApiModelProperty(required=true)
	@NotBlank
	private String description;

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
