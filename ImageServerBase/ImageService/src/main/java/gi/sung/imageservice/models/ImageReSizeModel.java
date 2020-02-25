package gi.sung.imageservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageReSizeModel {

	@JsonProperty("width")
	private int width;

	@JsonProperty("heigth")
	private int height;
}
