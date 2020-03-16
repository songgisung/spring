package com.image.edit.models.resize;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResizeRequest {

	@JsonProperty("image_name")
	private String imageName;

	@JsonProperty("image_width")
	private String imageWidth;

	@JsonProperty("image_height")
	private String imageHeight;

	@JsonProperty("image_binary")
	private String imageBinary;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	public String getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}

	public String getImageBinary() {
		return imageBinary;
	}

	public void setImageBinary(String imageBinary) {
		this.imageBinary = imageBinary;
	}

}
