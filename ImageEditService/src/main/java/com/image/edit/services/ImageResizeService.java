package com.image.edit.services;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.image.edit.models.resize.ResizeRequest;


@Service
public class ImageResizeService {

	public ObjectMapper resize(ResizeRequest req) {

		ObjectMapper objectMapper = new ObjectMapper();

//		objectMapper.writeValue(new File("target/car.json"), car);
//		return objectMapper.writeValue(new File("target/car.json"), car);

		return objectMapper;
	}

}
