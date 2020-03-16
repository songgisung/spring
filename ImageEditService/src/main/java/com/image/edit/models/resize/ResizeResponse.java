package com.image.edit.models.resize;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResizeResponse {

	@JsonProperty("result")
	private String result;

	@JsonProperty("image_width")
	private String imageWidth;

	@JsonProperty("image_height")
	private String imageHeight;

	@JsonProperty("image_binary")
	private String imageBinary;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
